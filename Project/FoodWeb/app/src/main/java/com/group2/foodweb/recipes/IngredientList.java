package com.group2.foodweb.recipes;

/**
 * Created by Zach on 10/19/2021.
 */

public class IngredientList {
    private final int INGREDIENT_NOT_FOUND = -999;
    private final int DEFAULT_LIST_SIZE = 128;

    private Ingredient[] ingredients;
    private int ingredientListSize;

    // Default constructor
    public IngredientList()
    {
        ingredientListSize = DEFAULT_LIST_SIZE;
        ingredients = new Ingredient[ ingredientListSize ];
    }
    // Copy constructor
    public IngredientList(IngredientList copy )
    {
        int index;

        ingredientListSize = copy.ingredientListSize;
        ingredients = new Ingredient[ ingredientListSize ];

        for ( index = 0; index < ingredientListSize; index++ )
        {
            ingredients[ index ] = copy.ingredients[ index ];
        }
    }

    public void addIngredient( Ingredient newIngredient )
    {
        int insertIndex, attempts = 0;

        insertIndex = generateHash( newIngredient );

        if ( ingredients[ insertIndex ] != null )
        {
            while ( ingredients[ insertIndex ] != null && attempts < ingredientListSize )
            {
                attempts++;

                // TODO: Resize (if deemed necessary)

                // increment index w/ quadratic, keep within bounds
                insertIndex += Math.pow( attempts, 2 );
                insertIndex %= ingredientListSize;

            }
        }
    }

    // Creates a new ingredient object to be added to the list
    public void addIngredientFromButton(String name, double amount)
    {
        Ingredient newIngredient;

        newIngredient = new Ingredient(name, amount);

        addIngredient(newIngredient);

    }

    public void removeIngredient( String toBeRemoved )
    {
        int removeIndex;
        Ingredient ingredientToRemove = new Ingredient(toBeRemoved, 0);

        // get index of item
        removeIndex = findIngredientIndex( ingredientToRemove );

        // check if item can be found
        if ( removeIndex != INGREDIENT_NOT_FOUND )
        {
            // set value to null
            ingredients[ removeIndex ] = null;

        }
    }

    /**
    public void changeIngredientName( Ingredient ingredientToChange, String newName )
    {
        Ingredient changedIngredient;

        changedIngredient = new Ingredient( ingredientToChange );
        changedIngredient.ingredientName = newName;

        removeIngredient( ingredientToChange );
        addIngredient( changedIngredient );
    }
    **/
    private int findIngredientIndex( Ingredient ingredientToFind )
    {
        int itemIndex, attempts = 0;

        itemIndex = generateHash( ingredientToFind );

        // quadratic probing
        // loop while item not found and not at end of list
        while ( ingredients[ itemIndex ].ingredientName
                .compareTo( ingredientToFind.ingredientName ) != 0
                && attempts < ingredientListSize )
        {
            attempts++;

            // reached end of bounds
            if ( attempts == ingredientListSize )
            {
                return INGREDIENT_NOT_FOUND;
            }

            itemIndex += Math.pow( attempts, 2 );
            itemIndex %= ingredientListSize;

        }

        return itemIndex;
    }

    private int generateHash( Ingredient ingredient )
    {
        int charIndex, hashIndex = 0;

        // sum ASCII character values - Josh Bloch Recipe for hash codes
        for ( charIndex = 0; charIndex < ingredient.ingredientName.length(); charIndex++ )
        {
            hashIndex += (int)ingredient.ingredientName.charAt( charIndex );
        }

        // convert to usable index
        hashIndex %= ingredientListSize;

        return hashIndex;
    }

}
