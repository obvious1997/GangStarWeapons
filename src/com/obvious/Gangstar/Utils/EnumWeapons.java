package com.obvious.Gangstar.Utils;

import com.obvious.Gangstar.Weapons;

public enum EnumWeapons {
	
	
	AK47((Weapons.getPlugin().getConfig().getLong("weapons.ak47.cooldowntir")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.ak47.cooldownreload")),
			(Weapons.getPlugin().getConfig().getInt("weapons.ak47.chargeur")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.ak47.damage")),
			(Weapons.getPlugin().getConfig().getInt("weapons.ak47.munition")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.ak47.velocity"))),
	M4((Weapons.getPlugin().getConfig().getLong("weapons.m4.cooldowntir")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.m4.cooldownreload")),
			(Weapons.getPlugin().getConfig().getInt("weapons.m4.chargeur")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.m4.damage")),
			(Weapons.getPlugin().getConfig().getInt("weapons.m4.munition")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.m4.velocity"))),
	DEAGLE((Weapons.getPlugin().getConfig().getLong("weapons.deagle.cooldowntir")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.deagle.cooldownreload")),
			(Weapons.getPlugin().getConfig().getInt("weapons.deagle.chargeur")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.deagle.damage")),
			(Weapons.getPlugin().getConfig().getInt("weapons.deagle.munition")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.deagle.velocity"))),
	SNIPER((Weapons.getPlugin().getConfig().getLong("weapons.sniper.cooldowntir")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.sniper.cooldownreload")),
			(Weapons.getPlugin().getConfig().getInt("weapons.sniper.chargeur")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.sniper.damage")),
			(Weapons.getPlugin().getConfig().getInt("weapons.sniper.munition")),
			(Weapons.getPlugin().getConfig().getDouble("weapons.sniper.velocity")));
	
	private final long cooldowntir;
	private final double cooldown;
	private final int chargeur;
	private final double damage;
	private final int munition;
	private final double velocity;

	EnumWeapons(long cooldowntir,double cooldown, int chargeur, double damage, int munition, double velocity)
	
	{
		this.cooldowntir = cooldowntir;
		this.cooldown = cooldown;
		this.chargeur = chargeur;
		this.damage = damage;
		this.munition = munition;
		this.velocity = velocity;
		
	}
	
	public long getCooldowntir()
	
	{
		
		return cooldowntir;
		
	}
	
	public double getCooldown()
	
	{
		
		return cooldown;
		
	}
	
	
	public int getChargeur()
	
	{
		
		return chargeur;
		
	}
	
	public double getDamage()
	
	{
		
		return damage;
		
	}

	
	public int getMunition()
	
	{
		
		return munition;
		
	}
	
	public double getVelocity()
	{
		
		return velocity;
		
	}
}
