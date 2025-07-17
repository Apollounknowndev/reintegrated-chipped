package dev.worldgen.reintegrated;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.chipped.common.registry.ModBlocks;
import earth.terrarium.chipped.common.registry.base.ChippedPaletteRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.ArrayUtils;

public class ReChippedClient {
    public static final BlockColor STANDARD_LEAVES_COLOR = (state, getter, pos, i) -> {
        if (i != 0) {
            return getter != null && pos != null ? BiomeColors.getAverageFoliageColor(getter, pos) : FoliageColor.getDefaultColor();
        } else {
            return -1;
        }
    };
    public static final BlockColor BIRCH_LEAVES_COLOR = (state, getter, pos, i) -> i == 0 ? -1 : FoliageColor.getBirchColor();
    public static final BlockColor SPRUCE_LEAVES_COLOR = (state, getter, pos, i) -> i == 0 ? -1 : FoliageColor.getEvergreenColor();

    public static final Block[] STANDARD_LEAVES = ArrayUtils.addAll(
        ArrayUtils.addAll(
            getBlocks(ModBlocks.ACACIA_LEAVES),
            getBlocks(ModBlocks.DARK_OAK_LEAVES)
        ),
        ArrayUtils.addAll(
            getBlocks(ModBlocks.JUNGLE_LEAVES),
            getBlocks(ModBlocks.OAK_LEAVES)
        )
    );
    public static final Block[] BIRCH_LEAVES = getBlocks(ModBlocks.BIRCH_LEAVES);
    public static final Block[] SPRUCE_LEAVES = getBlocks(ModBlocks.SPRUCE_LEAVES);

    public static ItemColor toItemColor(BlockColor blockColor) {
        return (stack, i) -> blockColor.getColor(((BlockItem)stack.getItem()).getBlock().defaultBlockState(), null, null, i);
    }

    public static Block[] getBlocks(ChippedPaletteRegistry<Block> palette) {
        return palette.getEntries().stream().map(RegistryEntry::get).toList().toArray(new Block[0]);
    }
}
