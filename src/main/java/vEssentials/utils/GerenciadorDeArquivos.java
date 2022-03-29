package vEssentials.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import vEssentials.vEssentials;

public class GerenciadorDeArquivos {

    public static File arquivoConfig;
    public static FileConfiguration config;
    public static File arquivoDB;
    public static FileConfiguration DB;

    private static GerenciadorDeArquivos carregar = new GerenciadorDeArquivos();

    public static GerenciadorDeArquivos carregarArquivos() {
        return carregar;
    }

    public void criarArquivos(Plugin plugin) {
        arquivoConfig = new File(plugin.getDataFolder(), "config.yml");

        if (!arquivoConfig.exists()) {
            plugin.saveResource("config.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(arquivoConfig);

        arquivoDB = new File(plugin.getDataFolder(), "db.yml");

        if (!arquivoDB.exists()) {
            plugin.saveResource("db.yml", false);
        }

        DB = YamlConfiguration.loadConfiguration(arquivoDB);
    }

    public FileConfiguration receberConfig() {
        return config;
    }

    public void salvarConfig() {
        try {
            config.save(arquivoConfig);
        } catch (IOException e) {
            vEssentials.receberServidor().getLogger().severe("Nao foi possivel salvar o arquivo de config.");
        }
    }

    public void recarregarConfig() {
        config = YamlConfiguration.loadConfiguration(arquivoConfig);
    }

    public FileConfiguration receberDB() {
        return DB;
    }

    public void salvarDB() {
        try {
            DB.save(arquivoDB);
        } catch (IOException e) {
            vEssentials.receberServidor().getLogger().severe("Nao foi possivel salvar o arquivo de tutorial.");
        }
    }

    public void recarregarDB() {
        DB = YamlConfiguration.loadConfiguration(arquivoDB);
    }
}
