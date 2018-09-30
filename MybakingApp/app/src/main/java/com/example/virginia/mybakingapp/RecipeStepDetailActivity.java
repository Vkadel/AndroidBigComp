package com.example.virginia.mybakingapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * An activity representing a single Recipe detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link RecipeListActivity}.
 */

public class RecipeStepDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

       final Bundle savedInstanceStateFinal=savedInstanceState;
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        RecipeViewModel viewModel=ViewModelProviders.of(this).get(RecipeViewModel.class);
        viewModel.getRecipes().observe(this, new Observer<ArrayList<Recipe>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Recipe> recipes) {
                //Create and update Fragment
                RecipeStepFragment fragment = new RecipeStepFragment();
                RecipeDetailFragment fragmentDetail=new RecipeDetailFragment();
                    if (savedInstanceStateFinal==null){
                    // Create the detail fragment and add it to the activity
                    // using a fragment transaction.
                    Bundle arguments = new Bundle();
                    arguments.putString(RecipeStepFragment.ARG_ITEM_ID,
                            getIntent().getStringExtra(RecipeDetailFragment.ARG_ITEM_ID));
                        arguments.putString(RecipeStepFragment.ARG_STEP_ID,
                                getIntent().getStringExtra(RecipeDetailFragment.ARG_ITEM_ID));
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.recipe_detail_container, fragment)
                            .commit();
                    fragmentDetail.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.recipe_detail_container,fragment)
                            .commit();
                    }

                            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, RecipeListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView, ArrayList<RecipeStep> RecipeSteps) {
        recyclerView.setAdapter(new RecipeStepDetailActivity.SimpleItemRecyclerViewAdapter(this, RecipeSteps));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<RecipeStepDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final RecipeStepDetailActivity mParentActivity;
        private final ArrayList<RecipeStep> mValues;

        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecipeStep item = mValues.get(Integer.parseInt(view.getTag().toString())-1);
                    //TODO CREATE INTENT FOR VIDEO Screen
                    Context context = view.getContext();
                    Intent intent = new Intent(context, RecipeStepDetailActivity.class);
                    intent.putExtra(RecipeStepFragment.ARG_ITEM_ID, item.getId());
                    context.startActivity(intent);
            }
        };

        SimpleItemRecyclerViewAdapter(RecipeStepDetailActivity parent,
                                      ArrayList<RecipeStep> items) {
            mValues = items;
            mParentActivity = parent;
        }

        @Override
        public RecipeStepDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recipe_list_item, parent, false);
            return new RecipeStepDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final RecipeStepDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder holder, int position) {
            holder.mDescription.setText(mValues.get(position).getDescription());
            holder.mShortDescription.setText(mValues.get(position).getShortDescription());

            holder.itemView.setTag(mValues.get(position).getId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            if(mValues==null){return 0;}
            else{return mValues.size();}
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mDescription;
            final TextView mShortDescription;

            ViewHolder(View view) {
                super(view);
                mDescription = (TextView) view.findViewById(R.id.description);
                mShortDescription = (TextView) view.findViewById(R.id.short_description);
            }
        }
    }
}
