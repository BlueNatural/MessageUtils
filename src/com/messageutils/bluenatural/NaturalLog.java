package com.messageutils.bluenatural;



import net.md_5.bungee.api.ChatColor;

public class NaturalLog  {
   private static String prefix = "[MessageUtils]";
	public enum PluginStatus{
		INFO,WARNING,CAUTION;
	}
	
	
	public static void sendStatusMessage(PluginStatus status,String message) {
		if(status.equals(PluginStatus.INFO)) {
		System.out.println(info() + message);
		}else if(status.equals(PluginStatus.CAUTION)) {
			System.out.println(caution() + message);
		}else if(status.equals(PluginStatus.WARNING)) {
			System.out.println(warning() + message);
		}
	}
	public static void info(String message) {
		System.out.println(info() + message);
	}
	public static void warn(String message) {
		System.out.println(warning() + message);
	}
    public static void caution(String message) {
    	System.out.println(caution() + message);
    }
    public static void sendPrefixMessage(String message) {
    	System.out.println(prefix + message);
    }
   
	public static String info() {
		// TODO Auto-generated method stub
		return ChatColor.WHITE + "[INFO]";
	}


	public static String caution() {
		// TODO Auto-generated method stub
		return ChatColor.YELLOW + "[CAUTION]";
	}


	public static String warning() {
		// TODO Auto-generated method stub
		return ChatColor.DARK_RED + "[WARNING]";
	}

}
