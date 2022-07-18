package com.xiaye.broadcast.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class message implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin config = com.xiaye.broadcast.Broadcast.getPlugin(com.xiaye.broadcast.Broadcast.class);
        String prefix = config.getConfig().getString("Prefix");
        if (args.length != 1)
        {   sender.sendMessage("指令格式不正确,使用方法/xbc [内容]");
            return false;
        }else {
            String content = args[0];
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(prefix + ChatColor.WHITE + content);
            }
        }
        return false;
    }
}
