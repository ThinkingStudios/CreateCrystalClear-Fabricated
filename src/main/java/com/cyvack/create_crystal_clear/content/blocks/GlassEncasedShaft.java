package com.cyvack.create_crystal_clear.content.blocks;

import com.cyvack.create_crystal_clear.index.CCBlockEntities;
import com.cyvack.create_crystal_clear.index.GlassUtil;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import com.simibubi.create.foundation.block.IBE;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class GlassEncasedShaft extends EncasedShaftBlock implements EncasedBlock, IBE<KineticBlockEntity> {
    int blockEntryHash;

    public GlassEncasedShaft(Properties properties, Supplier<Block> casing) {
        super(properties, casing);
        blockEntryHash = casing.get().hashCode();
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return CCBlockEntities.GLASS_ENCASED_SHAFT.get();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean skipRendering(BlockState selfState, BlockState adjacentBlock, Direction side) {
        return GlassUtil.checkForGlassBlock(adjacentBlock);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState p_49928_, BlockGetter p_49929_, BlockPos p_49930_) {
        return true;
    }

    @Override
    public float getShadeBrightness(BlockState p_60472_, BlockGetter p_60473_, BlockPos p_60474_) {
        return 1f;
    }
}
