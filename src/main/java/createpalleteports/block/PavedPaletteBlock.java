package createpalleteports.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

/**
 * Port of Create 1.16.5's {@code PavedBlock}: renders its "covered" (borderless)
 * texture when another paved block of the same type sits directly on top.
 */
public class PavedPaletteBlock extends Block {

    public static final BooleanProperty COVERED = BooleanProperty.create("covered");

    public PavedPaletteBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(COVERED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(COVERED));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(COVERED,
                context.getLevel().getBlockState(context.getClickedPos().above()).getBlock() == this);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
            LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.UP) {
            return state.setValue(COVERED, neighborState.getBlock() == this);
        }
        return state;
    }
}
