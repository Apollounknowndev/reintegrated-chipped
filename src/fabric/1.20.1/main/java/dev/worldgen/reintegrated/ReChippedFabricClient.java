package dev.worldgen.reintegrated;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.world.level.block.Block;

public class ReChippedFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerColor(ReChippedClient.STANDARD_LEAVES_COLOR, ReChippedClient.STANDARD_LEAVES);
        registerColor(ReChippedClient.BIRCH_LEAVES_COLOR, ReChippedClient.BIRCH_LEAVES);
        registerColor(ReChippedClient.SPRUCE_LEAVES_COLOR, ReChippedClient.SPRUCE_LEAVES);
    }

    public static void registerColor(BlockColor blockColor, Block... blocks) {
        ColorProviderRegistry.BLOCK.register(blockColor, blocks);
        ColorProviderRegistry.ITEM.register(ReChippedClient.toItemColor(blockColor), blocks);
    }
}
