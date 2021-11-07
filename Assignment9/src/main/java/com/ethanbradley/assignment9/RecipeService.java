package com.ethanbradley.assignment9;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

	public Recipe createRecipeFromCSVRecord(CSVRecord record) {
		Integer cookingMinutes = Integer.parseInt(record.get(0));
		Boolean dairyFree = Boolean.parseBoolean(record.get(1));
		Boolean glutenFree = Boolean.parseBoolean(record.get(2));
		String instructions = record.get(3);
		Double preparationMinutes = Double.parseDouble(record.get(4));
		Double pricePerServing = Double.parseDouble(record.get(5));
		Integer readyInMinutes = Integer.parseInt(record.get(6));
		Integer servings = Integer.parseInt(record.get(7));
		Double spoonacularScore = Double.parseDouble(record.get(8));
		String title = record.get(9);
		Boolean vegan = Boolean.parseBoolean(record.get(10));
		Boolean vegetarian = Boolean.parseBoolean(record.get(11));
		Recipe recipe = new Recipe();

		recipe.setCookingMinutes(cookingMinutes);
		recipe.setDairyFree(dairyFree);
		recipe.setGlutenFree(glutenFree);
		recipe.setInstructions(instructions);
		recipe.setPreparationMinutes(preparationMinutes);
		recipe.setPricePerServing(pricePerServing);
		recipe.setReadyInMinutes(readyInMinutes);
		recipe.setServings(servings);
		recipe.setSpoonacularScore(spoonacularScore);
		recipe.setTitle(title);
		recipe.setVegan(vegan);
		recipe.setVegetarian(vegetarian);
		return recipe;
	}
}
