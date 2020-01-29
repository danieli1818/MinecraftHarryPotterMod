package com.danieli1818.minecraftmod.init;

import java.util.ArrayList;
import java.util.List;

import com.danieli1818.minecraftmod.blocks.BlockBase;
import com.danieli1818.minecraftmod.blocks.PlatinumBlock;
import com.danieli1818.minecraftmod.blocks.PlatinumOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block PLATINUM_BLOCK = new PlatinumBlock("platinum_block", Material.IRON);
	public static final Block PLATINUM_ORE = new PlatinumOre("platinum_ore", Material.IRON);
	
}
