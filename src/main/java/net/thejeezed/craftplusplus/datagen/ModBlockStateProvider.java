package net.thejeezed.craftplusplus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thejeezed.craftplusplus.CraftPlusPlus;
import net.thejeezed.craftplusplus.block.ModBlocks;
import net.thejeezed.craftplusplus.block.crops.CottonCropBlock;

import java.util.function.Function;

import static net.thejeezed.craftplusplus.block.ModBlocks.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CraftPlusPlus.MOD_ID, exFileHelper);
    }

    //Adds blockstates
    //If you want for Crops or other blocks ask @luhcarti hell add it

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SMOOTH_AMETHYST);
        blockWithItem(ModBlocks.AMETHYST_BRICK);

        slabBlock(((SlabBlock) ModBlocks.AMETHYST_SLAB.get()), blockTexture(Blocks.AMETHYST_BLOCK), blockTexture(Blocks.AMETHYST_BLOCK));
        slabBlock(((SlabBlock) ModBlocks.AMETHYST_BRICK_SLAB.get()), blockTexture(ModBlocks.AMETHYST_BRICK.get()), blockTexture(ModBlocks.AMETHYST_BRICK.get()));
        slabBlock(((SlabBlock) ModBlocks.SMOOTH_AMETHYST_SLAB.get()), blockTexture(ModBlocks.SMOOTH_AMETHYST.get()), blockTexture(ModBlocks.SMOOTH_AMETHYST.get()));

        stairsBlock(((StairBlock) ModBlocks.AMETHYST_STAIRS.get()), blockTexture(Blocks.AMETHYST_BLOCK));
        stairsBlock(((StairBlock) ModBlocks.AMETHYST_BRICK_STAIRS.get()), blockTexture(ModBlocks.AMETHYST_BRICK.get()));
        stairsBlock(((StairBlock) ModBlocks.SMOOTH_AMETHYST_STAIRS.get()), blockTexture(ModBlocks.SMOOTH_AMETHYST.get()));

        wallBlock(((WallBlock) AMETHYST_WALL.get()), blockTexture(Blocks.AMETHYST_BLOCK));
        wallBlock(((WallBlock) AMETHYST_BRICK_WALL.get()), blockTexture(ModBlocks.AMETHYST_BRICK.get()));
        wallBlock(((WallBlock) SMOOTH_AMETHYST_WALL.get()), blockTexture(SMOOTH_AMETHYST.get()));

        makeCottonCrop((CropBlock)COTTON_CROP.get(), "cotton_stage", "cotton_stage");
    }

    public void makeCottonCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cottonStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cottonStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CottonCropBlock) block).getAgeProperty()),
                new ResourceLocation(CraftPlusPlus.MOD_ID, "block/" + textureName + state.getValue(((CottonCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}