package me.choohan.commandexecutor;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class command implements CommandExecutor{
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		int cooldownTime = 120; // Get number of seconds from wherever you want
        if(cooldowns.containsKey(sender.getName())) {
            long secondsLeft = ((cooldowns.get(sender.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
            if(secondsLeft>0) {
                // Still cooling down
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l[&a&lGreet&f&l] &bYou cant use that commands for another &e&l"+ secondsLeft +" &bseconds!"));
                return true;
            }
        }
        // No cooldown found or cooldown has expired, save new cooldown
        cooldowns.put(sender.getName(), System.currentTimeMillis());
        // Do Command Here

		if(sender instanceof Player){
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l[&a&lGreet&f&l] &fHi, I am " + "&a" + sender.getName() ));
		}else{
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l[&a&lGreet&f&l] &aConsole onlined!"));
		}
		return false;
	}

}
