package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class NoWorkProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency entity for procedure NoWork!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
					("In this mod, this command is blocked. Use:\n"
							+ "/creative - Creative mode\n" + "/survival - Survival mod\n" + "/spectator - Spectator mod\n"
							+ "/adventure - Adventure mod")),
					(false));
		}
	}
}
