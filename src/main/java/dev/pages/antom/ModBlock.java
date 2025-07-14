package dev.pages.antom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlock {
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }
    private static RegistryKey<Block> keyOfBlock(String name) { return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("blockexc", name)); }
    private static RegistryKey<Item> keyOfItem(String name) { return RegistryKey.of(RegistryKeys.ITEM, Identifier.of("blockexc", name)); }
    public static final Block CYN1 = register("cyn1", Block::new, AbstractBlock.Settings.copy(Blocks.STONE), true);
    public static final Block CYN2 = register("cyn2", Block::new, AbstractBlock.Settings.copy(Blocks.STONE), true);
    public static final Block CYN3 = register("cyn3", Block::new, AbstractBlock.Settings.copy(Blocks.STONE), true);
    public static final Block CYN4 = register("cyn4", Block::new, AbstractBlock.Settings.copy(Blocks.STONE), true);
    public static final Block CYN5 = register("cyn5", Block::new, AbstractBlock.Settings.copy(Blocks.STONE), true);
    public static void initialize() {}
}
