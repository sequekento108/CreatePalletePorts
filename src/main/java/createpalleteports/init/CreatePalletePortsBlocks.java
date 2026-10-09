package createpalleteports.init;

import createpalleteports.CreatePalletePorts;
import createpalleteports.block.PavedPaletteBlock;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreatePalletePortsBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CreatePalletePorts.MODID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(CreatePalletePorts.MODID);

    // Base properties mirror Create's gabbro (initialProperties copied from andesite).
    private static BlockBehaviour.Properties stoneProps() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops()
                .strength(1.5F, 6.0F);
    }

    private static <T extends Block> DeferredItem<Item> blockItem(DeferredBlock<T> block) {
        return ITEMS.register(block.getId().getPath(),
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static DeferredBlock<Block> stairsOf(DeferredBlock<Block> parent, String name) {
        return BLOCKS.register(name,
                () -> new StairBlock(parent.get().defaultBlockState(),
                        BlockBehaviour.Properties.ofFullCopy(parent.get())));
    }

    private static DeferredBlock<Block> slabOf(DeferredBlock<Block> parent, String name) {
        return BLOCKS.register(name,
                () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(parent.get())));
    }

    private static DeferredBlock<Block> wallOf(DeferredBlock<Block> parent, String name) {
        return BLOCKS.register(name,
                () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(parent.get())));
    }

    public static final DeferredBlock<Block> GABBRO =
            BLOCKS.register("gabbro", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> GABBRO_COBBLESTONE =
            BLOCKS.register("gabbro_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> POLISHED_GABBRO =
            BLOCKS.register("polished_gabbro", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> GABBRO_BRICKS =
            BLOCKS.register("gabbro_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_GABBRO_BRICKS =
            BLOCKS.register("fancy_gabbro_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> GABBRO_PILLAR =
            BLOCKS.register("gabbro_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_GABBRO =
            BLOCKS.register("paved_gabbro", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_GABBRO =
            BLOCKS.register("layered_gabbro", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> CHISELED_GABBRO =
            BLOCKS.register("chiseled_gabbro", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_GABBRO =
            BLOCKS.register("mossy_gabbro", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_GABBRO =
            BLOCKS.register("overgrown_gabbro", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> GABBRO_COBBLESTONE_STAIRS =
            stairsOf(GABBRO_COBBLESTONE, "gabbro_cobblestone_stairs");
    public static final DeferredBlock<Block> GABBRO_COBBLESTONE_SLAB =
            slabOf(GABBRO_COBBLESTONE, "gabbro_cobblestone_slab");
    public static final DeferredBlock<Block> GABBRO_COBBLESTONE_WALL =
            wallOf(GABBRO_COBBLESTONE, "gabbro_cobblestone_wall");

    public static final DeferredBlock<Block> POLISHED_GABBRO_STAIRS =
            stairsOf(POLISHED_GABBRO, "polished_gabbro_stairs");
    public static final DeferredBlock<Block> POLISHED_GABBRO_SLAB =
            slabOf(POLISHED_GABBRO, "polished_gabbro_slab");
    public static final DeferredBlock<Block> POLISHED_GABBRO_WALL =
            wallOf(POLISHED_GABBRO, "polished_gabbro_wall");


    public static final DeferredBlock<Block> GABBRO_BRICKS_STAIRS =
            stairsOf(GABBRO_BRICKS, "gabbro_bricks_stairs");
    public static final DeferredBlock<Block> GABBRO_BRICKS_SLAB =
            slabOf(GABBRO_BRICKS, "gabbro_bricks_slab");
    public static final DeferredBlock<Block> GABBRO_BRICKS_WALL =
            wallOf(GABBRO_BRICKS, "gabbro_bricks_wall");

    public static final DeferredBlock<Block> FANCY_GABBRO_BRICKS_STAIRS =
            stairsOf(FANCY_GABBRO_BRICKS, "fancy_gabbro_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_GABBRO_BRICKS_SLAB =
            slabOf(FANCY_GABBRO_BRICKS, "fancy_gabbro_bricks_slab");
    public static final DeferredBlock<Block> FANCY_GABBRO_BRICKS_WALL =
            wallOf(FANCY_GABBRO_BRICKS, "fancy_gabbro_bricks_wall");

    // ---- Partials: paved pattern (gabbro) ----

    public static final DeferredBlock<Block> PAVED_GABBRO_STAIRS =
            stairsOf(PAVED_GABBRO, "paved_gabbro_stairs");
    public static final DeferredBlock<Block> PAVED_GABBRO_SLAB =
            slabOf(PAVED_GABBRO, "paved_gabbro_slab");
    public static final DeferredBlock<Block> PAVED_GABBRO_WALL =
            wallOf(PAVED_GABBRO, "paved_gabbro_wall");

    public static final DeferredBlock<Block> DOLOMITE =
            BLOCKS.register("dolomite", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> DOLOMITE_COBBLESTONE =
            BLOCKS.register("dolomite_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> POLISHED_DOLOMITE =
            BLOCKS.register("polished_dolomite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> DOLOMITE_BRICKS =
            BLOCKS.register("dolomite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_DOLOMITE_BRICKS =
            BLOCKS.register("fancy_dolomite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> DOLOMITE_PILLAR =
            BLOCKS.register("dolomite_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_DOLOMITE =
            BLOCKS.register("paved_dolomite", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_DOLOMITE =
            BLOCKS.register("layered_dolomite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> CHISELED_DOLOMITE =
            BLOCKS.register("chiseled_dolomite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_DOLOMITE =
            BLOCKS.register("mossy_dolomite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_DOLOMITE =
            BLOCKS.register("overgrown_dolomite", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> DOLOMITE_COBBLESTONE_STAIRS =
            stairsOf(DOLOMITE_COBBLESTONE, "dolomite_cobblestone_stairs");
    public static final DeferredBlock<Block> DOLOMITE_COBBLESTONE_SLAB =
            slabOf(DOLOMITE_COBBLESTONE, "dolomite_cobblestone_slab");
    public static final DeferredBlock<Block> DOLOMITE_COBBLESTONE_WALL =
            wallOf(DOLOMITE_COBBLESTONE, "dolomite_cobblestone_wall");

    public static final DeferredBlock<Block> POLISHED_DOLOMITE_STAIRS =
            stairsOf(POLISHED_DOLOMITE, "polished_dolomite_stairs");
    public static final DeferredBlock<Block> POLISHED_DOLOMITE_SLAB =
            slabOf(POLISHED_DOLOMITE, "polished_dolomite_slab");
    public static final DeferredBlock<Block> POLISHED_DOLOMITE_WALL =
            wallOf(POLISHED_DOLOMITE, "polished_dolomite_wall");

    public static final DeferredBlock<Block> DOLOMITE_BRICKS_STAIRS =
            stairsOf(DOLOMITE_BRICKS, "dolomite_bricks_stairs");
    public static final DeferredBlock<Block> DOLOMITE_BRICKS_SLAB =
            slabOf(DOLOMITE_BRICKS, "dolomite_bricks_slab");
    public static final DeferredBlock<Block> DOLOMITE_BRICKS_WALL =
            wallOf(DOLOMITE_BRICKS, "dolomite_bricks_wall");

    public static final DeferredBlock<Block> FANCY_DOLOMITE_BRICKS_STAIRS =
            stairsOf(FANCY_DOLOMITE_BRICKS, "fancy_dolomite_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_DOLOMITE_BRICKS_SLAB =
            slabOf(FANCY_DOLOMITE_BRICKS, "fancy_dolomite_bricks_slab");
    public static final DeferredBlock<Block> FANCY_DOLOMITE_BRICKS_WALL =
            wallOf(FANCY_DOLOMITE_BRICKS, "fancy_dolomite_bricks_wall");

    public static final DeferredBlock<Block> PAVED_DOLOMITE_STAIRS =
            stairsOf(PAVED_DOLOMITE, "paved_dolomite_stairs");
    public static final DeferredBlock<Block> PAVED_DOLOMITE_SLAB =
            slabOf(PAVED_DOLOMITE, "paved_dolomite_slab");
    public static final DeferredBlock<Block> PAVED_DOLOMITE_WALL =
            wallOf(PAVED_DOLOMITE, "paved_dolomite_wall");

    public static final DeferredBlock<Block> NATURAL_SCORIA =
            BLOCKS.register("natural_scoria", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> SCORIA =
            BLOCKS.register("scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> SCORIA_COBBLESTONE =
            BLOCKS.register("scoria_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> POLISHED_SCORIA =
            BLOCKS.register("polished_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> SCORIA_BRICKS =
            BLOCKS.register("scoria_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_SCORIA_BRICKS =
            BLOCKS.register("fancy_scoria_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> SCORIA_PILLAR =
            BLOCKS.register("scoria_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_SCORIA =
            BLOCKS.register("paved_scoria", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_SCORIA =
            BLOCKS.register("layered_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> CHISELED_SCORIA =
            BLOCKS.register("chiseled_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_SCORIA =
            BLOCKS.register("mossy_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_SCORIA =
            BLOCKS.register("overgrown_scoria", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> SCORIA_COBBLESTONE_STAIRS =
            stairsOf(SCORIA_COBBLESTONE, "scoria_cobblestone_stairs");
    public static final DeferredBlock<Block> SCORIA_COBBLESTONE_SLAB =
            slabOf(SCORIA_COBBLESTONE, "scoria_cobblestone_slab");
    public static final DeferredBlock<Block> SCORIA_COBBLESTONE_WALL =
            wallOf(SCORIA_COBBLESTONE, "scoria_cobblestone_wall");

    public static final DeferredBlock<Block> POLISHED_SCORIA_STAIRS =
            stairsOf(POLISHED_SCORIA, "polished_scoria_stairs");
    public static final DeferredBlock<Block> POLISHED_SCORIA_SLAB =
            slabOf(POLISHED_SCORIA, "polished_scoria_slab");
    public static final DeferredBlock<Block> POLISHED_SCORIA_WALL =
            wallOf(POLISHED_SCORIA, "polished_scoria_wall");

    public static final DeferredBlock<Block> SCORIA_BRICKS_STAIRS =
            stairsOf(SCORIA_BRICKS, "scoria_bricks_stairs");
    public static final DeferredBlock<Block> SCORIA_BRICKS_SLAB =
            slabOf(SCORIA_BRICKS, "scoria_bricks_slab");
    public static final DeferredBlock<Block> SCORIA_BRICKS_WALL =
            wallOf(SCORIA_BRICKS, "scoria_bricks_wall");

    public static final DeferredBlock<Block> FANCY_SCORIA_BRICKS_STAIRS =
            stairsOf(FANCY_SCORIA_BRICKS, "fancy_scoria_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_SCORIA_BRICKS_SLAB =
            slabOf(FANCY_SCORIA_BRICKS, "fancy_scoria_bricks_slab");
    public static final DeferredBlock<Block> FANCY_SCORIA_BRICKS_WALL =
            wallOf(FANCY_SCORIA_BRICKS, "fancy_scoria_bricks_wall");

    public static final DeferredBlock<Block> PAVED_SCORIA_STAIRS =
            stairsOf(PAVED_SCORIA, "paved_scoria_stairs");
    public static final DeferredBlock<Block> PAVED_SCORIA_SLAB =
            slabOf(PAVED_SCORIA, "paved_scoria_slab");
    public static final DeferredBlock<Block> PAVED_SCORIA_WALL =
            wallOf(PAVED_SCORIA, "paved_scoria_wall");

    public static final DeferredBlock<Block> DARK_SCORIA =
            BLOCKS.register("dark_scoria", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> DARK_SCORIA_COBBLESTONE =
            BLOCKS.register("dark_scoria_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> POLISHED_DARK_SCORIA =
            BLOCKS.register("polished_dark_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> DARK_SCORIA_BRICKS =
            BLOCKS.register("dark_scoria_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_DARK_SCORIA_BRICKS =
            BLOCKS.register("fancy_dark_scoria_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> DARK_SCORIA_PILLAR =
            BLOCKS.register("dark_scoria_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_DARK_SCORIA =
            BLOCKS.register("paved_dark_scoria", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_DARK_SCORIA =
            BLOCKS.register("layered_dark_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> CHISELED_DARK_SCORIA =
            BLOCKS.register("chiseled_dark_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_DARK_SCORIA =
            BLOCKS.register("mossy_dark_scoria", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_DARK_SCORIA =
            BLOCKS.register("overgrown_dark_scoria", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> DARK_SCORIA_COBBLESTONE_STAIRS =
            stairsOf(DARK_SCORIA_COBBLESTONE, "dark_scoria_cobblestone_stairs");
    public static final DeferredBlock<Block> DARK_SCORIA_COBBLESTONE_SLAB =
            slabOf(DARK_SCORIA_COBBLESTONE, "dark_scoria_cobblestone_slab");
    public static final DeferredBlock<Block> DARK_SCORIA_COBBLESTONE_WALL =
            wallOf(DARK_SCORIA_COBBLESTONE, "dark_scoria_cobblestone_wall");

    public static final DeferredBlock<Block> POLISHED_DARK_SCORIA_STAIRS =
            stairsOf(POLISHED_DARK_SCORIA, "polished_dark_scoria_stairs");
    public static final DeferredBlock<Block> POLISHED_DARK_SCORIA_SLAB =
            slabOf(POLISHED_DARK_SCORIA, "polished_dark_scoria_slab");
    public static final DeferredBlock<Block> POLISHED_DARK_SCORIA_WALL =
            wallOf(POLISHED_DARK_SCORIA, "polished_dark_scoria_wall");

    public static final DeferredBlock<Block> DARK_SCORIA_BRICKS_STAIRS =
            stairsOf(DARK_SCORIA_BRICKS, "dark_scoria_bricks_stairs");
    public static final DeferredBlock<Block> DARK_SCORIA_BRICKS_SLAB =
            slabOf(DARK_SCORIA_BRICKS, "dark_scoria_bricks_slab");
    public static final DeferredBlock<Block> DARK_SCORIA_BRICKS_WALL =
            wallOf(DARK_SCORIA_BRICKS, "dark_scoria_bricks_wall");

    public static final DeferredBlock<Block> FANCY_DARK_SCORIA_BRICKS_STAIRS =
            stairsOf(FANCY_DARK_SCORIA_BRICKS, "fancy_dark_scoria_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_DARK_SCORIA_BRICKS_SLAB =
            slabOf(FANCY_DARK_SCORIA_BRICKS, "fancy_dark_scoria_bricks_slab");
    public static final DeferredBlock<Block> FANCY_DARK_SCORIA_BRICKS_WALL =
            wallOf(FANCY_DARK_SCORIA_BRICKS, "fancy_dark_scoria_bricks_wall");

    public static final DeferredBlock<Block> PAVED_DARK_SCORIA_STAIRS =
            stairsOf(PAVED_DARK_SCORIA, "paved_dark_scoria_stairs");
    public static final DeferredBlock<Block> PAVED_DARK_SCORIA_SLAB =
            slabOf(PAVED_DARK_SCORIA, "paved_dark_scoria_slab");
    public static final DeferredBlock<Block> PAVED_DARK_SCORIA_WALL =
            wallOf(PAVED_DARK_SCORIA, "paved_dark_scoria_wall");
    public static final DeferredBlock<Block> LIMESAND =
            BLOCKS.register("limesand", () -> new ColoredFallingBlock(new ColorRGBA(0xD7D7C7),
                    BlockBehaviour.Properties.of().mapColor(MapColor.SAND)
                            .sound(SoundType.SAND).strength(0.5F)));
    public static final DeferredBlock<Block> LIMESTONE =
            BLOCKS.register("limestone", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> LIMESTONE_COBBLESTONE =
            BLOCKS.register("limestone_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE =
            BLOCKS.register("polished_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> LIMESTONE_BRICKS =
            BLOCKS.register("limestone_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_LIMESTONE_BRICKS =
            BLOCKS.register("fancy_limestone_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> LIMESTONE_PILLAR =
            BLOCKS.register("limestone_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_LIMESTONE =
            BLOCKS.register("paved_limestone", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_LIMESTONE =
            BLOCKS.register("layered_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> CHISELED_LIMESTONE =
            BLOCKS.register("chiseled_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_LIMESTONE =
            BLOCKS.register("mossy_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_LIMESTONE =
            BLOCKS.register("overgrown_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> LIMESTONE_COBBLESTONE_STAIRS =
            stairsOf(LIMESTONE_COBBLESTONE, "limestone_cobblestone_stairs");
    public static final DeferredBlock<Block> LIMESTONE_COBBLESTONE_SLAB =
            slabOf(LIMESTONE_COBBLESTONE, "limestone_cobblestone_slab");
    public static final DeferredBlock<Block> LIMESTONE_COBBLESTONE_WALL =
            wallOf(LIMESTONE_COBBLESTONE, "limestone_cobblestone_wall");
    public static final DeferredBlock<Block> POLISHED_LIMESTONE_STAIRS =
            stairsOf(POLISHED_LIMESTONE, "polished_limestone_stairs");
    public static final DeferredBlock<Block> POLISHED_LIMESTONE_SLAB =
            slabOf(POLISHED_LIMESTONE, "polished_limestone_slab");
    public static final DeferredBlock<Block> POLISHED_LIMESTONE_WALL =
            wallOf(POLISHED_LIMESTONE, "polished_limestone_wall");
    public static final DeferredBlock<Block> LIMESTONE_BRICKS_STAIRS =
            stairsOf(LIMESTONE_BRICKS, "limestone_bricks_stairs");
    public static final DeferredBlock<Block> LIMESTONE_BRICKS_SLAB =
            slabOf(LIMESTONE_BRICKS, "limestone_bricks_slab");
    public static final DeferredBlock<Block> LIMESTONE_BRICKS_WALL =
            wallOf(LIMESTONE_BRICKS, "limestone_bricks_wall");
    public static final DeferredBlock<Block> FANCY_LIMESTONE_BRICKS_STAIRS =
            stairsOf(FANCY_LIMESTONE_BRICKS, "fancy_limestone_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_LIMESTONE_BRICKS_SLAB =
            slabOf(FANCY_LIMESTONE_BRICKS, "fancy_limestone_bricks_slab");
    public static final DeferredBlock<Block> FANCY_LIMESTONE_BRICKS_WALL =
            wallOf(FANCY_LIMESTONE_BRICKS, "fancy_limestone_bricks_wall");

    public static final DeferredBlock<Block> PAVED_LIMESTONE_STAIRS =
            stairsOf(PAVED_LIMESTONE, "paved_limestone_stairs");
    public static final DeferredBlock<Block> PAVED_LIMESTONE_SLAB =
            slabOf(PAVED_LIMESTONE, "paved_limestone_slab");
    public static final DeferredBlock<Block> PAVED_LIMESTONE_WALL =
            wallOf(PAVED_LIMESTONE, "paved_limestone_wall");
    public static final DeferredBlock<Block> WEATHERED_LIMESTONE =
            BLOCKS.register("weathered_limestone", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_COBBLESTONE =
            BLOCKS.register("weathered_limestone_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> POLISHED_WEATHERED_LIMESTONE =
            BLOCKS.register("polished_weathered_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_BRICKS =
            BLOCKS.register("weathered_limestone_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_WEATHERED_LIMESTONE_BRICKS =
            BLOCKS.register("fancy_weathered_limestone_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_PILLAR =
            BLOCKS.register("weathered_limestone_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_WEATHERED_LIMESTONE =
            BLOCKS.register("paved_weathered_limestone", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_WEATHERED_LIMESTONE =
            BLOCKS.register("layered_weathered_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> CHISELED_WEATHERED_LIMESTONE =
            BLOCKS.register("chiseled_weathered_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_WEATHERED_LIMESTONE =
            BLOCKS.register("mossy_weathered_limestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_WEATHERED_LIMESTONE =
            BLOCKS.register("overgrown_weathered_limestone", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_COBBLESTONE_STAIRS =
            stairsOf(WEATHERED_LIMESTONE_COBBLESTONE, "weathered_limestone_cobblestone_stairs");
    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_COBBLESTONE_SLAB =
            slabOf(WEATHERED_LIMESTONE_COBBLESTONE, "weathered_limestone_cobblestone_slab");
    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_COBBLESTONE_WALL =
            wallOf(WEATHERED_LIMESTONE_COBBLESTONE, "weathered_limestone_cobblestone_wall");

    public static final DeferredBlock<Block> POLISHED_WEATHERED_LIMESTONE_STAIRS =
            stairsOf(POLISHED_WEATHERED_LIMESTONE, "polished_weathered_limestone_stairs");
    public static final DeferredBlock<Block> POLISHED_WEATHERED_LIMESTONE_SLAB =
            slabOf(POLISHED_WEATHERED_LIMESTONE, "polished_weathered_limestone_slab");
    public static final DeferredBlock<Block> POLISHED_WEATHERED_LIMESTONE_WALL =
            wallOf(POLISHED_WEATHERED_LIMESTONE, "polished_weathered_limestone_wall");

    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_BRICKS_STAIRS =
            stairsOf(WEATHERED_LIMESTONE_BRICKS, "weathered_limestone_bricks_stairs");
    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_BRICKS_SLAB =
            slabOf(WEATHERED_LIMESTONE_BRICKS, "weathered_limestone_bricks_slab");
    public static final DeferredBlock<Block> WEATHERED_LIMESTONE_BRICKS_WALL =
            wallOf(WEATHERED_LIMESTONE_BRICKS, "weathered_limestone_bricks_wall");

    public static final DeferredBlock<Block> FANCY_WEATHERED_LIMESTONE_BRICKS_STAIRS =
            stairsOf(FANCY_WEATHERED_LIMESTONE_BRICKS, "fancy_weathered_limestone_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_WEATHERED_LIMESTONE_BRICKS_SLAB =
            slabOf(FANCY_WEATHERED_LIMESTONE_BRICKS, "fancy_weathered_limestone_bricks_slab");
    public static final DeferredBlock<Block> FANCY_WEATHERED_LIMESTONE_BRICKS_WALL =
            wallOf(FANCY_WEATHERED_LIMESTONE_BRICKS, "fancy_weathered_limestone_bricks_wall");

    public static final DeferredBlock<Block> PAVED_WEATHERED_LIMESTONE_STAIRS =
            stairsOf(PAVED_WEATHERED_LIMESTONE, "paved_weathered_limestone_stairs");
    public static final DeferredBlock<Block> PAVED_WEATHERED_LIMESTONE_SLAB =
            slabOf(PAVED_WEATHERED_LIMESTONE, "paved_weathered_limestone_slab");
    public static final DeferredBlock<Block> PAVED_WEATHERED_LIMESTONE_WALL =
            wallOf(PAVED_WEATHERED_LIMESTONE, "paved_weathered_limestone_wall");

    public static final DeferredBlock<Block> GRANITE_COBBLESTONE =
            BLOCKS.register("granite_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> GRANITE_BRICKS =
            BLOCKS.register("granite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_GRANITE_BRICKS =
            BLOCKS.register("fancy_granite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> GRANITE_PILLAR =
            BLOCKS.register("granite_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_GRANITE =
            BLOCKS.register("paved_granite", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_GRANITE =
            BLOCKS.register("layered_granite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_GRANITE =
            BLOCKS.register("mossy_granite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_GRANITE =
            BLOCKS.register("overgrown_granite", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> GRANITE_COBBLESTONE_STAIRS =
            stairsOf(GRANITE_COBBLESTONE, "granite_cobblestone_stairs");
    public static final DeferredBlock<Block> GRANITE_COBBLESTONE_SLAB =
            slabOf(GRANITE_COBBLESTONE, "granite_cobblestone_slab");
    public static final DeferredBlock<Block> GRANITE_COBBLESTONE_WALL =
            wallOf(GRANITE_COBBLESTONE, "granite_cobblestone_wall");

    public static final DeferredBlock<Block> GRANITE_BRICKS_STAIRS =
            stairsOf(GRANITE_BRICKS, "granite_bricks_stairs");
    public static final DeferredBlock<Block> GRANITE_BRICKS_SLAB =
            slabOf(GRANITE_BRICKS, "granite_bricks_slab");
    public static final DeferredBlock<Block> GRANITE_BRICKS_WALL =
            wallOf(GRANITE_BRICKS, "granite_bricks_wall");

    public static final DeferredBlock<Block> FANCY_GRANITE_BRICKS_STAIRS =
            stairsOf(FANCY_GRANITE_BRICKS, "fancy_granite_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_GRANITE_BRICKS_SLAB =
            slabOf(FANCY_GRANITE_BRICKS, "fancy_granite_bricks_slab");
    public static final DeferredBlock<Block> FANCY_GRANITE_BRICKS_WALL =
            wallOf(FANCY_GRANITE_BRICKS, "fancy_granite_bricks_wall");

    public static final DeferredBlock<Block> PAVED_GRANITE_STAIRS =
            stairsOf(PAVED_GRANITE, "paved_granite_stairs");
    public static final DeferredBlock<Block> PAVED_GRANITE_SLAB =
            slabOf(PAVED_GRANITE, "paved_granite_slab");
    public static final DeferredBlock<Block> PAVED_GRANITE_WALL =
            wallOf(PAVED_GRANITE, "paved_granite_wall");

    public static final DeferredBlock<Block> DIORITE_COBBLESTONE =
            BLOCKS.register("diorite_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> DIORITE_BRICKS =
            BLOCKS.register("diorite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_DIORITE_BRICKS =
            BLOCKS.register("fancy_diorite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> DIORITE_PILLAR =
            BLOCKS.register("diorite_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_DIORITE =
            BLOCKS.register("paved_diorite", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_DIORITE =
            BLOCKS.register("layered_diorite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_DIORITE =
            BLOCKS.register("mossy_diorite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_DIORITE =
            BLOCKS.register("overgrown_diorite", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> DIORITE_COBBLESTONE_STAIRS =
            stairsOf(DIORITE_COBBLESTONE, "diorite_cobblestone_stairs");
    public static final DeferredBlock<Block> DIORITE_COBBLESTONE_SLAB =
            slabOf(DIORITE_COBBLESTONE, "diorite_cobblestone_slab");
    public static final DeferredBlock<Block> DIORITE_COBBLESTONE_WALL =
            wallOf(DIORITE_COBBLESTONE, "diorite_cobblestone_wall");

    public static final DeferredBlock<Block> DIORITE_BRICKS_STAIRS =
            stairsOf(DIORITE_BRICKS, "diorite_bricks_stairs");
    public static final DeferredBlock<Block> DIORITE_BRICKS_SLAB =
            slabOf(DIORITE_BRICKS, "diorite_bricks_slab");
    public static final DeferredBlock<Block> DIORITE_BRICKS_WALL =
            wallOf(DIORITE_BRICKS, "diorite_bricks_wall");

    public static final DeferredBlock<Block> FANCY_DIORITE_BRICKS_STAIRS =
            stairsOf(FANCY_DIORITE_BRICKS, "fancy_diorite_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_DIORITE_BRICKS_SLAB =
            slabOf(FANCY_DIORITE_BRICKS, "fancy_diorite_bricks_slab");
    public static final DeferredBlock<Block> FANCY_DIORITE_BRICKS_WALL =
            wallOf(FANCY_DIORITE_BRICKS, "fancy_diorite_bricks_wall");

    public static final DeferredBlock<Block> PAVED_DIORITE_STAIRS =
            stairsOf(PAVED_DIORITE, "paved_diorite_stairs");
    public static final DeferredBlock<Block> PAVED_DIORITE_SLAB =
            slabOf(PAVED_DIORITE, "paved_diorite_slab");
    public static final DeferredBlock<Block> PAVED_DIORITE_WALL =
            wallOf(PAVED_DIORITE, "paved_diorite_wall");

    public static final DeferredBlock<Block> ANDESITE_COBBLESTONE =
            BLOCKS.register("andesite_cobblestone", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> ANDESITE_BRICKS =
            BLOCKS.register("andesite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> FANCY_ANDESITE_BRICKS =
            BLOCKS.register("fancy_andesite_bricks", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> ANDESITE_PILLAR =
            BLOCKS.register("andesite_pillar", () -> new RotatedPillarBlock(stoneProps()));
    public static final DeferredBlock<Block> PAVED_ANDESITE =
            BLOCKS.register("paved_andesite", () -> new PavedPaletteBlock(stoneProps()));
    public static final DeferredBlock<Block> LAYERED_ANDESITE =
            BLOCKS.register("layered_andesite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> MOSSY_ANDESITE =
            BLOCKS.register("mossy_andesite", () -> new Block(stoneProps()));
    public static final DeferredBlock<Block> OVERGROWN_ANDESITE =
            BLOCKS.register("overgrown_andesite", () -> new Block(stoneProps()));

    public static final DeferredBlock<Block> ANDESITE_COBBLESTONE_STAIRS =
            stairsOf(ANDESITE_COBBLESTONE, "andesite_cobblestone_stairs");
    public static final DeferredBlock<Block> ANDESITE_COBBLESTONE_SLAB =
            slabOf(ANDESITE_COBBLESTONE, "andesite_cobblestone_slab");
    public static final DeferredBlock<Block> ANDESITE_COBBLESTONE_WALL =
            wallOf(ANDESITE_COBBLESTONE, "andesite_cobblestone_wall");

    public static final DeferredBlock<Block> ANDESITE_BRICKS_STAIRS =
            stairsOf(ANDESITE_BRICKS, "andesite_bricks_stairs");
    public static final DeferredBlock<Block> ANDESITE_BRICKS_SLAB =
            slabOf(ANDESITE_BRICKS, "andesite_bricks_slab");
    public static final DeferredBlock<Block> ANDESITE_BRICKS_WALL =
            wallOf(ANDESITE_BRICKS, "andesite_bricks_wall");

    public static final DeferredBlock<Block> FANCY_ANDESITE_BRICKS_STAIRS =
            stairsOf(FANCY_ANDESITE_BRICKS, "fancy_andesite_bricks_stairs");
    public static final DeferredBlock<Block> FANCY_ANDESITE_BRICKS_SLAB =
            slabOf(FANCY_ANDESITE_BRICKS, "fancy_andesite_bricks_slab");
    public static final DeferredBlock<Block> FANCY_ANDESITE_BRICKS_WALL =
            wallOf(FANCY_ANDESITE_BRICKS, "fancy_andesite_bricks_wall");

    public static final DeferredBlock<Block> PAVED_ANDESITE_STAIRS =
            stairsOf(PAVED_ANDESITE, "paved_andesite_stairs");
    public static final DeferredBlock<Block> PAVED_ANDESITE_SLAB =
            slabOf(PAVED_ANDESITE, "paved_andesite_slab");
    public static final DeferredBlock<Block> PAVED_ANDESITE_WALL =
            wallOf(PAVED_ANDESITE, "paved_andesite_wall");

    public static final DeferredItem<Item> GABBRO_ITEM = blockItem(GABBRO);
    public static final DeferredItem<Item> GABBRO_COBBLESTONE_ITEM = blockItem(GABBRO_COBBLESTONE);
    public static final DeferredItem<Item> POLISHED_GABBRO_ITEM = blockItem(POLISHED_GABBRO);
    public static final DeferredItem<Item> GABBRO_BRICKS_ITEM = blockItem(GABBRO_BRICKS);
    public static final DeferredItem<Item> FANCY_GABBRO_BRICKS_ITEM = blockItem(FANCY_GABBRO_BRICKS);
    public static final DeferredItem<Item> GABBRO_PILLAR_ITEM = blockItem(GABBRO_PILLAR);
    public static final DeferredItem<Item> PAVED_GABBRO_ITEM = blockItem(PAVED_GABBRO);
    public static final DeferredItem<Item> LAYERED_GABBRO_ITEM = blockItem(LAYERED_GABBRO);
    public static final DeferredItem<Item> CHISELED_GABBRO_ITEM = blockItem(CHISELED_GABBRO);
    public static final DeferredItem<Item> MOSSY_GABBRO_ITEM = blockItem(MOSSY_GABBRO);
    public static final DeferredItem<Item> OVERGROWN_GABBRO_ITEM = blockItem(OVERGROWN_GABBRO);

    public static final DeferredItem<Item> GABBRO_COBBLESTONE_STAIRS_ITEM = blockItem(GABBRO_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> GABBRO_COBBLESTONE_SLAB_ITEM = blockItem(GABBRO_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> GABBRO_COBBLESTONE_WALL_ITEM = blockItem(GABBRO_COBBLESTONE_WALL);
    public static final DeferredItem<Item> POLISHED_GABBRO_STAIRS_ITEM = blockItem(POLISHED_GABBRO_STAIRS);
    public static final DeferredItem<Item> POLISHED_GABBRO_SLAB_ITEM = blockItem(POLISHED_GABBRO_SLAB);
    public static final DeferredItem<Item> POLISHED_GABBRO_WALL_ITEM = blockItem(POLISHED_GABBRO_WALL);
    public static final DeferredItem<Item> GABBRO_BRICKS_STAIRS_ITEM = blockItem(GABBRO_BRICKS_STAIRS);
    public static final DeferredItem<Item> GABBRO_BRICKS_SLAB_ITEM = blockItem(GABBRO_BRICKS_SLAB);
    public static final DeferredItem<Item> GABBRO_BRICKS_WALL_ITEM = blockItem(GABBRO_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_GABBRO_BRICKS_STAIRS_ITEM = blockItem(FANCY_GABBRO_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_GABBRO_BRICKS_SLAB_ITEM = blockItem(FANCY_GABBRO_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_GABBRO_BRICKS_WALL_ITEM = blockItem(FANCY_GABBRO_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_GABBRO_STAIRS_ITEM = blockItem(PAVED_GABBRO_STAIRS);
    public static final DeferredItem<Item> PAVED_GABBRO_SLAB_ITEM = blockItem(PAVED_GABBRO_SLAB);
    public static final DeferredItem<Item> PAVED_GABBRO_WALL_ITEM = blockItem(PAVED_GABBRO_WALL);

    public static final DeferredItem<Item> DOLOMITE_ITEM = blockItem(DOLOMITE);
    public static final DeferredItem<Item> DOLOMITE_COBBLESTONE_ITEM = blockItem(DOLOMITE_COBBLESTONE);
    public static final DeferredItem<Item> POLISHED_DOLOMITE_ITEM = blockItem(POLISHED_DOLOMITE);
    public static final DeferredItem<Item> DOLOMITE_BRICKS_ITEM = blockItem(DOLOMITE_BRICKS);
    public static final DeferredItem<Item> FANCY_DOLOMITE_BRICKS_ITEM = blockItem(FANCY_DOLOMITE_BRICKS);
    public static final DeferredItem<Item> DOLOMITE_PILLAR_ITEM = blockItem(DOLOMITE_PILLAR);
    public static final DeferredItem<Item> PAVED_DOLOMITE_ITEM = blockItem(PAVED_DOLOMITE);
    public static final DeferredItem<Item> LAYERED_DOLOMITE_ITEM = blockItem(LAYERED_DOLOMITE);
    public static final DeferredItem<Item> CHISELED_DOLOMITE_ITEM = blockItem(CHISELED_DOLOMITE);
    public static final DeferredItem<Item> MOSSY_DOLOMITE_ITEM = blockItem(MOSSY_DOLOMITE);
    public static final DeferredItem<Item> OVERGROWN_DOLOMITE_ITEM = blockItem(OVERGROWN_DOLOMITE);

    public static final DeferredItem<Item> DOLOMITE_COBBLESTONE_STAIRS_ITEM = blockItem(DOLOMITE_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> DOLOMITE_COBBLESTONE_SLAB_ITEM = blockItem(DOLOMITE_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> DOLOMITE_COBBLESTONE_WALL_ITEM = blockItem(DOLOMITE_COBBLESTONE_WALL);
    public static final DeferredItem<Item> POLISHED_DOLOMITE_STAIRS_ITEM = blockItem(POLISHED_DOLOMITE_STAIRS);
    public static final DeferredItem<Item> POLISHED_DOLOMITE_SLAB_ITEM = blockItem(POLISHED_DOLOMITE_SLAB);
    public static final DeferredItem<Item> POLISHED_DOLOMITE_WALL_ITEM = blockItem(POLISHED_DOLOMITE_WALL);
    public static final DeferredItem<Item> DOLOMITE_BRICKS_STAIRS_ITEM = blockItem(DOLOMITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> DOLOMITE_BRICKS_SLAB_ITEM = blockItem(DOLOMITE_BRICKS_SLAB);
    public static final DeferredItem<Item> DOLOMITE_BRICKS_WALL_ITEM = blockItem(DOLOMITE_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_DOLOMITE_BRICKS_STAIRS_ITEM = blockItem(FANCY_DOLOMITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_DOLOMITE_BRICKS_SLAB_ITEM = blockItem(FANCY_DOLOMITE_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_DOLOMITE_BRICKS_WALL_ITEM = blockItem(FANCY_DOLOMITE_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_DOLOMITE_STAIRS_ITEM = blockItem(PAVED_DOLOMITE_STAIRS);
    public static final DeferredItem<Item> PAVED_DOLOMITE_SLAB_ITEM = blockItem(PAVED_DOLOMITE_SLAB);
    public static final DeferredItem<Item> PAVED_DOLOMITE_WALL_ITEM = blockItem(PAVED_DOLOMITE_WALL);

    public static final DeferredItem<Item> NATURAL_SCORIA_ITEM = blockItem(NATURAL_SCORIA);
    public static final DeferredItem<Item> SCORIA_ITEM = blockItem(SCORIA);
    public static final DeferredItem<Item> SCORIA_COBBLESTONE_ITEM = blockItem(SCORIA_COBBLESTONE);
    public static final DeferredItem<Item> POLISHED_SCORIA_ITEM = blockItem(POLISHED_SCORIA);
    public static final DeferredItem<Item> SCORIA_BRICKS_ITEM = blockItem(SCORIA_BRICKS);
    public static final DeferredItem<Item> FANCY_SCORIA_BRICKS_ITEM = blockItem(FANCY_SCORIA_BRICKS);
    public static final DeferredItem<Item> SCORIA_PILLAR_ITEM = blockItem(SCORIA_PILLAR);
    public static final DeferredItem<Item> PAVED_SCORIA_ITEM = blockItem(PAVED_SCORIA);
    public static final DeferredItem<Item> LAYERED_SCORIA_ITEM = blockItem(LAYERED_SCORIA);
    public static final DeferredItem<Item> CHISELED_SCORIA_ITEM = blockItem(CHISELED_SCORIA);
    public static final DeferredItem<Item> MOSSY_SCORIA_ITEM = blockItem(MOSSY_SCORIA);
    public static final DeferredItem<Item> OVERGROWN_SCORIA_ITEM = blockItem(OVERGROWN_SCORIA);

    public static final DeferredItem<Item> SCORIA_COBBLESTONE_STAIRS_ITEM = blockItem(SCORIA_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> SCORIA_COBBLESTONE_SLAB_ITEM = blockItem(SCORIA_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> SCORIA_COBBLESTONE_WALL_ITEM = blockItem(SCORIA_COBBLESTONE_WALL);
    public static final DeferredItem<Item> POLISHED_SCORIA_STAIRS_ITEM = blockItem(POLISHED_SCORIA_STAIRS);
    public static final DeferredItem<Item> POLISHED_SCORIA_SLAB_ITEM = blockItem(POLISHED_SCORIA_SLAB);
    public static final DeferredItem<Item> POLISHED_SCORIA_WALL_ITEM = blockItem(POLISHED_SCORIA_WALL);
    public static final DeferredItem<Item> SCORIA_BRICKS_STAIRS_ITEM = blockItem(SCORIA_BRICKS_STAIRS);
    public static final DeferredItem<Item> SCORIA_BRICKS_SLAB_ITEM = blockItem(SCORIA_BRICKS_SLAB);
    public static final DeferredItem<Item> SCORIA_BRICKS_WALL_ITEM = blockItem(SCORIA_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_SCORIA_BRICKS_STAIRS_ITEM = blockItem(FANCY_SCORIA_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_SCORIA_BRICKS_SLAB_ITEM = blockItem(FANCY_SCORIA_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_SCORIA_BRICKS_WALL_ITEM = blockItem(FANCY_SCORIA_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_SCORIA_STAIRS_ITEM = blockItem(PAVED_SCORIA_STAIRS);
    public static final DeferredItem<Item> PAVED_SCORIA_SLAB_ITEM = blockItem(PAVED_SCORIA_SLAB);
    public static final DeferredItem<Item> PAVED_SCORIA_WALL_ITEM = blockItem(PAVED_SCORIA_WALL);

    public static final DeferredItem<Item> DARK_SCORIA_ITEM = blockItem(DARK_SCORIA);
    public static final DeferredItem<Item> DARK_SCORIA_COBBLESTONE_ITEM = blockItem(DARK_SCORIA_COBBLESTONE);
    public static final DeferredItem<Item> POLISHED_DARK_SCORIA_ITEM = blockItem(POLISHED_DARK_SCORIA);
    public static final DeferredItem<Item> DARK_SCORIA_BRICKS_ITEM = blockItem(DARK_SCORIA_BRICKS);
    public static final DeferredItem<Item> FANCY_DARK_SCORIA_BRICKS_ITEM = blockItem(FANCY_DARK_SCORIA_BRICKS);
    public static final DeferredItem<Item> DARK_SCORIA_PILLAR_ITEM = blockItem(DARK_SCORIA_PILLAR);
    public static final DeferredItem<Item> PAVED_DARK_SCORIA_ITEM = blockItem(PAVED_DARK_SCORIA);
    public static final DeferredItem<Item> LAYERED_DARK_SCORIA_ITEM = blockItem(LAYERED_DARK_SCORIA);
    public static final DeferredItem<Item> CHISELED_DARK_SCORIA_ITEM = blockItem(CHISELED_DARK_SCORIA);
    public static final DeferredItem<Item> MOSSY_DARK_SCORIA_ITEM = blockItem(MOSSY_DARK_SCORIA);
    public static final DeferredItem<Item> OVERGROWN_DARK_SCORIA_ITEM = blockItem(OVERGROWN_DARK_SCORIA);

    public static final DeferredItem<Item> DARK_SCORIA_COBBLESTONE_STAIRS_ITEM = blockItem(DARK_SCORIA_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> DARK_SCORIA_COBBLESTONE_SLAB_ITEM = blockItem(DARK_SCORIA_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> DARK_SCORIA_COBBLESTONE_WALL_ITEM = blockItem(DARK_SCORIA_COBBLESTONE_WALL);
    public static final DeferredItem<Item> POLISHED_DARK_SCORIA_STAIRS_ITEM = blockItem(POLISHED_DARK_SCORIA_STAIRS);
    public static final DeferredItem<Item> POLISHED_DARK_SCORIA_SLAB_ITEM = blockItem(POLISHED_DARK_SCORIA_SLAB);
    public static final DeferredItem<Item> POLISHED_DARK_SCORIA_WALL_ITEM = blockItem(POLISHED_DARK_SCORIA_WALL);
    public static final DeferredItem<Item> DARK_SCORIA_BRICKS_STAIRS_ITEM = blockItem(DARK_SCORIA_BRICKS_STAIRS);
    public static final DeferredItem<Item> DARK_SCORIA_BRICKS_SLAB_ITEM = blockItem(DARK_SCORIA_BRICKS_SLAB);
    public static final DeferredItem<Item> DARK_SCORIA_BRICKS_WALL_ITEM = blockItem(DARK_SCORIA_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_DARK_SCORIA_BRICKS_STAIRS_ITEM = blockItem(FANCY_DARK_SCORIA_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_DARK_SCORIA_BRICKS_SLAB_ITEM = blockItem(FANCY_DARK_SCORIA_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_DARK_SCORIA_BRICKS_WALL_ITEM = blockItem(FANCY_DARK_SCORIA_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_DARK_SCORIA_STAIRS_ITEM = blockItem(PAVED_DARK_SCORIA_STAIRS);
    public static final DeferredItem<Item> PAVED_DARK_SCORIA_SLAB_ITEM = blockItem(PAVED_DARK_SCORIA_SLAB);
    public static final DeferredItem<Item> PAVED_DARK_SCORIA_WALL_ITEM = blockItem(PAVED_DARK_SCORIA_WALL);

    public static final DeferredItem<Item> LIMESAND_ITEM = blockItem(LIMESAND);
    public static final DeferredItem<Item> LIMESTONE_ITEM = blockItem(LIMESTONE);
    public static final DeferredItem<Item> LIMESTONE_COBBLESTONE_ITEM = blockItem(LIMESTONE_COBBLESTONE);
    public static final DeferredItem<Item> POLISHED_LIMESTONE_ITEM = blockItem(POLISHED_LIMESTONE);
    public static final DeferredItem<Item> LIMESTONE_BRICKS_ITEM = blockItem(LIMESTONE_BRICKS);
    public static final DeferredItem<Item> FANCY_LIMESTONE_BRICKS_ITEM = blockItem(FANCY_LIMESTONE_BRICKS);
    public static final DeferredItem<Item> LIMESTONE_PILLAR_ITEM = blockItem(LIMESTONE_PILLAR);
    public static final DeferredItem<Item> PAVED_LIMESTONE_ITEM = blockItem(PAVED_LIMESTONE);
    public static final DeferredItem<Item> LAYERED_LIMESTONE_ITEM = blockItem(LAYERED_LIMESTONE);
    public static final DeferredItem<Item> CHISELED_LIMESTONE_ITEM = blockItem(CHISELED_LIMESTONE);
    public static final DeferredItem<Item> MOSSY_LIMESTONE_ITEM = blockItem(MOSSY_LIMESTONE);
    public static final DeferredItem<Item> OVERGROWN_LIMESTONE_ITEM = blockItem(OVERGROWN_LIMESTONE);

    public static final DeferredItem<Item> LIMESTONE_COBBLESTONE_STAIRS_ITEM = blockItem(LIMESTONE_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> LIMESTONE_COBBLESTONE_SLAB_ITEM = blockItem(LIMESTONE_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> LIMESTONE_COBBLESTONE_WALL_ITEM = blockItem(LIMESTONE_COBBLESTONE_WALL);
    public static final DeferredItem<Item> POLISHED_LIMESTONE_STAIRS_ITEM = blockItem(POLISHED_LIMESTONE_STAIRS);
    public static final DeferredItem<Item> POLISHED_LIMESTONE_SLAB_ITEM = blockItem(POLISHED_LIMESTONE_SLAB);
    public static final DeferredItem<Item> POLISHED_LIMESTONE_WALL_ITEM = blockItem(POLISHED_LIMESTONE_WALL);
    public static final DeferredItem<Item> LIMESTONE_BRICKS_STAIRS_ITEM = blockItem(LIMESTONE_BRICKS_STAIRS);
    public static final DeferredItem<Item> LIMESTONE_BRICKS_SLAB_ITEM = blockItem(LIMESTONE_BRICKS_SLAB);
    public static final DeferredItem<Item> LIMESTONE_BRICKS_WALL_ITEM = blockItem(LIMESTONE_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_LIMESTONE_BRICKS_STAIRS_ITEM = blockItem(FANCY_LIMESTONE_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_LIMESTONE_BRICKS_SLAB_ITEM = blockItem(FANCY_LIMESTONE_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_LIMESTONE_BRICKS_WALL_ITEM = blockItem(FANCY_LIMESTONE_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_LIMESTONE_STAIRS_ITEM = blockItem(PAVED_LIMESTONE_STAIRS);
    public static final DeferredItem<Item> PAVED_LIMESTONE_SLAB_ITEM = blockItem(PAVED_LIMESTONE_SLAB);
    public static final DeferredItem<Item> PAVED_LIMESTONE_WALL_ITEM = blockItem(PAVED_LIMESTONE_WALL);

    public static final DeferredItem<Item> WEATHERED_LIMESTONE_ITEM = blockItem(WEATHERED_LIMESTONE);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_COBBLESTONE_ITEM = blockItem(WEATHERED_LIMESTONE_COBBLESTONE);
    public static final DeferredItem<Item> POLISHED_WEATHERED_LIMESTONE_ITEM = blockItem(POLISHED_WEATHERED_LIMESTONE);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_BRICKS_ITEM = blockItem(WEATHERED_LIMESTONE_BRICKS);
    public static final DeferredItem<Item> FANCY_WEATHERED_LIMESTONE_BRICKS_ITEM = blockItem(FANCY_WEATHERED_LIMESTONE_BRICKS);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_PILLAR_ITEM = blockItem(WEATHERED_LIMESTONE_PILLAR);
    public static final DeferredItem<Item> PAVED_WEATHERED_LIMESTONE_ITEM = blockItem(PAVED_WEATHERED_LIMESTONE);
    public static final DeferredItem<Item> LAYERED_WEATHERED_LIMESTONE_ITEM = blockItem(LAYERED_WEATHERED_LIMESTONE);
    public static final DeferredItem<Item> CHISELED_WEATHERED_LIMESTONE_ITEM = blockItem(CHISELED_WEATHERED_LIMESTONE);
    public static final DeferredItem<Item> MOSSY_WEATHERED_LIMESTONE_ITEM = blockItem(MOSSY_WEATHERED_LIMESTONE);
    public static final DeferredItem<Item> OVERGROWN_WEATHERED_LIMESTONE_ITEM = blockItem(OVERGROWN_WEATHERED_LIMESTONE);

    public static final DeferredItem<Item> WEATHERED_LIMESTONE_COBBLESTONE_STAIRS_ITEM = blockItem(WEATHERED_LIMESTONE_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_COBBLESTONE_SLAB_ITEM = blockItem(WEATHERED_LIMESTONE_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_COBBLESTONE_WALL_ITEM = blockItem(WEATHERED_LIMESTONE_COBBLESTONE_WALL);
    public static final DeferredItem<Item> POLISHED_WEATHERED_LIMESTONE_STAIRS_ITEM = blockItem(POLISHED_WEATHERED_LIMESTONE_STAIRS);
    public static final DeferredItem<Item> POLISHED_WEATHERED_LIMESTONE_SLAB_ITEM = blockItem(POLISHED_WEATHERED_LIMESTONE_SLAB);
    public static final DeferredItem<Item> POLISHED_WEATHERED_LIMESTONE_WALL_ITEM = blockItem(POLISHED_WEATHERED_LIMESTONE_WALL);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_BRICKS_STAIRS_ITEM = blockItem(WEATHERED_LIMESTONE_BRICKS_STAIRS);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_BRICKS_SLAB_ITEM = blockItem(WEATHERED_LIMESTONE_BRICKS_SLAB);
    public static final DeferredItem<Item> WEATHERED_LIMESTONE_BRICKS_WALL_ITEM = blockItem(WEATHERED_LIMESTONE_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_WEATHERED_LIMESTONE_BRICKS_STAIRS_ITEM = blockItem(FANCY_WEATHERED_LIMESTONE_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_WEATHERED_LIMESTONE_BRICKS_SLAB_ITEM = blockItem(FANCY_WEATHERED_LIMESTONE_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_WEATHERED_LIMESTONE_BRICKS_WALL_ITEM = blockItem(FANCY_WEATHERED_LIMESTONE_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_WEATHERED_LIMESTONE_STAIRS_ITEM = blockItem(PAVED_WEATHERED_LIMESTONE_STAIRS);
    public static final DeferredItem<Item> PAVED_WEATHERED_LIMESTONE_SLAB_ITEM = blockItem(PAVED_WEATHERED_LIMESTONE_SLAB);
    public static final DeferredItem<Item> PAVED_WEATHERED_LIMESTONE_WALL_ITEM = blockItem(PAVED_WEATHERED_LIMESTONE_WALL);

    public static final DeferredItem<Item> GRANITE_COBBLESTONE_ITEM = blockItem(GRANITE_COBBLESTONE);
    public static final DeferredItem<Item> GRANITE_BRICKS_ITEM = blockItem(GRANITE_BRICKS);
    public static final DeferredItem<Item> FANCY_GRANITE_BRICKS_ITEM = blockItem(FANCY_GRANITE_BRICKS);
    public static final DeferredItem<Item> GRANITE_PILLAR_ITEM = blockItem(GRANITE_PILLAR);
    public static final DeferredItem<Item> PAVED_GRANITE_ITEM = blockItem(PAVED_GRANITE);
    public static final DeferredItem<Item> LAYERED_GRANITE_ITEM = blockItem(LAYERED_GRANITE);
    public static final DeferredItem<Item> MOSSY_GRANITE_ITEM = blockItem(MOSSY_GRANITE);
    public static final DeferredItem<Item> OVERGROWN_GRANITE_ITEM = blockItem(OVERGROWN_GRANITE);

    public static final DeferredItem<Item> GRANITE_COBBLESTONE_STAIRS_ITEM = blockItem(GRANITE_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> GRANITE_COBBLESTONE_SLAB_ITEM = blockItem(GRANITE_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> GRANITE_COBBLESTONE_WALL_ITEM = blockItem(GRANITE_COBBLESTONE_WALL);
    public static final DeferredItem<Item> GRANITE_BRICKS_STAIRS_ITEM = blockItem(GRANITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> GRANITE_BRICKS_SLAB_ITEM = blockItem(GRANITE_BRICKS_SLAB);
    public static final DeferredItem<Item> GRANITE_BRICKS_WALL_ITEM = blockItem(GRANITE_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_GRANITE_BRICKS_STAIRS_ITEM = blockItem(FANCY_GRANITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_GRANITE_BRICKS_SLAB_ITEM = blockItem(FANCY_GRANITE_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_GRANITE_BRICKS_WALL_ITEM = blockItem(FANCY_GRANITE_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_GRANITE_STAIRS_ITEM = blockItem(PAVED_GRANITE_STAIRS);
    public static final DeferredItem<Item> PAVED_GRANITE_SLAB_ITEM = blockItem(PAVED_GRANITE_SLAB);
    public static final DeferredItem<Item> PAVED_GRANITE_WALL_ITEM = blockItem(PAVED_GRANITE_WALL);

    public static final DeferredItem<Item> DIORITE_COBBLESTONE_ITEM = blockItem(DIORITE_COBBLESTONE);
    public static final DeferredItem<Item> DIORITE_BRICKS_ITEM = blockItem(DIORITE_BRICKS);
    public static final DeferredItem<Item> FANCY_DIORITE_BRICKS_ITEM = blockItem(FANCY_DIORITE_BRICKS);
    public static final DeferredItem<Item> DIORITE_PILLAR_ITEM = blockItem(DIORITE_PILLAR);
    public static final DeferredItem<Item> PAVED_DIORITE_ITEM = blockItem(PAVED_DIORITE);
    public static final DeferredItem<Item> LAYERED_DIORITE_ITEM = blockItem(LAYERED_DIORITE);
    public static final DeferredItem<Item> MOSSY_DIORITE_ITEM = blockItem(MOSSY_DIORITE);
    public static final DeferredItem<Item> OVERGROWN_DIORITE_ITEM = blockItem(OVERGROWN_DIORITE);

    public static final DeferredItem<Item> DIORITE_COBBLESTONE_STAIRS_ITEM = blockItem(DIORITE_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> DIORITE_COBBLESTONE_SLAB_ITEM = blockItem(DIORITE_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> DIORITE_COBBLESTONE_WALL_ITEM = blockItem(DIORITE_COBBLESTONE_WALL);
    public static final DeferredItem<Item> DIORITE_BRICKS_STAIRS_ITEM = blockItem(DIORITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> DIORITE_BRICKS_SLAB_ITEM = blockItem(DIORITE_BRICKS_SLAB);
    public static final DeferredItem<Item> DIORITE_BRICKS_WALL_ITEM = blockItem(DIORITE_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_DIORITE_BRICKS_STAIRS_ITEM = blockItem(FANCY_DIORITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_DIORITE_BRICKS_SLAB_ITEM = blockItem(FANCY_DIORITE_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_DIORITE_BRICKS_WALL_ITEM = blockItem(FANCY_DIORITE_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_DIORITE_STAIRS_ITEM = blockItem(PAVED_DIORITE_STAIRS);
    public static final DeferredItem<Item> PAVED_DIORITE_SLAB_ITEM = blockItem(PAVED_DIORITE_SLAB);
    public static final DeferredItem<Item> PAVED_DIORITE_WALL_ITEM = blockItem(PAVED_DIORITE_WALL);

    public static final DeferredItem<Item> ANDESITE_COBBLESTONE_ITEM = blockItem(ANDESITE_COBBLESTONE);
    public static final DeferredItem<Item> ANDESITE_BRICKS_ITEM = blockItem(ANDESITE_BRICKS);
    public static final DeferredItem<Item> FANCY_ANDESITE_BRICKS_ITEM = blockItem(FANCY_ANDESITE_BRICKS);
    public static final DeferredItem<Item> ANDESITE_PILLAR_ITEM = blockItem(ANDESITE_PILLAR);
    public static final DeferredItem<Item> PAVED_ANDESITE_ITEM = blockItem(PAVED_ANDESITE);
    public static final DeferredItem<Item> LAYERED_ANDESITE_ITEM = blockItem(LAYERED_ANDESITE);
    public static final DeferredItem<Item> MOSSY_ANDESITE_ITEM = blockItem(MOSSY_ANDESITE);
    public static final DeferredItem<Item> OVERGROWN_ANDESITE_ITEM = blockItem(OVERGROWN_ANDESITE);

    public static final DeferredItem<Item> ANDESITE_COBBLESTONE_STAIRS_ITEM = blockItem(ANDESITE_COBBLESTONE_STAIRS);
    public static final DeferredItem<Item> ANDESITE_COBBLESTONE_SLAB_ITEM = blockItem(ANDESITE_COBBLESTONE_SLAB);
    public static final DeferredItem<Item> ANDESITE_COBBLESTONE_WALL_ITEM = blockItem(ANDESITE_COBBLESTONE_WALL);
    public static final DeferredItem<Item> ANDESITE_BRICKS_STAIRS_ITEM = blockItem(ANDESITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> ANDESITE_BRICKS_SLAB_ITEM = blockItem(ANDESITE_BRICKS_SLAB);
    public static final DeferredItem<Item> ANDESITE_BRICKS_WALL_ITEM = blockItem(ANDESITE_BRICKS_WALL);
    public static final DeferredItem<Item> FANCY_ANDESITE_BRICKS_STAIRS_ITEM = blockItem(FANCY_ANDESITE_BRICKS_STAIRS);
    public static final DeferredItem<Item> FANCY_ANDESITE_BRICKS_SLAB_ITEM = blockItem(FANCY_ANDESITE_BRICKS_SLAB);
    public static final DeferredItem<Item> FANCY_ANDESITE_BRICKS_WALL_ITEM = blockItem(FANCY_ANDESITE_BRICKS_WALL);
    public static final DeferredItem<Item> PAVED_ANDESITE_STAIRS_ITEM = blockItem(PAVED_ANDESITE_STAIRS);
    public static final DeferredItem<Item> PAVED_ANDESITE_SLAB_ITEM = blockItem(PAVED_ANDESITE_SLAB);
    public static final DeferredItem<Item> PAVED_ANDESITE_WALL_ITEM = blockItem(PAVED_ANDESITE_WALL);

    public static void setupClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(MOSSY_GABBRO.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_GABBRO.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_DOLOMITE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_DOLOMITE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_SCORIA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_SCORIA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_DARK_SCORIA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_DARK_SCORIA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_LIMESTONE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_LIMESTONE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_WEATHERED_LIMESTONE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_WEATHERED_LIMESTONE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_GRANITE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_GRANITE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_DIORITE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_DIORITE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MOSSY_ANDESITE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(OVERGROWN_ANDESITE.get(), RenderType.translucent());
        });
    }

    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, tint) -> {
            if (level != null && pos != null) {
                return BiomeColors.getAverageGrassColor(level, pos);
            }
            return GrassColor.get(0.5D, 1.0D);
        }, MOSSY_GABBRO.get(), OVERGROWN_GABBRO.get(), MOSSY_DOLOMITE.get(), OVERGROWN_DOLOMITE.get(),
                MOSSY_SCORIA.get(), OVERGROWN_SCORIA.get(), MOSSY_DARK_SCORIA.get(), OVERGROWN_DARK_SCORIA.get(),
                MOSSY_LIMESTONE.get(), OVERGROWN_LIMESTONE.get(), MOSSY_WEATHERED_LIMESTONE.get(),
                OVERGROWN_WEATHERED_LIMESTONE.get(), MOSSY_GRANITE.get(), OVERGROWN_GRANITE.get(),
                MOSSY_DIORITE.get(), OVERGROWN_DIORITE.get(),
                MOSSY_ANDESITE.get(), OVERGROWN_ANDESITE.get());
        event.register((state, level, pos, tint) -> {
            if (level != null && pos != null) {
                return naturalScoriaColor(pos);
            }
            return 0x448888;
        }, NATURAL_SCORIA.get());
    }

    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tint) -> GrassColor.get(0.5D, 1.0D),
                MOSSY_GABBRO.get(), OVERGROWN_GABBRO.get(), MOSSY_DOLOMITE.get(), OVERGROWN_DOLOMITE.get(),
                MOSSY_SCORIA.get(), OVERGROWN_SCORIA.get(), MOSSY_DARK_SCORIA.get(), OVERGROWN_DARK_SCORIA.get(),
                MOSSY_LIMESTONE.get(), OVERGROWN_LIMESTONE.get(), MOSSY_WEATHERED_LIMESTONE.get(),
                OVERGROWN_WEATHERED_LIMESTONE.get(), MOSSY_GRANITE.get(), OVERGROWN_GRANITE.get(),
                MOSSY_DIORITE.get(), OVERGROWN_DIORITE.get(),
                MOSSY_ANDESITE.get(), OVERGROWN_ANDESITE.get());
        event.register((stack, tint) -> 0x448888, NATURAL_SCORIA.get());
    }

    private static int mixChannel(int color, int other, float weight) {
        float w = Math.max(0F, Math.min(1F, weight));
        int r = Math.round(((color >> 16) & 0xFF) * (1 - w) + (((other >> 16) & 0xFF) * w));
        int g = Math.round(((color >> 8) & 0xFF) * (1 - w) + (((other >> 8) & 0xFF) * w));
        int b = Math.round((color & 0xFF) * (1 - w) + ((other & 0xFF) * w));
        return (r << 16) | (g << 8) | b;
    }

    private static int naturalScoriaColor(BlockPos pos) {
        double x = pos.getX(), y = pos.getY(), z = pos.getZ();
        double x2 = Math.floor(z + x - y * 0.5D);
        double y2 = Math.floor(y * 1.5D + x * 0.5D - z);
        double z2 = Math.floor(y - z * 0.5D - x);
        int color = 0x448888;
        if (x2 % 2 == 0) {
            color |= 0x0011FF;
        }
        if (z2 % 2 == 0) {
            color |= 0x888888;
        }
        float hue = (float) (((x + y + z) * 170 % 360 + 360) % 360) / 360F;
        color = mixChannel(color, java.awt.Color.HSBtoRGB(hue, 1F, 1F) & 0xFFFFFF, 0.4F);
        if (x2 % 4 == 0 || y2 % 4 == 0) {
            color = mixChannel(color, 0xFFFFFF, 0.8F);
        }
        return color;
    }
}
