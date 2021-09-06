package com.techpathy.JunkFoodDumperservice.service;


import org.json.JSONObject;

import java.util.Map;


public interface RecipesService {

    public Map searchRecipes(String query, Integer pageNumber);

    public Map searchRecipes(String query);

    public JSONObject getRecipe(Long id);

}

