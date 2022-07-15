package net.npremas.mccourse.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.npremas.mccourse.MCCourseMod;
import net.npremas.mccourse.item.ModItemGroups;

public class ModBlocks {

    public static final Block CHRONOCALCUM_BLOCK = registerBlock("chronocalcum_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroups.COURSE);

    public static final Block CHRONOCALCUM_ORE = registerBlock("chronocalcum_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroups.COURSE);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MCCourseMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MCCourseMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        System.out.println("Registering Mod Blocks for " + MCCourseMod.MOD_ID);
    }

}
