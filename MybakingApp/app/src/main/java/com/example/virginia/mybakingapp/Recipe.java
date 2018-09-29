package com.example.virginia.mybakingapp;

    import java.util.ArrayList;

    public class Recipe {
        int mId;
        String mRecipeName;
        ArrayList<RecipeIngredient> MyRecipeIngredients;
        ArrayList<RecipeStep> MyRecipeSteps;
        int mRecipeServings;
        String mRecipeImage;

        public Recipe(int Id, String RecipeName, ArrayList<RecipeIngredient> recipeIngredients,
                      ArrayList<RecipeStep> recipeSteps, int recipeServings, String RecipeImage) {
            mId = Id;
            mRecipeName = RecipeName;
            MyRecipeIngredients=recipeIngredients;
            MyRecipeSteps=recipeSteps;
            mRecipeServings=recipeServings;
            mRecipeImage=RecipeImage;
        }

        public void setmId(int mId) {
            this.mId = mId;
        }

        public void setmRecipeImage(String mRecipeImage) {
            this.mRecipeImage = mRecipeImage;
        }

        public void setmRecipeServings(int mRecipeServings) {
            this.mRecipeServings = mRecipeServings;
        }

        public void setmRecipeName(String mRecipeName) {
            this.mRecipeName = mRecipeName;
        }

        public void setMyRecipeIngredients(ArrayList<RecipeIngredient> myRecipeIngredients) {
            MyRecipeIngredients = myRecipeIngredients;
        }

        public void setMyRecipeSteps(ArrayList<RecipeStep> myRecipeSteps) {
            MyRecipeSteps = myRecipeSteps;
        }

        public int getmId() {
            return mId;
        }

        public ArrayList<RecipeIngredient> getMyRecipeIngredients() {
            return MyRecipeIngredients;
        }

        public ArrayList<RecipeStep> getMyRecipeSteps() {
            return MyRecipeSteps;
        }

        public int getmRecipeServings() {
            return mRecipeServings;
        }

        public String getmRecipeImage() {
            return mRecipeImage;
        }

        public String getmRecipeName() {
            return mRecipeName;
        }

    }
