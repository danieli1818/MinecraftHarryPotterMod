package com.danieli1818.minecraftmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PlatinumBlock extends BlockBase {

	public PlatinumBlock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(4.5F);
		setResistance(30.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.0F);
	}

}
