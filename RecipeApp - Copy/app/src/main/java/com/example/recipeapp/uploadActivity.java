package com.example.recipeapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.recipeapp.Model.createRecipe;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;


public class uploadActivity extends AppCompatActivity {

    // corresponds to upload activity xml
    ImageView imageView;
    EditText editRecipeName;
    EditText editDescription;
    EditText editIngredients;


    // used for uploading
    Uri uri;

    //
    String urlOfImage;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_upload);

        imageView = findViewById(R.id.imageView);

        editRecipeName = findViewById(R.id.recipeName);
        editDescription = findViewById(R.id.recipeDescription);
        editIngredients = findViewById(R.id.ingredients);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    100);

            }
        else
            {
            Toast.makeText(this, "Permissions Granted", Toast.LENGTH_SHORT).show();
            }
    }

    public void recipeImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //noinspection deprecation
        startActivityForResult(intent, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null && data.getData()!=null )
            {
            uri = data.getData();
            imageView.setImageURI(uri);
            }
        else
            {
            Toast.makeText(this, "please select an image", Toast.LENGTH_SHORT).show();
            }
    }

    public void uploadRecipe(View view)
    {


        //uploadRecipe();
    }

    public void uploadImage()
        {

            // shows the progress of the image uploading
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Image is Uploading");
            progressDialog.show();

            StorageReference storageReference=
                    FirebaseStorage.getInstance().getReference().child("RecipeApp")
                            .child(uri.getLastPathSegment());

            storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Task task = taskSnapshot.getStorage().getDownloadUrl();

                    //while (  !task.isSuccessful() );
                    Uri uriOfImage = (Uri) task.getResult();
                    urlOfImage = uriOfImage.toString();
                    uploadRecipe();
                    progressDialog.dismiss();;
                    Toast.makeText(uploadActivity.this,
                            "Image Successfully Uploaded", Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(uploadActivity.this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });


        }



    public void uploadRecipe()
        {

            String name = editRecipeName.getText().toString().trim();
            String recipeDescription = editDescription.getText().toString().trim();
            String ingredients = editIngredients.getText().toString().trim();

            String timeStamp= DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

            createRecipe newRecipe = new createRecipe(name, recipeDescription, ingredients, urlOfImage );

            FirebaseDatabase.getInstance().getReference("RecipeApp").child(timeStamp)
                            .setValue(newRecipe).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid ) {
                    Toast.makeText(uploadActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(uploadActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }

}