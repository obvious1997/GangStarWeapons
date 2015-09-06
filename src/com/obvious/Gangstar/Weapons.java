package com.obvious.Gangstar;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.obvious.Gangstar.Events.OnPlayerUseWeapons;
import com.obvious.Gangstar.Utils.GlowEnchantment;


public class Weapons extends JavaPlugin

	{
	
	private static Plugin plugin;

		@Override
		public void onEnable()
		
		{
			
			plugin = this;
			saveDefaultConfig();
	        registerEvents(this, new OnPlayerUseWeapons());
	        registerGlow();

		}



		public void onDisable()
		
		{
			
			plugin = null;
			
		}
		
		
		public static Plugin getPlugin()
		
		{
			
			return plugin;
			
		}
		
		public static void registerEvents(Plugin plugin, Listener... listeners) {
	        for (Listener listener : listeners) {
	            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	        }
	    }
		
		public void registerGlow() {
	        try {
	            Field f = Enchantment.class.getDeclaredField("acceptingNew");
	            f.setAccessible(true);
	            f.set(null, true);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        try {
	            GlowEnchantment glow = new GlowEnchantment(70);
	            Enchantment.registerEnchantment(glow);
	        }
	        catch (IllegalArgumentException e){
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	

	}	
