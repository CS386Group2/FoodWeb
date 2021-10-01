package com.group2.foodweb;

/**
 * Created by Zach on 9/30/2021.
 */

public class ManageIngredients {

    private final int INGREDIENT_NOT_FOUND = -999;

    private Ingredient ingredients[];
    private int ingredientListSize;

    public void addIngredient()
    {

    }

    public void removeIngredient( Ingredient toBeRemoved )
    {
        // initialize variables
        int removeIndex;
        Ingredient removed;

        // get index of item
        removeIndex = findIngredientIndex( toBeRemoved );

        // check if item can be found
        if ( removeIndex != INGREDIENT_NOT_FOUND )
        {
            // set value to null
            ingredients[ removeIndex ] = null;

        }
    }

    public void editIngredientAmt()
    {

    }

    public void editIngredientName()
    {

    }

    private int findIngredientIndex( Ingredient ingredientToFind )
    {
        int itemIndex, attempts = 0;

        itemIndex = generateHash( ingredientToFind );

        while( ingredients[ itemIndex ].compareTo( ingredientToFind ) != 0
                && attempts < ingredientListSize )
        {
            attempts++;

            if ( attempts == ingredientListSize )
            {
                return INGREDIENT_NOT_FOUND;
            }

            itemIndex += Math.pow( attempts, 2 );
            itemIndex %= ingredientListSize;

        }

        return itemIndex;
    }

    private int generateHash( Ingredient ingredientToHash )
    {
        return 0;
    }

}
