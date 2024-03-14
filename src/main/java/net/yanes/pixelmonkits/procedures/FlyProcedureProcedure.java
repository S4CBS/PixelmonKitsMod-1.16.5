package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsModVariables;
import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fly \u0432\u043A\u043B\u044E\u0447\u0435\u043D"), (false));
			}
		} else if (PixelmonkitsModVariables.MapVariables.get(world).fly == 1) {
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).abilities.allowFlying = (true);
					((PlayerEntity) entity).sendPlayerAbilities();
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							"Fly \u0432 Creative \u043D\u0435 \u043C\u043E\u0436\u0435\u0442 \u0431\u044B\u0442\u044C \u043E\u0442\u043A\u043B\u044E\u0447\u0435\u043D("),
							(false));
				}
				PixelmonkitsModVariables.MapVariables.get(world).fly = 1;
				PixelmonkitsModVariables.MapVariables.get(world).syncData(world);
			} else {
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
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fly \u0432\u044B\u043A\u043B\u044E\u0447\u0435\u043D"),
							(false));
				}
			}
		}
	}
}
