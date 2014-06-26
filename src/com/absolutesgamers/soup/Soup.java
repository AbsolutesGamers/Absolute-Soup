package com.absolutesgamers.soup;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import com.absolutesgamers.soup.events.OnPlayerInteract;
import com.absolutesgamers.soup.items.CactusSoup;
import com.absolutesgamers.soup.items.CocoaBeansSoup;
import com.absolutesgamers.soup.managers.FilesManager;

public class Soup extends JavaPlugin {
	
	public void onEnable() {
		FilesManager.load().setup(this);
		CactusSoup.load().cactusSoup();
		CocoaBeansSoup.load().cocoaBeansSoup();
		getServer().getPluginManager().registerEvents(new OnPlayerInteract(), this);
		getLogger().info("Plugin Ativado!");
	}
	
	public void onDisable() {
		HandlerList.unregisterAll(this);
		getLogger().info("Plugin Desativado!");
	}
}
