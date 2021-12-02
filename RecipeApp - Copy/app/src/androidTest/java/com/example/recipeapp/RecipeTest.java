package com.example.recipeapp;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import com.example.recipeapp.Model.createRecipe;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class RecipeTest {
    String testName = "test";
    String testDescription = "description";
    String testIngredients = "t1, t2, t3, t4";
    String testImageURL = "image.png";

    @Test
    public void testCreateRecipe() {
        createRecipe test = new createRecipe(testName, testDescription, testIngredients, testImageURL);
        assertEquals(testName, test.getName());

    }

    @Test
    public void testSetName() {
        createRecipe test = new createRecipe(testName, testDescription, testIngredients, testImageURL);

        test.setName("New Name");

        assertEquals("New Name", test.getName());
    }

    @Test
    public void testSetDescription() {
        createRecipe test = new createRecipe(testName, testDescription, testIngredients, testImageURL);

        test.setDescription("New Description");

        assertEquals("New Description", test.getDescription());
    }

    @Test
    public void testSetIngredients() {
        createRecipe test = new createRecipe(testName, testDescription, testIngredients, testImageURL);

        test.setIngredients("A1, B1, C1");

        assertEquals("A1, B1, C1", test.getIngredients());
    }

    @Test
    public void testSetURL() {
        createRecipe test = new createRecipe(testName, testDescription, testIngredients, testImageURL);

        test.setUrlOfImage("test.png");

        assertEquals("test.png", test.getUrlOfImage());
    }

}