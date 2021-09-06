package com.techpathy.JunkFoodDumperservice.controller;


import com.techpathy.JunkFoodDumperservice.service.RecipesService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/recipes")
public class RecipesController {

    @Autowired
    private RecipesService recipesService;


    @GetMapping("/search")
    public Map<String, Object> searchRecipes(
            @RequestParam(name = "query")String query,
            @RequestParam(name = "pageNumber",defaultValue = "0") Integer pageNumber){
        Map recipes = recipesService.searchRecipes(query,pageNumber);
        return recipes;
    }

    @GetMapping("/get")
    public Map<String, Object> getRecipe(@RequestParam(name = "id")int id){
        JSONObject recipe = recipesService.getRecipe((long) id);
        return recipe.toMap();
    }
}
