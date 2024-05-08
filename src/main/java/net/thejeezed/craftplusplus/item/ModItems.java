package net.thejeezed.craftplusplus.item;

import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thejeezed.craftplusplus.CraftPlusPlus;
import net.thejeezed.craftplusplus.enums.tools.ToolStats;
import net.thejeezed.craftplusplus.item.custom.armor.CopperArmor;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, CraftPlusPlus.MOD_ID);

    public static final RegistryObject<Item> ITEM_HERE = ITEMS.register("item_here", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_BUCKET = ITEMS.register("copper_bucket", ()-> new BucketItem(Fluids.WATER, new Item.Properties().stacksTo(1)));
    //TODO add texture for the bucket

    //Food Section(idk why i am putting a comment
    public static final RegistryObject<Item> RAW_TENTACLE = ITEMS.register("raw_tentacle", ()-> new Item(new Item.Properties().food(ModFoods.RAW_TENTACLE)));
    public static final RegistryObject<Item> COOKED_TENTACLE = ITEMS.register("cooked_tentacle", ()-> new Item(new Item.Properties().food(ModFoods.COOKED_TENTACLE)));
    public static final RegistryObject<Item> SEA_SOUP = ITEMS.register("sea_soup", ()-> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoods.SEA_SOUP)));

    //COPPER TOOLS/THINGS
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", ()-> new SwordItem(ToolStats.COPPER,3,-2.4F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", ()-> new AxeItem(ToolStats.COPPER,6.0F,-3.1F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", ()-> new PickaxeItem(ToolStats.COPPER,1,-2.8F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", ()-> new ShovelItem(ToolStats.COPPER,1.5F,-3.0F, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", ()-> new HoeItem(ToolStats.COPPER,-2,-1.0F, new Item.Properties()));
    //TODO need textures for all of the tools

    //COPPER ARMOR
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> CopperArmor.getInstance(ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> CopperArmor.getInstance(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> CopperArmor.getInstance(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> CopperArmor.getInstance(ArmorItem.Type.BOOTS));
    //TODO need textures for all, then remind me and ill add the trims

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}