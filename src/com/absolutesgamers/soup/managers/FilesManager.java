package com.absolutesgamers.soup.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class FilesManager {
	
	private File fileConfiguration;
	private FileConfiguration configuration;
	
	private static FilesManager load = new FilesManager();
	
	public static FilesManager load() {
		return load;
	}
	
	public void setup(Plugin plugin) {
		fileConfiguration = new File(plugin.getDataFolder(), "configuration.yml");
		
		if(!fileConfiguration.exists()) {
			plugin.saveResource("configuration.yml", false);
		}
		
		configuration = YamlConfiguration.loadConfiguration(fileConfiguration); 
	}
	
	public FileConfiguration getConfiguration() {
		return configuration;
	}
	
	public void saveConfiguration() {
		try{
			configuration.save(fileConfiguration);
		}catch(IOException e) {
			Bukkit.getServer().getLogger().severe("Could not save the file configuration.yml!");
		}
	}
}
