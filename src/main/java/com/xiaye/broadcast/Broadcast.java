package com.xiaye.broadcast;

import com.xiaye.broadcast.commands.message;
import com.xiaye.broadcast.commands.randomBroadcast;
import com.xiaye.broadcast.commands.reload;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Broadcast extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("xbc").setExecutor(new message());
        getCommand("rbc").setExecutor(new randomBroadcast());
        getCommand("bcreload").setExecutor(new reload());
        Bukkit.getLogger().info("[BroadCast] 插件已加载");
        if (getConfig().getBoolean("enable_Timer") == true) {
            Bukkit.getLogger().info("[BroadCast] 自动发送已打开,将执行自动发送任务");
            int timer = getConfig().getInt("Timer");
            BukkitTask broadcast = new com.xiaye.broadcast.tasks.BroadcastTimer().runTaskTimer(this, 0, timer * 20);
        } else {
            Bukkit.getLogger().info("[BroadCast] 自动发送功能未打开,将不会自动发送");
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[BroadCast] 插件已卸载");
    }
}