package com.danieli1818.minecraftmod.util.handler;

import com.danieli1818.minecraftmod.entity.EntityCentaur;
import com.danieli1818.minecraftmod.entity.EntityUnicorn;
import com.danieli1818.minecraftmod.entity.EntityWingedHorse;
import com.danieli1818.minecraftmod.entity.render.RenderCentaur;
import com.danieli1818.minecraftmod.entity.render.RenderUnicorn;
import com.danieli1818.minecraftmod.entity.render.RenderWingedHorse;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new IRenderFactory<EntityUnicorn>() {
			public Render<? super EntityUnicorn> createRenderFor(RenderManager manager) {
				return new RenderUnicorn(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new IRenderFactory<EntityCentaur>() {
			public Render<? super EntityCentaur> createRenderFor(RenderManager manager) {
				return new RenderCentaur(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityWingedHorse.class, new IRenderFactory<EntityWingedHorse>() {
			public Render<? super EntityWingedHorse> createRenderFor(RenderManager manager) {
				return new RenderWingedHorse(manager);
			}
		});
	}
	
}
