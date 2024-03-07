package net.yanes.pixelmonkits.procedures;

import net.yanes.pixelmonkits.PixelmonkitsModVariables;
import net.yanes.pixelmonkits.PixelmonkitsMod;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import java.util.Map;

public class CheckStatusProcedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PixelmonkitsMod.LOGGER.warn("Failed to load dependency world for procedure CheckStatusProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (PixelmonkitsModVariables.MapVariables.get(world).god == 0) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("god off"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		} else if (PixelmonkitsModVariables.MapVariables.get(world).god == 1) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("god on"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
		if (PixelmonkitsModVariables.MapVariables.get(world).fly == 0) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("fly off"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		} else if (PixelmonkitsModVariables.MapVariables.get(world).fly == 1) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("fly on"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
	}
}
