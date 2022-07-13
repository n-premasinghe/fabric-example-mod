package net.npremas.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.npremas.mccourse.MCCourseMod;

import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item CHRONOCALCUM_INGOT = registerItem("chronocalcum_ingot",
            new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ItemGroup.MISC)));

    public static final Item RAW_CHRONOCALCUM = registerItem("raw_chronocalcum",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MCCourseMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering Mod Items for "  + MCCourseMod.MOD_ID);
    }

}
