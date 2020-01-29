package com.danieli1818.minecraftmod.items.tools;

import com.danieli1818.minecraftmod.Main;
import com.danieli1818.minecraftmod.init.ModItems;
import com.danieli1818.minecraftmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel {

	public ToolSpade(String toolName, ToolMaterial material) {
		super(material);
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