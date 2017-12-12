package com.absolutesgamers.soup.events;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.absolutesgamers.soup.managers.FilesManager;

public class OnPlayerInteract implements Listener {
	
	private FilesManager files = FilesManager.load();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Material itemUsage = Material.getMaterial(files.getConfiguration().getString("item.toUse"));
		if(player.getInventory().getItemInMainHand().getType() == itemUsage) {
			if((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				if(files.getConfiguration().getBoolean("regenerate.health") == true) {
					Double actualHealth = player.getHealth();
					Double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
					Double regenerate = files.getConfiguration().getDouble("regenerate.amount");
					Material itemAfterUsage = Material.getMaterial(files.getConfiguration().getString("item.afterUsage"));
					if(actualHealth <= (maxHealth - regenerate)) {
						player.setHealth(actualHealth + regenerate);
						player.getInventory().getItemInMainHand().setType(itemAfterUsage);
					}
					if(actualHealth > (maxHealth - regenerate)) {
						player.setHealth(maxHealth);
						player.getInventory().getItemInMainHand().setType(itemAfterUsage);
					}
				}
				if(files.getConfiguration().getBoolean("regenerate.food") == true) {
					Integer actualFood = player.getFoodLevel();
					Integer maxFood = 20;
					Double regenerate = files.getConfiguration().getDouble("regenerate.amount");
					Material itemAfterUsage = Material.getMaterial(files.getConfiguration().getString("item.afterUsage"));
					if(actualFood <= (maxFood - regenerate)) {
						player.setFoodLevel((int) (actualFood + regenerate));
						player.getInventory().getItemInMainHand().setType(itemAfterUsage);
					}
					if(actualFood > (maxFood - regenerate)) {
						player.setFoodLevel(maxFood);
						player.getInventory().getItemInMainHand().setType(itemAfterUsage);
					}
				}
			}
		}
	}
}
