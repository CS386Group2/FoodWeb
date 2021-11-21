package com.example.recipeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.Adapter.DataAdapter;
import com.example.recipeapp.Model.createRecipe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
RecyclerView recyclerView;
ArrayList<createRecipe> arrayList;

DataAdapter adapter;
DatabaseReference databaseReference;

ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       // recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,
         //       RecyclerView.VERTICAL, false));
       // recyclerView.setHasFixedSize(true);

        //arrayList = new ArrayList<>();

        //progressDialog = new ProgressDialog(this);
       // progressDialog.setMessage("Recipes Loading...");
        /*
        databaseReference = FirebaseDatabase.getInstance().getReference("RecipeApp");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
                {
                    for (DataSnapshot ds:snapshot.getChildren())
                        {
                        createRecipe recipe = ds.getValue(createRecipe.class);
                        arrayList.add(recipe);
                        }

                    adapter = new DataAdapter(MainActivity.this, arrayList);
                    recyclerView.setAdapter(adapter);

                    progressDialog.dismiss();

                }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
                {
                    Toast.makeText(MainActivity.this, "Error"+error.getMessage(),
                            Toast.LENGTH_SHORT).show();

                    progressDialog.dismiss();

                }
        });

         */

    }

    public void uploadClick(View view)
    {
        startActivity(new Intent( MainActivity.this,uploadActivity.class));
    }
}
