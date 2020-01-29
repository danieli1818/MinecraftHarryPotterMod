package com.danieli1818.minecraftmod.init;

import java.util.ArrayList;
import java.util.List;

import com.danieli1818.minecraftmod.items.ItemBase;
import com.danieli1818.minecraftmod.items.armor.ArmorBase;
import com.danieli1818.minecraftmod.items.food.FoodBase;
import com.danieli1818.minecraftmod.items.food.FoodEffectBase;
import com.danieli1818.minecraftmod.items.tools.ToolAxe;
import com.danieli1818.minecraftmod.items.tools.ToolHoe;
import com.danieli1818.minecraftmod.items.tools.ToolPickaxe;
import com.danieli1818.minecraftmod.items.tools.ToolSpade;
import com.danieli1818.minecraftmod.items.tools.ToolSword;
import com.danieli1818.minecraftmod.util.Reference;

import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Items
	public static final Item PLATINUM_INGOT = new ItemBase("platinum_ingot");
	
	//Materials
	public static final ToolMaterial MATERIAL_PLATINUM = EnumHelper.addToolMaterial("material_platinum", 3, 1561, 8.0F, 3.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial("armor_material_platinum", Reference.MOD_ID + ":platinum_ingot", 14, new int[] {2, 7, 5, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	//Tools
	public static final ItemSword PLATINUM_SWORD = new ToolSword("platinum_sword", MATERIAL_PLATINUM);
	public static final ItemSpade PLATINUM_SHOVEL = new ToolSpade("platinum_shovel", MATERIAL_PLATINUM);
	public static final ItemPickaxe PLATINUM_PICKAXE = new ToolPickaxe("platinum_pickaxe", MATERIAL_PLATINUM);
	public static final ItemAxe PLATINUM_AXE = new ToolAxe("platinum_axe", MATERIAL_PLATINUM);
	public static final ItemHoe PLATINUM_HOE = new ToolHoe("platinum_hoe", MATERIAL_PLATINUM);
	
	//Armor
	public static final Item PLATINUM_HELMET = new ArmorBase("platinum_helmet", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item PLATINUM_CHESTPLATE = new ArmorBase("platinum_chestplate", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item PLATINUM_LEGGINGS = new ArmorBase("platinum_leggings", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.LEGS);
	public static final Item PLATINUM_BOOTS = new ArmorBase("platinum_boots", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.FEET);
	
	//Food
	//public static final Item BERTIE_BOTTS_EVERY_FLAVOR_BEANS = new FoodBase("bertie_botts_every_flavor_beans", 4, 2.4f, false);
	public static final Item BERTIE_BOTTS_EVERY_FLAVOR_BEANS = new FoodEffectBase("bertie_botts_every_flavor_beans", 4, 2.4f, false, new PotionEffect(MobEffects.JUMP_BOOST, (60 * 20), 1, false, true));

}
