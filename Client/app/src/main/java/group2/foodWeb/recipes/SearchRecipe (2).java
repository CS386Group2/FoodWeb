package group2.foodweb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PublishRecipe extends AppCompatActivity implements View.OnClickListener
{
    //TODO: set recipeList to PublishedRecipeList
    private String[] recipeList = [recipe1, recipe2, recipe3];
    //TODO: set recipeListSize
    private int recipeListSize = 3;

    //TODO: set user input to userInput
    private String userInput = "";

    //Returns closest matches for user input (display up to the first 5 as suggested results)
    private String[] searchRecipeList()
    {
        String[] matches = new String[recipeListSize];
        int matchesIndex = 0;
        for(int index = 0; index < recipeListSize; index++)
        {
            if(recipeList[index].contains(userInput) == true)
            {
                matches[matchesIndex] = recipeList[index];
                matchesIndex++;
            }
        }
        return matches;
    }

    //TODO: action listener for user clicking on a suggested result

    //TODO: Open recipe on UI

}