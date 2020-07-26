package com.gmail.picono435.picojobs.hooks;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.gmail.picono435.picojobs.PicoJobsPlugin;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.permission.Permission;

public class VaultHook {
	
	private static Permission perm;
	private static boolean isEnabled = false;
	
	public static void setupVault() {
		if(Bukkit.getPluginManager().getPlugin("Vault") == null) {
			PicoJobsPlugin.sendConsoleMessage(ChatColor.YELLOW + "[PicoJobs] The optional dependency Vault was not found. Some features may not work well!");
			return;
		}
		isEnabled = true;
		PicoJobsPlugin.sendConsoleMessage(ChatColor.GREEN + "[PicoJobs] Vault was found! We are configuring the connection between us and Vault.");
		setupPermission();
	}
	
	private static boolean setupPermission() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
        if (rsp == null) {
            return false;
        }
        perm = rsp.getProvider();
        return perm != null;
    }
	
	public static Permission getPermission() {
		return perm;
	}
	
	public static boolean isEnabled() {
		return isEnabled;
	}
}