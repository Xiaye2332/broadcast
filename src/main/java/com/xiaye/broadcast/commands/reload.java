package com.xiaye.broadcast.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0){
            sender.sendMessage("指令格式不正确,使用方法/bcreload");
            return false;
        }else
        {
            Plugin config = com.xiaye.broadcast.Broadcast.getPlugin(com.xiaye.broadcast.Broadcast.class);
            config.reloadConfig();
            config.saveConfig();
            com.xiaye.broadcast.Broadcast.getPlugin(com.xiaye.broadcast.Broadcast.class).getServer().getPluginManager().disablePlugin(config);
            com.xiaye.broadcast.Broadcast.getPlugin(com.xiaye.broadcast.Broadcast.class).getServer().getPluginManager().enablePlugin(config);
            sender.sendMessage(ChatColor.GREEN+"[Broadcast] 配置文件已重载");
            int len = config.getConfig().getStringList("BroadcastContent").size();
            sender.sendMessage(ChatColor.GREEN+"[Broadcast] 已加载"+len+"条公告");
        }
        return false;
    }
}
