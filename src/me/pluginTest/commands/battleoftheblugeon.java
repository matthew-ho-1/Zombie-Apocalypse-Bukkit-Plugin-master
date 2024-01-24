package me.pluginTest.commands;

import me.pluginTest.Main;
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
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class battleoftheblugeon implements CommandExecutor {
    private Main plugin;

    public battleoftheblugeon(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("battleoftheblugeon").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Location loc = p.getLocation();
        World w = p.getWorld();
        Entity specialZombie = w.spawnEntity(loc, EntityType.ZOMBIE);
        Zombie zombie = (Zombie) specialZombie;
        zombie.setCustomName("The Blugeon: 500");
        zombie.setAdult();
        zombie.setMetadata("blugeon", new FixedMetadataValue(plugin, "blugeon"));
        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        chestplate.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
        chestplate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chestplate.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
        boots.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
        boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        zombie.getEquipment().setChestplate(chestplate);
        zombie.getEquipment().setBoots(boots);
        zombie.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(30);
        zombie.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(12);
        zombie.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(6);
        zombie.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(100);
        zombie.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK).setBaseValue(4);
        zombie.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(1);
        zombie.getAttribute(Attribute.ZOMBIE_SPAWN_REINFORCEMENTS).setBaseValue(.85);
        zombie.getEquipment().setChestplateDropChance(1f);
        zombie.getEquipment().setBootsDropChance(1f);
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 119));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 2, 30));
        zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 3));
        List<Player> players=w.getPlayers();
        for (Player player: players){
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120000, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120000, 1));
        }
        zombie.getServer().broadcastMessage("NOTE: Darkness fills all...");
        zombie.getServer().broadcastMessage("???????????????????????");
        return true;
    }
}