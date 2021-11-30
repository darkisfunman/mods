package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class FastFall extends Module {
	
	public FastFall() {
		super("FastFall", Keyboard.KEY_NONE, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isAirBorne && !mc.thePlayer.capabilities.isFlying && !mc.thePlayer.isInWater()) {
				mc.thePlayer.motionY -= 0.3;
			}
		}
	}
	
}
