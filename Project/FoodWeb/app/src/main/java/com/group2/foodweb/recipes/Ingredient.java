package com.group2.foodweb.recipes;

/**
 * Created by Zach on 9/30/2021.
 */

public class Ingredient
{

    private final int STORED = 101;
    private final int NEEDED = 202;

    // used for display and hash creation
    // should only be changed by Recipe to avoid issues with hashing
    public String ingredientName;

    // ingredient storage
    private double amountStored;
    private double amountNeeded;

    // Init constructor: name only
    public Ingredient( String name )
    {
        ingredientName = name;
        amountStored = 0;
        amountNeeded = 0;
    }

    // Init constructor: name and storage value
    public Ingredient( String name, double stored )
    {
        ingredientName = name;
        amountStored = stored;
        amountNeeded = 0;
    }

    // Copy constructor
    public Ingredient( Ingredient ingredientToCopy )
    {
        ingredientName = ingredientToCopy.ingredientName;
        amountStored = ingredientToCopy.amountStored;
        amountNeeded = ingredientToCopy.amountNeeded;
    }

    public void changeStorage( int valueToChange, double newValue )
    {
        if ( valueToChange == STORED )
        {
            amountStored = newValue;
        }
        else if ( valueToChange == NEEDED )
        {
            amountNeeded = newValue;
        }
    }


}
