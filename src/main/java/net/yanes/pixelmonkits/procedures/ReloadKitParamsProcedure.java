package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsModVariables;
import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class ReloadKitParamsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency world for procedure ReloadKitParams!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency entity for procedure ReloadKitParams!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (PixelmonkitsModVariables.MapVariables.get(world).kitstart == 0) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kit Start \u0434\u043E\u0441\u0442\u0443\u043F\u0435\u043D!"),
						(false));
			}
		} else if (PixelmonkitsModVariables.MapVariables.get(world).kitstart == 1) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("Kit Start \u0441\u043D\u043E\u0432\u0430 \u0434\u043E\u0441\u0442\u0443\u043F\u0435\u043D!"),
						(false));
			}
			PixelmonkitsModVariables.MapVariables.get(world).kitstart = 0;
			PixelmonkitsModVariables.MapVariables.get(world).syncData(world);
		}
		if (PixelmonkitsModVariables.MapVariables.get(world).kitstartplus == 0) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kit StartPlus \u0434\u043E\u0441\u0442\u0443\u043F\u0435\u043D!"),
						(false));
			}
		} else if (PixelmonkitsModVariables.MapVariables.get(world).kitstartplus == 1) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("Kit StartPlus \u0441\u043D\u043E\u0432\u0430 \u0434\u043E\u0441\u0442\u0443\u043F\u0435\u043D!"),
						(false));
			}
			PixelmonkitsModVariables.MapVariables.get(world).kitstartplus = 0;
			PixelmonkitsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
