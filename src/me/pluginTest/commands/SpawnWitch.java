package me.pluginTest.commands;

import java.text.Format;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import me.pluginTest.Main;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;

public class SpawnWitch implements CommandExecutor {
    private Main plugin;

    public SpawnWitch(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("summonwitch").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Location loc = p.getLocation();
        World w = p.getWorld();
        Entity specialZombie = w.spawnEntity(loc, EntityType.ZOMBIE);
        Zombie zombie = (Zombie) specialZombie;
        p.getServer().broadcastMessage("Witch spawned");
        zombie.setAdult();
        zombie.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(7);
        zombie.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(.25);
        zombie.getAttribute(Attribute.ZOMBIE_SPAWN_REINFORCEMENTS).setBaseValue(.75);
        zombie.getEquipment().setHelmet(new ItemStack(Material.CREEPER_HEAD));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000000, 44));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 3));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 3));
        zombie.setCustomName("Witch");
        return true;
    }
}
