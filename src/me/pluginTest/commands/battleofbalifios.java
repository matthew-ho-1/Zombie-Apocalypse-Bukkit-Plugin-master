package me.pluginTest.commands;

import me.pluginTest.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import me.pluginTest.zombies.ZombieTypes;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class battleofbalifios implements CommandExecutor {
    private Main plugin;

    public battleofbalifios(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("battleofbalifios").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Location loc = p.getLocation();
        World w = p.getWorld();
        Entity specialZombie = w.spawnEntity(loc, EntityType.ZOMBIE);
        Zombie zombie = (Zombie) specialZombie;
        zombie.setCustomName("Biligerent Marauder Balifios: 200");
        zombie.setAdult();
        zombie.setMetadata("balifios", new FixedMetadataValue(plugin, "balifios"));
        ItemStack axe = new ItemStack(Material.IRON_AXE);
        axe.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        axe.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 2);
        axe.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        zombie.getEquipment().setItemInMainHand(axe);
        zombie.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(5);
        zombie.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(2);
        zombie.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(100);
        zombie.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).setBaseValue(2);
        zombie.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(.8);
        zombie.getAttribute(Attribute.ZOMBIE_SPAWN_REINFORCEMENTS).setBaseValue(.75);
        zombie.getEquipment().setItemInMainHandDropChance(1f);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 2));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 44));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 2, 20));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1));
        zombie.getServer().broadcastMessage("NOTE: You have summoned the Biligerent Marauder Balifios");
        zombie.getServer().broadcastMessage("Balifios: Mortal... You have made the wrong choice to bring me here. Prepare to die...");
        return true;
    }
}