package com.danieli1818.minecraftmod.entity.render;

import com.danieli1818.minecraftmod.entity.EntityWingedHorse;
import com.danieli1818.minecraftmod.entity.model.ModelWingedHorse;
import com.danieli1818.minecraftmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWingedHorse extends RenderLiving<EntityWingedHorse> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/winged_horse.png");
	
	public static final ResourceLocation BABY_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/baby_winged_horse.png");

	public RenderWingedHorse(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelWingedHorse(), 0.5F);
		// TODO Auto-generated constructor stub
	}
	
	protected ResourceLocation getEntityTexture(EntityWingedHorse entity) { // TODO fix it for children at the end.
//		if (entity.isChild()) {
//			return BABY_TEXTURES;
//		}
		return TEXTURES;
	}
}
