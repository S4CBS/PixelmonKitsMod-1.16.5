package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsModVariables;
import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class FlyProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency world for procedure FlyProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency entity for procedure FlyProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (PixelmonkitsModVariables.MapVariables.get(world).fly == 0) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.allowFlying = (true);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
			PixelmonkitsModVariables.MapVariables.get(world).fly = 1;
			PixelmonkitsModVariables.MapVariables.get(world).syncData(world);
		} else if (PixelmonkitsModVariables.MapVariables.get(world).fly == 1) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.allowFlying = (false);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
			PixelmonkitsModVariables.MapVariables.get(world).fly = 0;
			PixelmonkitsModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.isFlying = (false);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
		}
	}
}
