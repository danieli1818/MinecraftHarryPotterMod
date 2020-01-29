package com.danieli1818.minecraftmod.entity.render;

import com.danieli1818.minecraftmod.entity.EntityCentaur;
import com.danieli1818.minecraftmod.entity.EntityUnicorn;
import com.danieli1818.minecraftmod.entity.model.ModelCentaur;
import com.danieli1818.minecraftmod.entity.model.ModelUnicorn;
import com.danieli1818.minecraftmod.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderCentaur extends RenderLiving<EntityCentaur> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/centaur.png");

	public RenderCentaur(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelCentaur(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		// TODO Auto-generated constructor stub
	}
	
	protected ResourceLocation getEntityTexture(EntityCentaur entity) {
		return TEXTURES;
	}

}
