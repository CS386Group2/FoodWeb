package com.example.recipeapp.Model;

public class createRecipe {
    String name;
    String description;
    String ingredients;
    String urlOfImage;

    //
    public createRecipe( String name, String description,
                         String ingredients, String imageUrl )
        {
            this.name = name;
            this.description = description;
            this.ingredients = ingredients;
            this.urlOfImage = imageUrl;

        }
    //constructor
    public createRecipe()
        {

        }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients(){
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getUrlOfImage() {
        return urlOfImage;
    }

    public void setUrlOfImage(String urlOfImage) {
        this.urlOfImage = urlOfImage;
    }
}
