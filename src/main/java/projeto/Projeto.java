package projeto;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import projeto.comandos.*;
import projeto.eventos.InventoryClick;
import projeto.eventos.PlayerEvents;
import projeto.eventos.ServerEvents;

public class Projeto extends JavaPlugin  {

    private static Projeto instance;

    @Override
    public void onEnable() {
        carregarConfig();
        registrarEventos();
        registrarComandos();
        //startScheduler();
    }

    private void registrarEventos(){
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new ServerEvents(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
    }

    private void registrarComandos(){
        getCommand("ajuda").setExecutor(new Ajuda());
        getCommand("fly").setExecutor(new Fly());
        getCommand("heal").setExecutor(new Heal());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("entidade").setExecutor(new Entidade());

    }

    private void carregarConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }


    /*
       public void startScheduler(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
        Bukkit.getConsoleSender().sendMessage("Olá");
       for (Player p : Bukkit.getOnlinePlayers()){
           p.sendMessage("Olá jogador");
        }
       }, 0, 20 *5);
       }
       */

    public static Projeto getInstance(){return instance;}
}


