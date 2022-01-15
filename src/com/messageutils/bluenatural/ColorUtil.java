package com.messageutils.bluenatural;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;

import com.google.common.base.Preconditions;

import net.md_5.bungee.api.ChatColor;

public class ColorUtil {
	//Find hex number to set color the string
	public static final char COLOR_CHARACTER = '\u00A7';
	 private static final Map<String, ColorUtil> NAME = new HashMap<String, ColorUtil>();
	private static Pattern pattern = Pattern.compile("#[a-fA-f0-9]{6}");
	 private final Color color;
	 private final String toString;
	    
	    private final String name;
	    private final int ordinal;
	    public ColorUtil(String name, String toString, int rgb)
	    {
	    	this.name = name;
	    	this.ordinal = -1;
	    	this.color = new Color(rgb);
	        this.toString = toString;
	    }

	public static String setHex(String message) {
		Matcher match = pattern.matcher(message);
		while(match.find()) {
			String color = message.substring(match.start(),match.end());
			message = message.replace(color, ColorUtil.of(color) + "");
			match = pattern.matcher(message);
			
		}
		return ChatColor.translateAlternateColorCodes('&', message);
	}
    public static String customColor(ColorBTypes type,String message) {
    	if(type.equals(ColorBTypes.RANDOM)) {
    		Random r = new Random();
    		int number = r.nextInt();
    		if(number == 0) {
    			return ChatColor.BLUE + message;
    		}else if(number == 1) {
    			return ChatColor.YELLOW + message;
    		}else if(number == 2) {
    			return ChatColor.DARK_GREEN + message;
    		}else if(number == 3) {
    			return ChatColor.RED + message;
    		}else if(number == 4) {
    			return ChatColor.LIGHT_PURPLE + message;
    		}else if(number == 5) {
    			return ChatColor.WHITE + message;
    		}else if(number == 6) {
    			return ChatColor.DARK_GRAY + message;
    		}
    	}else if(type.equals(ColorBTypes.NORMAL)) {
    		return ChatColor.translateAlternateColorCodes('&', message);
    	}else if(type.equals(ColorBTypes.HEX)) {
    		return setHex(message);
    	}
		return null;
    	}
    public static ColorUtil of(Color color)
    {
        return of( "#" + String.format( "%08x", color.getRGB() ).substring( 2 ) );
    }

    public static ColorUtil of(String string)
    {
        Preconditions.checkArgument( string != null, "string cannot be null" );
        if ( string.startsWith( "#" ) && string.length() == 7 )
        {
            int rgb;
            try
            {
                rgb = Integer.parseInt( string.substring( 1 ), 16 );
            } catch ( NumberFormatException ex )
            {
                throw new IllegalArgumentException( "Illegal hex string " + string );
            }

            StringBuilder magic = new StringBuilder( COLOR_CHARACTER + "x" );
            for ( char c : string.substring( 1 ).toCharArray() )
            {
                magic.append( COLOR_CHARACTER ).append( c );
            }

            return new ColorUtil(string,magic.toString(),rgb);
        }

        ColorUtil defined = NAME.get( string.toUpperCase( Locale.ROOT ) );
        if ( defined != null )
        {
            return defined;
        }

        throw new IllegalArgumentException( "Could not parse ChatColor " + string );
    }
	
}
	
    

