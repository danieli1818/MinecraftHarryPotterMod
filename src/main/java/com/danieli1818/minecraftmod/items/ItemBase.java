package com.danieli1818.minecraftmod.items;

import com.danieli1818.minecraftmod.Main;
import com.danieli1818.minecraftmod.init.ModItems;
import com.danieli1818.minecraftmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		
		
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

	
	
}
