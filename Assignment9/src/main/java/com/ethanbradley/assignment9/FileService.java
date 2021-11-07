package com.ethanbradley.assignment9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	public ArrayList<Recipe> readFileIntoRecipeCollection() {
		
		 try {
			    Reader in = new FileReader("recipes.txt");
				Iterable<CSVRecord> records = CSVFormat.DEFAULT.withEscape('\\').withFirstRecordAsHeader().withSkipHeaderRecord()
						.withIgnoreSurroundingSpaces().parse(in);
			
				for(CSVRecord record : records) {
					System.out.println(record);
				
					 Integer cookingMinutes =Integer.parseInt(record.get(0));
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
					 recipeRepository.getAllRecipes().add(recipe);
					 
				}
			in.close();
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
		}
		
		
		return recipeRepository.getAllRecipes();
	}
	
	public ArrayList<Recipe> getRecipes (){
		if(recipeRepository.getAllRecipes().size() == 0) {
			return readFileIntoRecipeCollection();
		}
		return recipeRepository.getAllRecipes();
	}

	
}
