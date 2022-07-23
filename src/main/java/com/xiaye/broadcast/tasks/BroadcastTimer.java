package com.xiaye.broadcast.tasks;
import org.bukkit.scheduler.BukkitRunnable;

public class BroadcastTimer extends BukkitRunnable {
    @Override
    public void run() {
        com.xiaye.broadcast.commands.randomBroadcast.rbc();
    }
}
