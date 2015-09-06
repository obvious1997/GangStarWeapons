package com.obvious.Gangstar.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.obvious.Gangstar.Weapons;
import com.obvious.Gangstar.Utils.EnumWeapons;
import com.obvious.Gangstar.Utils.GangStarUtil;
import com.obvious.Gangstar.Utils.GlowEnchantment;

public class OnPlayerUseWeapons implements Listener

	{
		Plugin pl = Weapons.getPlugin();
		
		private EnumWeapons weapon;

		@SuppressWarnings("deprecation")
		@EventHandler
		public void onPlayerUseGun(PlayerInteractEvent e)
		
		{
			
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){

			if(e.getItem() == null) return;

			if(!GangStarUtil.isGun(e.getItem().getItemMeta())) return;
			weapon = GangStarUtil.getWeapon(e.getItem().getTypeId());
			
			if(weapon == null) return;
			
			if(!GangStarUtil.canShoot(e.getPlayer().getName(), e.getItem())) return;
			
			if(!GangStarUtil.hasMunition(e.getPlayer().getInventory(),  Material.getMaterial(weapon.getMunition()))) return;
			
			GangStarUtil.launchProjectile(e.getPlayer(), weapon.getVelocity());
			
			GangStarUtil.cooldownShoot(e.getPlayer().getName(), e.getItem().getTypeId());
			
			GangStarUtil.updateWeaponName(e.getPlayer(), e.getItem(), weapon.getMunition());
			
			/*
			 * ENLEVER UNE MUNITION
			 * +
			 * FAIRE CHARGEUR
			 */
			
			
			
			
			
		}
			
		
			
		}
		
		@SuppressWarnings("deprecation")
		@EventHandler
		public void onPlayerDamage(EntityDamageByEntityEvent e)
		
		{
			
			if(!(e.getDamager() instanceof Snowball)) return;
			
			Snowball projectil = (Snowball)e.getDamager();
			
			if(!(projectil.getShooter() instanceof Player)) return;
			Player attaquant = (Player) projectil.getShooter();
			ItemStack arme = attaquant.getItemInHand();
			weapon = GangStarUtil.getWeapon(arme.getTypeId());
			e.setDamage(weapon.getDamage());
			
		}
		
		@EventHandler
		public void onPlayerJoin(PlayerJoinEvent e)
		{
			ItemStack item = new ItemStack(Material.WOOD_AXE);
			ItemMeta itemMeta = item.getItemMeta();
			GlowEnchantment glow = new GlowEnchantment(70);
			itemMeta.setDisplayName(ChatColor.BLUE + "Sniper");
			itemMeta.addEnchant(glow, 1, true);
			item.setItemMeta(itemMeta);
			e.getPlayer().getInventory().addItem(item);
			e.getPlayer().updateInventory();
		}
	
	

	}
