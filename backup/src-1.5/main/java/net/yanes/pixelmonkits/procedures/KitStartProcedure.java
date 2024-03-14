package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsModVariables;
import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;

public class KitStartProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency world for procedure KitStart!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency x for procedure KitStart!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency y for procedure KitStart!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency z for procedure KitStart!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency entity for procedure KitStart!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (PixelmonkitsModVariables.MapVariables.get(world).kitstart == 0) {
			PixelmonkitsModVariables.MapVariables.get(world).kitstart = 1;
			PixelmonkitsModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/give " + entity.getDisplayName().getString() + " " + "pixelmon:poke_ball{PokeBallID:\"master_ball\"}"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/give " + entity.getDisplayName().getString() + " " + "pixelmon:poke_ball{PokeBallID:\"great_ball\"} 32"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/give " + entity.getDisplayName().getString() + " " + "pixelmon:poke_ball{PokeBallID:\"quick_ball\"} 16"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/give " + entity.getDisplayName().getString() + " " + "pixelmon:poke_ball{PokeBallID:\"ultra_ball\"} 16"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/give " + entity.getDisplayName().getString() + " " + "minecraft:diamond_pickaxe"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/give " + entity.getDisplayName().getString() + " " + "minecraft:diamond_axe"));
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						("/give " + entity.getDisplayName().getString() + " " + "minecraft:diamond_shovel"));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"Kit Sart \u0443\u0436\u0435 \u0431\u044B\u043B \u043F\u043E\u043B\u0443\u0447\u0435\u043D \u0440\u0430\u043D\u0435\u0435"),
						(false));
			}
		}
	}
}
