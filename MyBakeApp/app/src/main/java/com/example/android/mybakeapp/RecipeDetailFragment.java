package com.example.android.mybakeapp;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A fragment representing a single Recipe detail screen.
 * This fragment is either contained in a {@link RecipeListActivity}
 * in two-pane mode (on tablets) or a {@link RecipeDetailActivity}
 * on handsets.
 */
public class RecipeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "Recipe_id";


    private Recipe thisRecipe;
    private ViewModel viewModel;
    private ArrayList<Recipe> myArrayOfRecipes;
    private ArrayList<RecipeStep> recipeSteps;
    private ArrayList<RecipeIngredient> mRecipeIngredients;
    CollapsingToolbarLayout appBarLayout;
    Boolean isTheFirstTime;
    View rootView;
    private String this_ingredients_serve = null;
    private String servings_word = null;
    private String measure_word;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isTheFirstTime = (savedInstanceState == null);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            Activity activity = this.getActivity();
            appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            this_ingredients_serve = getActivity().getResources().getString(R.string.this_ingredients_serve);
            servings_word = getActivity().getResources().getString(R.string.servings_word);
            measure_word = getActivity().getResources().getString(R.string.measure_word);
            viewModel = ViewModelProviders.of
                    (this).get(RecipeViewModel.class);

            ((RecipeViewModel) viewModel).getRecipes().observe
                    (this, new Observer<ArrayList<Recipe>>() {
                        @Override
                        public void onChanged(@Nullable ArrayList<Recipe> recipes) {
                            //Update UI once the array gets the data
                            myArrayOfRecipes = ((RecipeViewModel) viewModel).getRecipes().getValue();
                            thisRecipe = myArrayOfRecipes.get(Integer.parseInt(getArguments().getString(ARG_ITEM_ID)));
                            ((TextView) rootView.findViewById(R.id.recipe_detail)).setText
                                    (this_ingredients_serve + " " + thisRecipe.mRecipeServings
                                            + " " + servings_word);
                            TextView ingredients = rootView.findViewById(R.id.tv_ingredients);
                            ArrayList<RecipeIngredient> thisRecipeIngredients = thisRecipe.getMyRecipeIngredients();
                            String myIngredientsString = "\n\n";
                            for (int i = 0; i < thisRecipeIngredients.size(); i++) {

                                myIngredientsString = myIngredientsString+" " + thisRecipeIngredients.get(i).mIngredientQuantity
                                        +" "+thisRecipeIngredients.get(i).mIngredientMeasure + " of ";
                                myIngredientsString = myIngredientsString + thisRecipeIngredients.get(i).mIngredientName + "\n\n";

                            }
                            ingredients.setText(myIngredientsString);
                            if (appBarLayout != null) {
                                appBarLayout.setTitle(thisRecipe.getmRecipeName());

                            }
                        }
                    });

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.recipe_detail, container, false);

        // Show the dummy content as text in a TextView.

        return rootView;
    }


}
