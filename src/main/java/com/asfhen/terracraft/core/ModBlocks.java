package com.asfhen.terracraft.core;


import com.asfhen.terracraft.Reference;
import com.asfhen.terracraft.Terracraft;
import com.asfhen.terracraft.block.*;
import com.asfhen.terracraft.util.Names;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final Material WOOD = Material.WOOD;
    public static final Material METAL = Material.IRON;

    private static final List<Block> BLOCKS = new ArrayList<>();
    private static final List<Item> ITEMS = new ArrayList<>();

    /**
     *  Blocks
     */
    public static final Block COPPER_ORE = register(Names.Blocks.COPPER_ORE, new CopperOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.METAL)));
    public static final Block TIN_ORE = register(Names.Blocks.TIN_ORE, new TinOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.METAL)));
    public static final Block LEAD_ORE = register(Names.Blocks.LEAD_ORE, new LeadOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f, 15.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.METAL)));
    public static final Block SILVER_ORE = register(Names.Blocks.SILVER_ORE, new SilverOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f, 15.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL)));
    public static final Block TUNGSTEN_ORE = register(Names.Blocks.TUNGSTEN_ORE, new TungstenOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f, 15.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL)));
    public static final Block PLATINUM_ORE = register(Names.Blocks.PLATINUM_ORE, new PlatinumOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f, 15.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL)));
    public static final Block DEMONITE_ORE = register(Names.Blocks.DEMONITE_ORE, new DemoniteOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f, 25.0f).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
    public static final Block CRIMTANE_ORE = register(Names.Blocks.CRIMTANE_ORE, new CrimtaneOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f, 25.0f).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
    public static final Block METEORITE_ORE = register(Names.Blocks.METEORITE_ORE, new MeteoriteOre(Block.Properties.create(METAL).hardnessAndResistance(3.0f, 25.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.METAL)));
    public static final Block HELLSTONE_ORE = register(Names.Blocks.HELLSTONE_ORE, new HellstoneOre(Block.Properties.create(METAL).hardnessAndResistance(25.0f, 1200.0f).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.METAL)));

    private static Block register(String name, Block block)
    {
        return register(name, block, new Item.Properties().group(Terracraft.GROUP));
    }

    private static Block register(String name, Block block, Item.Properties properties)
    {
        return register(name, block, new BlockItem(block, properties));
    }

    private static Block register(String name, Block block, BlockItem item)
    {
        return register(name, block, block1 -> item);
    }

    private static Block register(String name, Block block, Function<Block, BlockItem> function)
    {
        block.setRegistryName(name);
        BLOCKS.add(block);
        if(block.getRegistryName() != null)
        {
            Item item = function.apply(block);
            if(item != null)
            {
                item.setRegistryName(name);
                ITEMS.add(item);
            }
        }
        return block;
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        BLOCKS.forEach(block -> event.getRegistry().register(block));
        BLOCKS.clear();
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        ITEMS.forEach(item -> event.getRegistry().register(item));
        ITEMS.clear();
    }
}