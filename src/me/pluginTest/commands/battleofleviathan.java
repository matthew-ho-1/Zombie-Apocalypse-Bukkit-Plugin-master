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
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import me.pluginTest.zombies.ZombieTypes;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class battleofleviathan implements CommandExecutor {
    private Main plugin;

    public battleofleviathan(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("battleofleviathan").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        Location loc = p.getLocation();
        World w = p.getWorld();
        w.setThundering(true);
        w.setThunderDuration(12000);
        Entity specialZombie = w.spawnEntity(loc, EntityType.DROWNED);
        Drowned drowned = (Drowned) specialZombie;
        drowned.setCustomName("Vashia of the Waters, Leviathan: 300");
        drowned.setAdult();
        drowned.setMetadata("leviathan", new FixedMetadataValue(plugin, "leviathan"));
        ItemStack trident = new ItemStack(Material.TRIDENT);
        trident.addUnsafeEnchantment(Enchantment.DURABILITY, 50);
        trident.addUnsafeEnchantment(Enchantment.RIPTIDE, 5);
        trident.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
        drowned.getEquipment().setItemInMainHand(trident);
        drowned.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(8);
        drowned.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).setBaseValue(4);
        drowned.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(100);
        drowned.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(.5);
        drowned.getAttribute(Attribute.ZOMBIE_SPAWN_REINFORCEMENTS).setBaseValue(.25);
        drowned.getEquipment().setItemInMainHandDropChance(1f);
        drowned.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 2));
        drowned.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 69));
        drowned.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 2, 20));
        drowned.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 2));
        drowned.getServer().broadcastMessage("NOTE: It has started raining!");
        drowned.getServer().broadcastMessage("Leviathan: Fear the wrath of the waters.");
        return true;
    }
}