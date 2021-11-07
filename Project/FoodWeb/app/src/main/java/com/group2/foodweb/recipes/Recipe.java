package com.group2.foodweb.recipes;

/**
 * Created by Zach on 9/30/2021.
 */

public class Recipe {

    private final int INGREDIENT_NOT_FOUND = -999;
    private final int DEFAULT_LIST_SIZE = 128;

    private IngredientList ingredients;

    public String title;
    public String description;
    public String instructions;
    public String author;

    // Default constructor
    public Recipe()
    {
        ingredients = new IngredientList();
    }
    // Copy constructor
    public Recipe(Recipe copy )
    {
        ingredients = new IngredientList(copy.ingredients);

        title = copy.title;
        description = copy.description;
        instructions = copy.instructions;
        author = copy.author;

    }

    // Initialization constructor
    public Recipe(String recipeTitle, String recipeDescription, String recipeInstructions, IngredientList ingredientList )
    {
        title = recipeTitle;
        description = recipeDescription;
        instructions = recipeInstructions;
        ingredients = ingredientList;
    }

    public void addIngredient( Ingredient newIngredient )
    {
        ingredients.addIngredient( newIngredient );
    }

    public void removeIngredient( String toBeRemoved )
    {
        ingredients.removeIngredient( toBeRemoved );
    }



}
