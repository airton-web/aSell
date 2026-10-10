package io.github.airtonweb.asell;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class Prices {
    // Tabela: tipo do material - preço por 1und
    private final Map<Material, Double> prices = new HashMap<>();

    public Prices() {
        prices.put(Material.COAL, 2.0);
        prices.put(Material.IRON_INGOT, 5.0);
        prices.put(Material.GOLD_INGOT, 10.0);
        prices.put(Material.DIAMOND, 25.0);
    }

    public double getPrice(Material material1) {
        return prices.getOrDefault(material1, 0.0);

    }
}


