package com.messageutils.bluenatural;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import com.messageutils.bluenatural.NaturalLog.PluginStatus;

import net.md_5.bungee.api.ChatColor;

public class MessageUtils {
	public static Plugin plugin;
	public static Titles title;
	public static Bossbar bossbar;
	public static ColorBTypes ColorBTypes;
	public static ColorUtil cu;
	
	public static Plugin getPlugin() {
		
		return plugin;
	}
	public static Titles getTitle() {
		return title;
	}
	public static Bossbar getBossbar() {
		return bossbar;
	}
	public static ColorBTypes getColorBTypes() {
		return ColorBTypes;
	}
	public static ColorUtil getColorUtil() {
		
		return cu;
	}
	PluginDescriptionFile pdf = getPlugin().getDescription();
    public void onEnable() {
    	if(ServerVersion.is112() || ServerVersion.is114()) {
    		NaturalLog.sendPrefixMessage(ChatColor.YELLOW + "-------------------------------------");
    		NaturalLog.sendStatusMessage(PluginStatus.INFO, ChatColor.GREEN + "Name: " + pdf.getName());
    		NaturalLog.sendStatusMessage(PluginStatus.INFO, ChatColor.GREEN + "Version: " + pdf.getVersion());
    		NaturalLog.sendStatusMessage(PluginStatus.INFO, ChatColor.GREEN + "Author: BlueNatural");
    		NaturalLog.sendStatusMessage(PluginStatus.INFO, ChatColor.GREEN + "Supporter: " + pdf.getWebsite());
    		NaturalLog.sendStatusMessage(PluginStatus.CAUTION, ChatColor.GOLD + "If this plugin has error,you can contact by link in Supporter");
    		NaturalLog.sendPrefixMessage(ChatColor.YELLOW + "-------------------------------------");

    		
    	}else {
    		try {
    		NaturalLog.sendPrefixMessage(ChatColor.RED + "-------------[WARNING]-------------");
    		NaturalLog.sendStatusMessage(PluginStatus.WARNING, ChatColor.YELLOW + "Your server version is not suitable for this plugin !");
    		NaturalLog.sendStatusMessage(PluginStatus.WARNING, ChatColor.YELLOW + "Please choose suitable version to it works,The plugin will be disabled in a few seconds");
    		NaturalLog.sendPrefixMessage(ChatColor.RED + "-------------[WARNING]-------------");
				Thread.sleep(System.currentTimeMillis());
				plugin.getServer().getPluginManager().disablePlugin(getPlugin());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    public void onDisable() {
    	
    }
}
