package com.danieli1818.minecraftmod.items.tools;

import com.danieli1818.minecraftmod.Main;
import com.danieli1818.minecraftmod.init.ModItems;
import com.danieli1818.minecraftmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {

	public ToolAxe(String toolName, ToolMaterial material) {
		super(material, 6.0F, -3.2F);
		setUnlocalizedName(toolName);
		setRegistryName(toolName);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	
	
	

}
