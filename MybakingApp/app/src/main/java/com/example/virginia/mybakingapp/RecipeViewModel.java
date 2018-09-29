package com.example.virginia.mybakingapp;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.virginia.mybakingapp.Internet.GetString;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class RecipeViewModel extends ViewModel{
    ArrayList<Recipe> myRecipies;

    public RecipeViewModel() {
        super();


    }
public class myCalltoGetdata extends AsyncTask{

    @Override
    protected void onPostExecute(Object o) {
        //Update Data
        super.onPostExecute(o);
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        GetString getString=new GetString();
        getString;
        return null;
    }
}


}
