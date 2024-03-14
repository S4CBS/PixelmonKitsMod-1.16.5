package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsModVariables;
import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class AdventureProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency world for procedure AdventureProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency entity for procedure AdventureProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.ADVENTURE);
		if (PixelmonkitsModVariables.MapVariables.get(world).god == 1) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.disableDamage = (true);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
		}
		if (PixelmonkitsModVariables.MapVariables.get(world).fly == 1) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.isFlying = (true);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.allowFlying = (true);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
		}
	}
}
