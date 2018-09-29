package com.example.virginia.mybakingapp;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.virginia.mybakingapp.Internet.GetString;

import java.util.ArrayList;

import timber.log.Timber;

public class RecipeViewModel extends ViewModel   {
    public RecipeViewModel() {
        super();
        String myRecipes= String.valueOf(new GetString());
        Timber.e(myRecipes);
    }



}
