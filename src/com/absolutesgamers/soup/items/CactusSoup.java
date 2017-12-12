package com.absolutesgamers.soup.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import com.absolutesgamers.soup.managers.FilesManager;

public class CactusSoup {
	
	private FilesManager files = FilesManager.load();
	
	private static CactusSoup load = new CactusSoup();
	
	public static CactusSoup load() {
		return load;
	}
	
	public void cactusSoup() {
		if(files.getConfiguration().getBoolean("soups.cactus.usage") == true) {
			Integer count = files.getConfiguration().getInt("soups.cactus.count");
			ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
			ShapelessRecipe recipe = new ShapelessRecipe(soup);
			recipe.addIngredient(1, Material.BOWL);
			recipe.addIngredient(count, Material.CACTUS);
		}
	}
}
