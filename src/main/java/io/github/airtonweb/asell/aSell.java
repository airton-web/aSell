package io.github.airtonweb.asell;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Classe principal do plugin.
 *
 * - "package" precisa bater com as pastas onde o arquivo está:
 *   src/main/java/io/github/airtonweb/asell/
 * - "extends JavaPlugin" faz a classe herdar tudo que um plugin precisa.
 * - O nome desta classe (aSell) precisa ser IGUAL, letra por letra,
 *   ao final do campo "main" do plugin.yml.
 */
public final class aSell extends JavaPlugin {

    // Chamado quando o servidor liga o plugin
    @Override
    public void onEnable() {
        getLogger().info("aSell Ativado!");
    }

    // Chamado quando o servidor desliga o plugin
    @Override
    public void onDisable() {
        getLogger().info("aSell Desligado!");
    }
}
