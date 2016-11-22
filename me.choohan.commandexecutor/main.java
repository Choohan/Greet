package me.choohan.commandexecutor;

import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getLogger().info("Greet by Choohan Had Been Enabled");
		getCommand("greet").setExecutor(new command());
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Greet by Choohan Had Been Disabled");
		
	}
	
	

}
