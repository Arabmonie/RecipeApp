package com.droidplate.recipeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.droidplate.recipeapp.Adapter.RecipeAdapter;
import com.droidplate.recipeapp.Pojo.Recipe;
import com.droidplate.recipeapp.api.Client;
import com.droidplate.recipeapp.api.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.RecipeOnClickListener {

    RecyclerView recyclerView;
    static List<Recipe> recipeList;
    RecipeAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recipeAdapter = new RecipeAdapter(this, recipeList);
        recyclerView.setAdapter(recipeAdapter);

        Service service = Client.getclient().create(Service.class);
        Call <List<Recipe>> call = service.getRecipes();
        Log.e("TAG", "url " + call.request().url().toString());
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                Log.d("TAG", "Response... " + response.body().toString() );

                recipeList = response.body();
                recipeAdapter.setRecipeList(recipeList);

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

                Log.d("TAG", "Response... " + t.getMessage());

            }
        });


    }

    @Override
    public void click(int pos) {
        Recipe recipe = recipeList.get(pos);
        Log.e("Receipt:",recipe.getName());
        Toast.makeText(this,recipe.getName(),Toast.LENGTH_SHORT).show();
    }

    public static Recipe getRecipe(int pos){

        return recipeList.get(pos);
    }

}
