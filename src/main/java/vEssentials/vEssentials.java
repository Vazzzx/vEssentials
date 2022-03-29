package vEssentials;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import vEssentials.comandos.*;
import vEssentials.eventos.InventoryClick;
import vEssentials.eventos.PlayerEvents;
import vEssentials.eventos.ServerEvents;
import vEssentials.utils.GerenciadorDeArquivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class vEssentials extends JavaPlugin  {

    private static vEssentials instance;

    public static HashMap<Player, Scoreboard> scoreboards = new HashMap<>();
    public static List<String> mensagens;

    public static vEssentials servidor;

    public static vEssentials receberServidor() {
        return servidor;
    }

    public static String host;
    public static String username;
    public static String password;
    public static String database;
    public static int port;
    public static Connection connection;


    @Override @SuppressWarnings("deprecation")
    public void onEnable() {
        servidor = this;

        GerenciadorDeArquivos.carregarArquivos().criarArquivos(servidor);
        iniciarConexaoSQL();
        getServer().getMessenger().registerOutgoingPluginChannel(vEssentials.receberServidor(), "BungeeCord");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§c§lvEssentials | v1.0");
        Bukkit.getConsoleSender().sendMessage(" §aPlugin iniciado com sucesso!");
        Bukkit.getConsoleSender().sendMessage(" ");
        carregarConfig();
        registrarEventos();
        registrarComandos();
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
    public static void enviarMensagens() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(receberServidor(), () -> {
            int random = new Random().nextInt(mensagens.size());
            for (Player todos : Bukkit.getOnlinePlayers()) {
                todos.sendMessage(" ");
                todos.sendMessage(mensagens.get(random));
                todos.sendMessage(" ");
                todos.playSound(todos.getLocation(), Sound.CLICK, 1.0F, 10.0F);
            }
        }, 0L, 1200L);
    }


    public static void iniciarConexaoSQL() {
        host = GerenciadorDeArquivos.carregarArquivos().receberDB().getString("host");
        username = GerenciadorDeArquivos.carregarArquivos().receberDB().getString("username");
        password = GerenciadorDeArquivos.carregarArquivos().receberDB().getString("password");
        database = GerenciadorDeArquivos.carregarArquivos().receberDB().getString("database");
        port = GerenciadorDeArquivos.carregarArquivos().receberDB().getInt("port");

        try {
            synchronized (vEssentials.receberServidor()) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection((Connection) DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password));
                Bukkit.getServer().getConsoleSender().sendMessage(" ");
                Bukkit.getServer().getConsoleSender().sendMessage("§c§lvEssentials | v1.0");
                Bukkit.getServer().getConsoleSender().sendMessage(" §bConectado com o banco de dados.");
                Bukkit.getServer().getConsoleSender().sendMessage(" ");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            Bukkit.getServer().shutdown();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        vEssentials.connection = connection;
    }


    public static vEssentials getInstance(){return instance;}
}



