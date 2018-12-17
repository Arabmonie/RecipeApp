package com.droidplate.recipeapp.model;

import com.google.gson.annotations.SerializedName;

public class RecipeModel {
    @SerializedName("calories")
    private String calories;

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

    @SerializedName("favorites")
    private String favorites;

    @SerializedName("fats")
    private String fats;

    @SerializedName("carbos")
    private String carbos;

    public RecipeModel(String calories, String description, String image,
                       String name, String favorites, String fats, String carbos) {
        this.calories = calories;
        this.description = description;
        this.image = image;
        this.name = name;
        this.favorites = favorites;
        this.fats = fats;
        this.carbos = carbos;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getCarbos() {
        return carbos;
    }

    public void setCarbos(String carbos) {
        this.carbos = carbos;
    }

    public void recipies(){

    }
}

