package com.danieli1818.minecraftmod.entity.render;

import com.danieli1818.minecraftmod.entity.EntityUnicorn;
import com.danieli1818.minecraftmod.entity.model.ModelUnicorn;
import com.danieli1818.minecraftmod.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderUnicorn extends RenderLiving<EntityUnicorn> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/unicorn.png");
	
	public static final ResourceLocation BABY_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/baby_unicorn.png");

	public RenderUnicorn(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelUnicorn(), 0.5F);
		// TODO Auto-generated constructor stub
	}
	
	protected ResourceLocation getEntityTexture(EntityUnicorn entity) {
		if (entity.isChild()) {
			return BABY_TEXTURES;
		}
		return TEXTURES;
	}

}
