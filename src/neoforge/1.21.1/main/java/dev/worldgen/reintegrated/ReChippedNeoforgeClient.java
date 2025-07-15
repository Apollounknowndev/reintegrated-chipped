package dev.worldgen.reintegrated;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import static dev.worldgen.reintegrated.ReChippedClient.toItemColor;

@Mod(ReChipped.MOD_ID)
public class ReChippedNeoforgeClient {
    public ReChippedNeoforgeClient(IEventBus bus) {
        if (FMLLoader.getDist() == Dist.CLIENT) {
            bus.addListener((RegisterColorHandlersEvent.Block event) -> {
                event.register(ReChippedClient.STANDARD_LEAVES_COLOR, ReChippedClient.STANDARD_LEAVES);
                event.register(ReChippedClient.BIRCH_LEAVES_COLOR, ReChippedClient.BIRCH_LEAVES);
                event.register(ReChippedClient.SPRUCE_LEAVES_COLOR, ReChippedClient.SPRUCE_LEAVES);
            });
            bus.addListener((RegisterColorHandlersEvent.Item event) -> {
                event.register(toItemColor(ReChippedClient.STANDARD_LEAVES_COLOR), ReChippedClient.STANDARD_LEAVES);
                event.register(toItemColor(ReChippedClient.BIRCH_LEAVES_COLOR), ReChippedClient.BIRCH_LEAVES);
                event.register(toItemColor(ReChippedClient.SPRUCE_LEAVES_COLOR), ReChippedClient.SPRUCE_LEAVES);
            });
        }
    }
}
