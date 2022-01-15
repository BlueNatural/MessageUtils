package com.messageutils.bluenatural;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BarReceiverEvent extends Event {
	Player p;
	BossBar bb;
	
	public BarReceiverEvent(Player p,BossBar bb){
		this.p = p;
		this.bb = bb;
		
	}
	public Player getPlayer(){
		return p;
	}
	public BossBar getBar(){
		return bb;
	}
	private static final HandlerList handlers = new HandlerList();
	
	public HandlerList getHandlers(){
		return handlers;
	}
	public static HandlerList getHandlerList(){
		return handlers;
	}

}
