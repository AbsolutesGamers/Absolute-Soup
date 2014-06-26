package com.absolutesgamers.soup.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import com.absolutesgamers.soup.managers.FilesManager;

public class CocoaBeansSoup {
	
	private FilesManager files = FilesManager.load();
	
	private static CocoaBeansSoup load = new CocoaBeansSoup();
	
	public static CocoaBeansSoup load() {
		return load;
	}
	
	@SuppressWarnings("deprecation")
	public void cocoaBeansSoup() {
		if(files.getConfiguration().getBoolean("soups.cocoaBeans.usage") == true) {
			Integer count = files.getConfiguration().getInt("soups.cocoaBeans.count");
			ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
			ShapelessRecipe recipe = new ShapelessRecipe(soup);
			recipe.addIngredient(1, Material.BOWL);
			recipe.addIngredient(count, Material.INK_SACK, 3);
			Bukkit.getServer().addRecipe(recipe);
		}
	}
}
