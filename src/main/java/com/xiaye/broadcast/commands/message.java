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
        if (args.length ==0){
            sender.sendMessage(ChatColor.RED + "不能发送空消息!");
            return false;
        }
        Plugin config = com.xiaye.broadcast.Broadcast.getPlugin(com.xiaye.broadcast.Broadcast.class);
        String prefix = config.getConfig().getString("Prefix");
        int i = args.length;
        String content = "";
        int k = 0;
        while (k < i) {
            String tmp = args[k];
            tmp += " ";
            content += tmp;
            k++;
        }
        String coloredContent = ChatColor.translateAlternateColorCodes('&', content);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(prefix + ChatColor.WHITE + coloredContent);
        }
        Bukkit.getLogger().info("[公告]"+content);
        return false;
    }
}
