package com.e.cameraimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.label.ImageLabel;
import com.google.mlkit.vision.label.ImageLabeler;
import com.google.mlkit.vision.label.ImageLabeling;
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions;
import com.mindorks.paracamera.Camera;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button cameraButton;
    ImageView cameraImage;

    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.cameraButton);
        cameraImage = findViewById(R.id.cameraImage);

        camera = new Camera.Builder()
                .resetToCorrectOrientation(true)// it will rotate the camera bitmap to the correct orientation from meta data
                .setTakePhotoRequestCode(1)
                .setDirectory("pics")
                .setName("ali_" + System.currentTimeMillis())
                .setImageFormat(Camera.IMAGE_JPEG)
                .setCompression(75)
                .setImageHeight(1000)// it will try to achieve this height as close as possible maintaining the aspect ratio;
                .build(this);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    camera.takePicture();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    // Get the bitmap and image path onActivityResult of an activity or fragment
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Camera.REQUEST_TAKE_PHOTO){
            Bitmap bitmap = camera.getCameraBitmap();
            if(bitmap != null) {
                cameraImage.setImageBitmap(bitmap);
                InputImage image = InputImage.fromBitmap(bitmap, 0);
                getLabels(image);
            }else{
                Toast.makeText(this.getApplicationContext(),"Picture not taken!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    // The bitmap is saved in the app's folder
//  If the saved bitmap is not required use following code
    @Override
    protected void onDestroy() {
        super.onDestroy();
        camera.deleteImage();
    }

    void getLabels(InputImage image){
        ImageLabeler labeler = ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS);

        labeler.process(image)
                .addOnSuccessListener(new OnSuccessListener<List<ImageLabel>>() {
                    @Override
                    public void onSuccess(List<ImageLabel> labels) {
                        // Task completed successfully
                        // ...
                        String text = "";

                        for(ImageLabel label : labels){
                            text = label.getText()+"  probability:"+label.getConfidence()+"  ";
                        }

                        Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Task failed with an exception
                        // ...
                    }
                });

    }

}