package com.messageutils.bluenatural;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class Bossbar {
	
	public static void sendBossbar(Player p,BarColor barcolor,BarStyle barstyle,String title,double barprogress){
		BossBar bb = Bukkit.createBossBar(title, barcolor, barstyle);
		MessageUtils.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(MessageUtils.getPlugin(), new Runnable(){
			public void run(){
				bb.addPlayer(p);
				bb.show();
				bb.setProgress(barprogress);
			}
		},0,10);
		MessageUtils.getPlugin().getServer().getPluginManager().callEvent(new BarReceiverEvent(p, bb));
	}
	public static void sendBossbar(Player p,BarColor barcolor,String title,double barprogress){
		BossBar bb = Bukkit.createBossBar(title, barcolor, BarStyle.SOLID);
		MessageUtils.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(MessageUtils.getPlugin(), new Runnable(){
			public void run(){
				bb.addPlayer(p);
				bb.show();
				bb.setProgress(barprogress);
				
			}
		},0,10);
		MessageUtils.getPlugin().getServer().getPluginManager().callEvent(new BarReceiverEvent(p, bb));
	}
	public static void sendBossbar(Player p,BarStyle barstyle,String title,double barprogress){
		BossBar bb = Bukkit.createBossBar(title, BarColor.PURPLE, barstyle);
		MessageUtils.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(MessageUtils.getPlugin(), new Runnable(){
			public void run(){
				bb.addPlayer(p);
				bb.show();
				bb.setProgress(barprogress);
				
			}
		},0,10);
		MessageUtils.getPlugin().getServer().getPluginManager().callEvent(new BarReceiverEvent(p, bb));
	}
	public static void sendBossbar(Player p,String title,double barprogress){
		BossBar bb = Bukkit.createBossBar(title, BarColor.PURPLE, BarStyle.SOLID);
		MessageUtils.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(MessageUtils.getPlugin(), new Runnable(){
			public void run(){
				bb.addPlayer(p);
				bb.show();
				bb.setProgress(barprogress);
			}
		},0,10);
		MessageUtils.getPlugin().getServer().getPluginManager().callEvent(new BarReceiverEvent(p, bb));
	}
	public static void sendBossbarTime(Player p,String title,BarColor barcolor,BarStyle barstyle,int time,double barprogress){
		BossBar bb = Bukkit.createBossBar(title, barcolor, barstyle);
		MessageUtils.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(MessageUtils.getPlugin(), new Runnable(){
			public void run(){
				bb.addPlayer(p);
				bb.show();
				bb.setProgress(barprogress);
			}
		},0,10);
		MessageUtils.getPlugin().getServer().getScheduler().runTaskLater(MessageUtils.getPlugin(), new Runnable(){
			public void run(){
				bb.removePlayer(p);
				bb.hide();
				MessageUtils.getPlugin().getServer().getScheduler().cancelTasks(MessageUtils.getPlugin());
			}
		},20 * time);
	}
	

}
