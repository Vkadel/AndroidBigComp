package com.example.virginia.mybakingapp;

import java.util.ArrayList;

public class Recipe {
    String mrecipeid;
    String mrecipeName;
    String mrecipeServings;
    ArrayList<RecipeStep> mrecipeSteps;
    ArrayList<RecipeIngredient> mrecipeIngredients;

    public Recipe(String recipeid,String recipeServings,String recipeName,
                  ArrayList<RecipeStep> recipeSteps,ArrayList<RecipeIngredient> recipeIngredients) {
        mrecipeid=recipeid;
        mrecipeName=recipeName;
        mrecipeServings=recipeServings;
        mrecipeSteps=recipeSteps;
        mrecipeIngredients=recipeIngredients;
    }

    public void setMrecipeid(String mrecipeid) {
        this.mrecipeid = mrecipeid;
    }

    public void setMrecipeIngredients(ArrayList<RecipeIngredient> mrecipeIngredients) {
        this.mrecipeIngredients = mrecipeIngredients;
    }

    public void setMrecipeName(String mrecipeName) {
        this.mrecipeName = mrecipeName;
    }

    public void setMrecipeServings(String mrecipeServings) {
        this.mrecipeServings = mrecipeServings;
    }

    public void setMrecipeSteps(ArrayList<RecipeStep> mrecipeSteps) {
        this.mrecipeSteps = mrecipeSteps;
    }

    public String getMrecipeServings() {
        return mrecipeServings;
    }

    public ArrayList<RecipeIngredient> getMrecipeIngredients() {
        return mrecipeIngredients;
    }

    public ArrayList<RecipeStep> getMrecipeSteps() {
        return mrecipeSteps;
    }

    public String getMrecipeid() {
        return mrecipeid;
    }

    public String getMrecipeName() {
        return mrecipeName;
    }
}
