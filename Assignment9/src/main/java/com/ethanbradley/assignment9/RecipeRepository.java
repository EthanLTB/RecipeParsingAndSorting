package com.ethanbradley.assignment9;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepository {

	private ArrayList<Recipe> allRecipes = new ArrayList<>();

	public ArrayList<Recipe> getAllRecipes() {
		return allRecipes;
	}

	public void setAllRecipes(ArrayList<Recipe> allRecipes) {
		this.allRecipes = allRecipes;
	}

}
