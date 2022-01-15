package com.messageutils.bluenatural;

import org.bukkit.Bukkit;

public class ServerVersion {

	public static boolean is112() {
		// TODO Auto-generated method stub
		return Bukkit.getBukkitVersion().contains("1.12");
	}

	public static boolean is114() {
		// TODO Auto-generated method stub
		return Bukkit.getBukkitVersion().contains("1.14");
	}

}
