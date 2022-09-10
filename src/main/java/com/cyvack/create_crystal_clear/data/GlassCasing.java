package com.cyvack.create_crystal_clear.data;

import com.cyvack.create_crystal_clear.GlassEncasedShaftBlock;
import com.simibubi.create.content.palettes.ConnectedGlassBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlassCasing extends GlassBlock {

	public GlassCasing(Properties p_53640_) {
		super(p_53640_);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction side) {
		if (!(pState.getBlock() instanceof GlassCasing)) return false;
		if (!(pAdjacentBlockState.getBlock() instanceof GlassCasing)) return false;
		return true;
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidState) {
		return true;
	}
}