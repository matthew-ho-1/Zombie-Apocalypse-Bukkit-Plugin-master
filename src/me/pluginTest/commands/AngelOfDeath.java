package me.pluginTest.commands;

import me.pluginTest.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;

public class AngelOfDeath implements CommandExecutor {
    private final Main plugin;

    public AngelOfDeath(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("angelofdeath").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // Reset Suffix
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Boss suffix \"\"");

        // Announce Kit
        Bukkit.getServer().broadcastMessage(player.getDisplayName() + ChatColor.RESET + " has chosen the " + ChatColor.GOLD + "Angel of Death" + ChatColor.RESET + " kit.");

        // Select Kit
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "scoreboard players set @p kit 100");

        // Set Suffix
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "team modify Boss suffix \" the Angel of Death\"");

        // Theme
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run time set night");

        // Wysteria Flame
        giveItem(player, Material.GOLDEN_HOE, "Wysteria Flames", "Witness the glory of death by flame.", Enchantment.FIRE_ASPECT, 4, Enchantment.DAMAGE_ALL, 10);

        // Crossbow
        giveItem2(player, Material.CROSSBOW, "Retribution", "Toxins shall consume you.", Enchantment.MULTISHOT, 1, Enchantment.PIERCING, 5, Enchantment.QUICK_CHARGE, 2);

        // Plague
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run execute as @s at @s run summon item ~ ~ ~ {Item:{id:\"minecraft:splash_potion\",Count:5b,tag:{display:{Name:'{\"text\":\"The Plague\",\"color\":\"#A1A1A1\",\"bold\":true,\"italic\":false}',Lore:['{\"text\":\"Wither unto nothingness.\",\"color\":\"#BFBFBF\"}']},CustomPotionEffects:[{Id:20,Amplifier:0b,Duration:1800}],CustomPotionColor:0}}}");

        // Ender Pearl
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give @a[scores={kit=100}] ender_pearl 10");

        // Poison Arrow
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give @a[scores={kit=100}] minecraft:tipped_arrow{display:{Name:'{\"text\":\"Deadly Toxin\",\"color\":\"#03AD64\",\"bold\":true,\"italic\":false}',Lore:['{\"text\":\"Welcome to my world...\",\"color\":\"#047500\"}']},CustomPotionEffects:[{Id:2,Amplifier:1b,Duration:60},{Id:19,Amplifier:0b,Duration:160}]} 64");

        // Boss HP
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run attribute @s minecraft:generic.max_health base set 750");

        // Bossbar HP
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run bossbar set bossbar:currentboss max 750");

        // Movespeed
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run attribute @s minecraft:generic.movement_speed base set 0.2");

        // Knockback Resist
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run attribute @s minecraft:generic.knockback_resistance base set 0.35");

        // Resistance
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run effect give @s minecraft:resistance infinite 0 true");

        // Regeneration
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run effect give @s minecraft:regeneration infinite 0 true");

        // Night Vision
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute as @a[scores={kit=100}] run effect give @s minecraft:night_vision infinite 0 true");

        // Label
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute positioned 20 53 -662 run give @p[team=Boss] golden_hoe{display:{Name:'{\"text\":\"Angel of Death\",\"color\":\"#F5A402\",\"bold\":true,\"italic\":false}',Lore:['{\"text\":\"Witness the glory of death by flame.\",\"color\":\"#FF792B\"}']},Unbreakable:1b,Enchantments:[{id:\"minecraft:sharpness\",lvl:5s},{id:\"minecraft:fire_aspect\",lvl:4s}],AttributeModifiers:[{AttributeName:\"generic.attack_speed\",Name:\"generic.attack_speed\",Amount:1,Operation:0,UUID:[I;-1243442521,-602847900,-2069771333,-287757718],Slot:\"mainhand\"}]} 1");

        // Book
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give @p written_book{display:{Name:'{\"text\":\"Angel of Death\",\"color\":\"#F5A402\",\"bold\":true,\"italic\":false}',Lore:['{\"text\":\"Not many see the angel and live to tell the tale\",\"color\":\"#FF792B\"}']},title:\"Angel of Death\",author:\"unknown c.a 1857\",pages:['{\"text\":\"Angel of Death\\\\n\\\\nAll an all-seeing entity who sentences mortals to a slow and painful death.\\\\n\\\\n\\\\\"Infect, Wither, and Burn...\\\\\"\"}']} 1");
        return true;
    }

    private void giveItem2(Player player, Material material, String displayName, String lore, Enchantment enchantment1, int level1, Enchantment enchantment2, int level2, Enchantment enchantment3, int level3) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        itemMeta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', lore)));
        itemMeta.addEnchant(enchantment1, level1, true);
        itemMeta.addEnchant(enchantment2, level2, true);
        itemMeta.addEnchant(enchantment3, level3, true);
        itemStack.setItemMeta(itemMeta);
        player.getInventory().addItem(itemStack);
    }

    private void giveItem(Player player, Material material, String displayName, String lore, Enchantment enchantment1, int level1, Enchantment enchantment2, int level2) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        itemMeta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', lore)));
        itemMeta.addEnchant(enchantment1, level1, true);
        itemMeta.addEnchant(enchantment2, level2, true);
        itemStack.setItemMeta(itemMeta);
        player.getInventory().addItem(itemStack);
    }
}
