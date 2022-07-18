package com.xiaye.broadcast.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class BroadcastTimer extends BukkitRunnable {
    @Override
    public void run() {
        com.xiaye.broadcast.commands.randomBroadcast.rbc();
    }
}
