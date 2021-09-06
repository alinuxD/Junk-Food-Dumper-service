package com.techpathy.JunkFoodDumperservice.service.impl;


import com.fatsecret.platform.services.Request;
import com.techpathy.JunkFoodDumperservice.service.RecipesService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipesServiceImpl implements RecipesService {

    private Request request;

    public RecipesServiceImpl(@Value("${fatsecret.api.key}") String key,
                              @Value("${fatsecret.api.secret}") String secret){
        request = new Request(key,secret);
    }

    @Override
    public Map searchRecipes(String query){
        return searchRecipes(query,  0);
    }

    @Override
    public Map searchRecipes(String query, Integer pageNumber) {
        JSONObject json = request.searchRecipes(query, pageNumber);

        Map recipes = (Map) json.toMap().get("recipes");

        ArrayList<Map> recipe = (ArrayList)recipes.get("recipe");

        ArrayList filtered_recipe = new ArrayList();
        for (Map element: recipe){
            Map recipe_nutrition = (Map) element.get("recipe_nutrition");
            Float calories = Float.parseFloat((String) recipe_nutrition.get("calories"));
            Float fat = Float.parseFloat((String) recipe_nutrition.get("fat"));

            // filter out recipes
            if (calories<400 && fat<8){
                filtered_recipe.add(element);
            }

        }
        int recipe_num = filtered_recipe.size();
        recipes.put("recipe",filtered_recipe);
        recipes.put("max_results",recipe_num);

        HashMap<String,Map> return_map = new HashMap<String,Map>();
        return_map.put("recipes",recipes);
        return return_map;
    }

    @Override
    public JSONObject getRecipe(Long id){
        JSONObject json = request.getRecipe(id);
        return json;
    }

}
