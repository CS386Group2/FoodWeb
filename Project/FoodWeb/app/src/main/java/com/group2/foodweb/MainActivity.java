package com.group2.foodweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.group2.foodweb.recipes.*;

public class MainActivity extends AppCompatActivity {

    public PublishedRecipeList mainRecipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRecipeList = new PublishedRecipeList();
    }
}
