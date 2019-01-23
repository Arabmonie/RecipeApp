package com.droidplate.recipeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.droidplate.recipeapp.Pojo.Recipe;

public class DetailActivity extends AppCompatActivity {
    TextView recipeName, Ingredients, description, fats, proteins, carbos;
    ImageView recipeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        recipeImage = findViewById(R.id.thumb);
        recipeName = findViewById(R.id.recipeNameTV);
       // deliverableIngredints = findViewById(R.id.deliverable_ingredients);
        description = findViewById(R.id.descriptionTV);
        proteins = findViewById(R.id.proteins);
        fats = findViewById(R.id.fatsTV);
        carbos = findViewById(R.id.carbos);

//
        String name = getIntent().getExtras().getString("recipe_name");
        String descriptions = getIntent().getExtras().getString("description");
        String fat = getIntent().getExtras().getString("fats");
        String image = getIntent().getExtras().getString("image");

        recipeName.setText(name);
        description.setText(descriptions);
        fats.setText(fat);


        Glide.with(this).load(image).into(recipeImage);


    }

}
