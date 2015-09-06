package com.obvious.Gangstar.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import com.obvious.Gangstar.Weapons;

public class GangStarUtil {
	private static final List<String> ak47cooldown = new ArrayList<String>();
	private static final List<String> m4cooldown = new ArrayList<String>();
	private static final List<String> deaglecooldown = new ArrayList<String>();
	private static final List<String> snipercooldown = new ArrayList<String>();
	private static int amount;
	public static boolean isGun(ItemMeta item){
		
		GlowEnchantment glow = new GlowEnchantment(70);
		if(!item.hasEnchant(glow))
			return false;
		else		
			return true;			
	}
	
	public static EnumWeapons getWeapon(int i)
	
	{
		switch(i)
		
		{
			case 268:
				return EnumWeapons.AK47;
			case 269:
				return EnumWeapons.M4;
			case 270:
				return EnumWeapons.DEAGLE;
			case 271:
				return EnumWeapons.SNIPER;
			default:
				return null;
				
		}
			
		
		
		
	}

	@SuppressWarnings("deprecation")
	public static boolean canShoot(String player, ItemStack itemStack) {
		
		switch(itemStack.getTypeId())
		
		{
		
			case 268:
				if(ak47cooldown.contains(player)) return false;
				else
					return true;
			case 269:
				if(m4cooldown.contains(player)) return false;
				else
					return true;
			case 270:
				if(deaglecooldown.contains(player)) return false;
				else
					return true;
			case 271:
				if(snipercooldown.contains(player)) return false;
				else
					return true;
			default:
				return false;
		
		}
		
	}

	public static boolean hasMunition(PlayerInventory inventory, Material material) {
		if(!inventory.contains(material)) return false;
		else
			return true;
	}

	public static void cooldownShoot(final String name, int	item) {
		Plugin pl = Weapons.getPlugin();
		switch(item)
		
		{
		
			case 268:
				ak47cooldown.add(name);
				
				pl.getServer().getScheduler().runTaskLaterAsynchronously(pl, new Runnable(){
					
					@Override
					public void run()
					
					{
						
						ak47cooldown.remove(name);
					}
					
				}, (getWeapon(268).getCooldowntir() * 20L));
				
			case 269:
				m4cooldown.add(name);
				
				pl.getServer().getScheduler().runTaskLaterAsynchronously(pl, new Runnable(){
					
					@Override
					public void run()
					
					{
						
						m4cooldown.remove(name);

					}
					
				}, (getWeapon(269).getCooldowntir() * 20L));
				

			case 270:
				deaglecooldown.add(name);
				
				pl.getServer().getScheduler().runTaskLaterAsynchronously(pl, new Runnable(){
					
					@Override
					public void run()
					
					{
						
						deaglecooldown.remove(name);

					}
					
				}, (getWeapon(270).getCooldowntir() * 20L));

			case 271:
				snipercooldown.add(name);
				pl.getServer().getScheduler().runTaskLaterAsynchronously(pl, new Runnable(){
					
					@Override
					public void run()
					
					{
						
						snipercooldown.remove(name);

					}
					
				}, (getWeapon(271).getCooldowntir() * 20L));
			
		}
		
	}

	@SuppressWarnings("deprecation")
	public static void updateWeaponName(Player p, ItemStack item, int munition) {
		ArrayList<String> lores = new ArrayList<String>();

		ItemStack[] items = p.getInventory().getContents();
		for(ItemStack i : items)
		{
			if(i.getTypeId() == munition){
				if(i.getAmount() == 1){
					amount = 0;
					p.getInventory().remove(i);
				}else{
				    amount = i.getAmount()-1;
					i.setAmount(amount);

				}
				
				
				lores.add(ChatColor.YELLOW + "Munitions: " + ChatColor.BLUE + amount);
				ItemMeta itemmeta = item.getItemMeta();
				itemmeta.setLore(lores);
				item.setItemMeta(itemmeta);

				p.updateInventory();
				break;
			}
		}
	
		
	}

	public static void launchProjectile(Player player, double velocity) {
		Projectile pr = player.launchProjectile(Snowball.class);
		pr.setVelocity(pr.getVelocity().multiply(velocity));
		
	}





}
