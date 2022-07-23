package com.xiaye.broadcast.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class randomBroadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0){
            sender.sendMessage("指令格式不正确,使用方法/rbc");
            return false;
        }else{
            rbc();
        }
        return false;
    }
    public static void rbc(){
        Plugin config = com.xiaye.broadcast.Broadcast.getPlugin(com.xiaye.broadcast.Broadcast.class);
        int len = config.getConfig().getStringList("BroadcastContent").size();
        String prefix = config.getConfig().getString("Prefix");
        Random random = new Random();
        int bcrandom = random.nextInt(len);
        String content = config.getConfig().getStringList("BroadcastContent").get(bcrandom);
        String coloredContent = ChatColor.translateAlternateColorCodes('&',content);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(prefix+ ChatColor.WHITE + coloredContent);
        }
        Bukkit.getLogger().info("[公告]"+content);
    }
}