package com.messageutils.bluenatural;

import org.bukkit.entity.Player;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SendingTitleEvent extends Event {
	Player p;
	String title;
	String subtitle;
   
	
	public SendingTitleEvent(Player player,String string,String string2) {
		this.p = player;
		this.title = string;
		this.subtitle = string2;
	}
    public String getTitle() {
    	return title;
    }
    public String getSubtitle() {
    	return subtitle;
    }
    public Player getPlayer() {
    	return p;
    }
    private static final HandlerList handlers = new HandlerList();
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}
	public static HandlerList getHandlerList(){
		return handlers;
	}
	
		
	}


