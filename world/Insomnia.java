package club.insomnia.module.world;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class Insomnia extends Module {

	private static int radius = 3;

	public Insomnia() {
		super("Insomnia", Keyboard.KEY_NONE, Category.WORLD, false);
	}

	@Override
	public void onUpdate() {
		if (this.isToggled()) {
			
			for (int x = -radius; x <= radius; x++) {
				for (int y = radius; y >= -radius; y--) {
					for (int z = -radius; z <= radius; z++) {

						BlockPos pos = new BlockPos(mc.thePlayer.posX + x, mc.thePlayer.posY + y, mc.thePlayer.posZ + z);
						Block block = mc.theWorld.getBlockState(pos).getBlock();

						if (block.getMaterial() == Material.air)
							continue;
						if (block == Blocks.bed) {
							mc.thePlayer.sendQueue.addToSendQueue(
									new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, pos, EnumFacing.NORTH));
							mc.thePlayer.sendQueue.addToSendQueue(
									new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, pos, EnumFacing.NORTH));
						}
					}
				}
			}
		}
		super.onUpdate();
	}

}
