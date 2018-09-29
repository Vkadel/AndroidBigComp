package com.example.android.mybakeapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapterRecipes extends RecyclerView.Adapter<MyAdapterRecipes.MyViewHolder> {
    private ArrayList<Recipe> mDataset;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myRecipeView= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_recipe_card,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(myRecipeView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        TextView myNameTextView=myViewHolder.mRecipeView.findViewById(R.id.tv_recipe_name);
        TextView servings=myViewHolder.mRecipeView.findViewById(R.id.tv_recipe_nb_servings);

        Recipe myRecipe=mDataset.get(i);
        //Set up Recipe Name to view: tv_recipe_name in the adapter
        myNameTextView.setText(myRecipe.mRecipeName);
        servings.setText(""+myRecipe.mRecipeServings);
    }

    @Override
    public int getItemCount() {
        if(mDataset!=null){
            return mDataset.size();
        }else{
        return 0;}
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mRecipeView;

        public MyViewHolder(View v) {
            super(v);
            mRecipeView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterRecipes(ArrayList<Recipe>myDataset) {
        mDataset = myDataset;
    }
}

