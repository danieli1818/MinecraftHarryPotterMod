package com.danieli1818.minecraftmod.init;

import com.danieli1818.minecraftmod.Main;
import com.danieli1818.minecraftmod.entity.EntityCentaur;
import com.danieli1818.minecraftmod.entity.EntityUnicorn;
import com.danieli1818.minecraftmod.entity.EntityWingedHorse;
import com.danieli1818.minecraftmod.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

	public static int UNICORN_ID = 120;
	public static int CENTAUR_ID = 121;
	public static int WINGED_HORSE_ID = 122;
	
	public static void registerEntities() {
		registerEntity("unicorn", EntityUnicorn.class, UNICORN_ID, 50, 11111111, 000000);
		registerEntity("centaur", EntityCentaur.class, CENTAUR_ID, 50, 11111111, 000000);
		registerEntity("winged_horse", EntityWingedHorse.class, WINGED_HORSE_ID, 50, 11111111, 000000);
	}
	
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
}
