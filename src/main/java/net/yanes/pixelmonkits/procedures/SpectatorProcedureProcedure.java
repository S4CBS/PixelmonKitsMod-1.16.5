package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class SpectatorProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency entity for procedure SpectatorProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
	}
}
