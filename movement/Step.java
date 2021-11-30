package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;
import club.insomnia.utils.Invoker;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Step extends Module {

	public Step() {
		super("Step", Keyboard.KEY_NONE, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(Invoker.isCollidedHorizontally() && mc.thePlayer.onGround) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.42, mc.thePlayer.posZ, mc.thePlayer.onGround));
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.72, mc.thePlayer.posZ, mc.thePlayer.onGround));
				mc.thePlayer.stepHeight = 1f;
			}
		} else {
			mc.thePlayer.stepHeight = 0.5f;
		}
	}
	
}
