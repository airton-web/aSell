package io.github.airtonweb.asell;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class aSell extends JavaPlugin {


    @Override
    public void onEnable() { // Aqui quando o Plugin Liga
        Bukkit.getConsoleSender().sendMessage("§2[aSell] §aPlugin ativado com sucesso!");
        Bukkit.getConsoleSender().sendMessage("§2[aSell] §aVersão do Plugin: " +  getPluginMeta().getVersion());
        getCommand("vender").setExecutor(new VenderCommand());
    }
    @Override
    public void onDisable() { // Aqui quando o Plugin Desliga //
        Bukkit.getConsoleSender().sendMessage("§4[aSell] §cPlugin desligado!");
    }
}

