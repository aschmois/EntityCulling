package net.fabricmc.example;

import dev.tr7zw.entityculling.occlusionculling.OcclusionCullingInstance;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ExampleMod implements ModInitializer {
	
	public static ExampleMod instance;
	public final OcclusionCullingInstance culling = new OcclusionCullingInstance();
	public boolean debug = false;
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		instance = this;
		ClientTickEvents.START_WORLD_TICK.register((event) -> {
			culling.resetCache();
		});
		System.out.println("Loaded entity culling!");
	}
}