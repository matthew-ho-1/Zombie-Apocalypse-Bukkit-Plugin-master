package me.pluginTest.nether;

import net.minecraft.server.v1_16_R3.GenericAttributes;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.pluginTest.Main;

import java.util.List;
import java.util.Random;

import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class empoweredMobs implements Listener {
    private Main plugin;

    public empoweredMobs(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent e) {
        try {
            Random num = new Random();
            EntityType type = e.getEntityType();
            int empowered = num.nextInt(15);
            if (type.equals(EntityType.SKELETON)) {
                Skeleton skeleton = (Skeleton) e.getEntity();
                skeleton.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000000, 4));
                if (empowered >= 7) {
                    ItemStack helmet = new ItemStack(Material.GOLDEN_HELMET);
                    ItemStack boots = new ItemStack(Material.GOLDEN_BOOTS);
                    helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
                    boots.addEnchantment(Enchantment.SOUL_SPEED, 3);
                    skeleton.getEquipment().setHelmet(helmet);
                    skeleton.getEquipment().setBoots(boots);
                    skeleton.getEquipment().setHelmetDropChance(0.05f);
                    skeleton.getEquipment().setBootsDropChance(0.05f);
                    if (empowered >= 11) {
                        skeleton.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(60);
                        ItemStack bow = new ItemStack(Material.BOW);
                        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
                        skeleton.getEquipment().setItemInMainHand(bow);
                        skeleton.getEquipment().setItemInMainHandDropChance(0.05f);
                    }
                    if (empowered == 13) {
                        skeleton.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(80);
                        skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 0));
                        helmet = new ItemStack(Material.NETHERITE_HELMET);
                        ItemStack chest = new ItemStack(Material.GOLDEN_CHESTPLATE);
                        ItemStack legs = new ItemStack(Material.GOLDEN_LEGGINGS);
                        boots = new ItemStack(Material.NETHERITE_BOOTS);
                        ItemStack bow = new ItemStack(Material.BOW);
                        helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
                        helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                        boots.addEnchantment(Enchantment.SOUL_SPEED, 3);
                        boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
                        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
                        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
                        skeleton.getEquipment().setHelmet(helmet);
                        skeleton.getEquipment().setChestplate(chest);
                        skeleton.getEquipment().setLeggings(legs);
                        skeleton.getEquipment().setBoots(boots);
                        skeleton.getEquipment().setItemInMainHand(bow);
                        skeleton.getEquipment().setHelmetDropChance(0.02f);
                        skeleton.getEquipment().setBootsDropChance(0.02f);
                        skeleton.getEquipment().setItemInMainHandDropChance(0.02f);
                    }
                }
            }
            else if (type.equals(EntityType.WITHER_SKELETON)) {
                WitherSkeleton wither = (WitherSkeleton) e.getEntity();
                wither.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100000, 4));
                if (empowered >= 7) {
                    ItemStack chest = new ItemStack(Material.GOLDEN_CHESTPLATE);
                    ItemStack legs = new ItemStack(Material.GOLDEN_LEGGINGS);
                    ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                    chest.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
                    legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    boots.addEnchantment(Enchantment.PROTECTION_FIRE, 3);
                    boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    wither.getEquipment().setChestplate(chest);
                    wither.getEquipment().setLeggings(legs);
                    wither.getEquipment().setBoots(boots);
                    wither.getEquipment().setBootsDropChance(0.01f);
                    if (empowered >= 12) {
                        wither.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100000, 9));
                        wither.getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(50);
                        wither.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 0));
                        ItemStack sword = new ItemStack(Material.IRON_SWORD);
                        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
                        chest = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        legs = new ItemStack(Material.IRON_LEGGINGS);
                        boots = new ItemStack(Material.NETHERITE_BOOTS);
                        helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                        chest.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
                        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        chest.addEnchantment(Enchantment.DURABILITY, 3);
                        legs.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                        boots.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
                        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                        sword.addEnchantment(Enchantment.SWEEPING_EDGE, 1);
                        sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
                        wither.getEquipment().setHelmet(helmet);
                        wither.getEquipment().setChestplate(chest);
                        wither.getEquipment().setLeggings(legs);
                        wither.getEquipment().setBoots(boots);
                        wither.getEquipment().setItemInMainHand(sword);
                        wither.getEquipment().setChestplateDropChance(0.01f);
                        wither.getEquipment().setBootsDropChance(0.01f);
                        wither.getEquipment().setItemInMainHandDropChance(0.01f);
                    }
                }
            }
            else if (type.equals(EntityType.PIGLIN)) {
                Piglin piglin = (Piglin) e.getEntity();
                piglin.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 3));
                piglin.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 100000, 4));
                piglin.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100000, 1));
                piglin.setAdult();
                if (empowered >= 13) {
                    World w = e.getEntity().getWorld();
                    if (w.getEnvironment().equals(World.Environment.NETHER)) {
                        Location loc = e.getLocation();
                        e.getEntity().remove();
                        PiglinBrute brute = (PiglinBrute) w.spawnEntity(loc, EntityType.PIGLIN_BRUTE);
                        brute.setAdult();
                        brute.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(8);
                        brute.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1));
                        brute.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
                    }
                }
                else if (empowered >= 6) {
                    piglin.getEquipment().setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
                    piglin.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS));
                    if (empowered >= 8) {
                        piglin.setAdult();
                        piglin.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0));
                    }
                    if (empowered >= 9) {
                        piglin.setAdult();
                        piglin.getEquipment().setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
                    }
                    if (empowered >= 10) {
                        piglin.setAdult();
                        ItemStack sword = new ItemStack(Material.GOLDEN_SWORD);
                        ItemStack chest = new ItemStack(Material.GOLDEN_CHESTPLATE);
                        sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        chest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                        piglin.getEquipment().setItemInMainHand(sword);
                        piglin.getEquipment().setChestplate(chest);
                    }
                    if (empowered == 11 || empowered == 12) {
                        piglin.setAdult();
                        ItemStack sword = new ItemStack(Material.IRON_SWORD);
                        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
                        sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                        chest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
                        boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);
                        piglin.getEquipment().setItemInMainHand(sword);
                        piglin.getEquipment().setChestplate(chest);
                        piglin.getEquipment().setBoots(boots);
                        piglin.getEquipment().setChestplateDropChance(0.01f);
                        piglin.getEquipment().setBootsDropChance(0.01f);
                        piglin.getEquipment().setItemInMainHandDropChance(0.01f);
                        piglin.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1));
                    }
                }
            }
            else if (type.equals(EntityType.BLAZE)) {
                Blaze blaze = (Blaze) e.getEntity();
                blaze.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 4));
                blaze.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 10));
                if (empowered >= 6) {
                    blaze.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0));
                    if (empowered >= 9) {
                        blaze.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 0));
                        blaze.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
                    }
                }
            }
            else if (type.equals(EntityType.GHAST)){
                Ghast ghast = (Ghast) e.getEntity();
                ghast.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 9));
                ghast.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 9));
                ghast.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(10);
            }
            else if (type.equals(EntityType.ZOMBIFIED_PIGLIN)){
                PigZombie zpiglin = (PigZombie) e.getEntity();
                zpiglin.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 4));
                zpiglin.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 4));
                zpiglin.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 1));
                zpiglin.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 1000000, 0));
            }
            else if (type.equals(EntityType.HOGLIN)){
                Hoglin hog = (Hoglin) e.getEntity();
                hog.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 9));
                hog.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 9));
                hog.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0));
                hog.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 0));
            }
            else if (type.equals(EntityType.ZOGLIN)){
                Zoglin zog = (Zoglin) e.getEntity();
                zog.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 9));
                zog.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 9));
                zog.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0));
                zog.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 0));
            }
            else if (type.equals(EntityType.PIGLIN_BRUTE)){
                if (e.getSpawnReason().equals(SpawnReason.CUSTOM) || e.getSpawnReason().equals(SpawnReason.DEFAULT))
                    return;
                PiglinBrute brute = (PiglinBrute) e.getEntity();
                brute.setAdult();
                brute.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(10);
                brute.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, 14));
                brute.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 9));
                brute.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 1));
                brute.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, 1));
            }
        } catch (Exception o) {
                o.printStackTrace();
            e.setCancelled(true);
        }
    }
}
