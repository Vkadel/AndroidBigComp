package com.example.virginia.mybakingapp;

class RecipeIngredient {
    int mIngredientId;
    double mIngredientQuantity;
    String mIngredientMeasure;
    String mIngredientName;
    public RecipeIngredient(int ingredientId, double ingredientQuantity,
                            String ingredientMeasure, String ingredientName){
        mIngredientId=ingredientId;
        mIngredientQuantity=ingredientQuantity;
        mIngredientMeasure=ingredientMeasure;
        mIngredientName=ingredientName;
    }

    public void setmIngredientId(int mIngredientId) {
        this.mIngredientId = mIngredientId;
    }

    public void setmIngredientMeasure(String mIngredientMeasure) {
        this.mIngredientMeasure = mIngredientMeasure;
    }

    public void setmIngredientName(String mIngredientName) {
        this.mIngredientName = mIngredientName;
    }

    public void setmIngredientQuantity(int mIngredientQuantity) {
        this.mIngredientQuantity = mIngredientQuantity;
    }

    public int getmIngredientId() {
        return mIngredientId;
    }

    public double getmIngredientQuantity() {
        return mIngredientQuantity;
    }

    public String getmIngredientMeasure() {
        return mIngredientMeasure;
    }

    public String getmIngredientName() {
        return mIngredientName;
    }
}
