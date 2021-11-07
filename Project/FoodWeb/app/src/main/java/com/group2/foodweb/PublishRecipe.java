package com.group2.foodweb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.group2.foodweb.recipes.*;

public class PublishRecipe extends AppCompatActivity implements View.OnClickListener {

    private EditText field_recipeName;
    private EditText field_description;
    private EditText field_instructions;

    private String recipeName;
    private String description;
    private String instructions;
    private String ingredientName;

    double ingredientAmt;

    private IngredientList ingredientList;

    MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_recipe);

        // Instantiate buttons
        Button button_addIngredient = (Button) findViewById(R.id.button_add_ingredient);
        Button button_removeIngredient = (Button) findViewById(R.id.button_remove_ingredient);
        Button button_publishRecipe = (Button) findViewById(R.id.button_publish_recipe);

        // Instantiate text fields
        EditText field_recipeName = (EditText) findViewById(R.id.field_recipe_name);
        EditText field_description = (EditText) findViewById(R.id.field_description);
        EditText field_instructions = (EditText) findViewById(R.id.field_instructions);

        // Set on click listeners for buttons
        button_addIngredient.setOnClickListener(this);
        button_removeIngredient.setOnClickListener(this);
        button_publishRecipe.setOnClickListener(this);

        ingredientList = new IngredientList();


    }

    // Manage any button clicks
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add_ingredient:
                ingredientList.addIngredientFromButton(ingredientName, ingredientAmt);

            case R.id.button_remove_ingredient:
                ingredientList.removeIngredient(ingredientName);

            case R.id.button_publish_recipe:
                createRecipe( recipeName, description, instructions, ingredientList );

        }
    }

    protected void onResume() {

        recipeName = field_recipeName.toString();
        description = field_description.toString();
        instructions = field_instructions.toString();

    }

    //
    private void publishRecipe(Recipe recipe)
    {
        // add recipe to main recipe list
        main.mainRecipeList.addRecipe(recipe);

        // TODO: JUNIT test

        // TODO: end activity, go back to main screen

    }

    private void createRecipe( String name, String description, String instructions, IngredientList ingredientList )
    {
        Recipe newRecipe = new Recipe( name, description, instructions, ingredientList );

    }

}
