package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class Dolphin extends Module {
	
	public Dolphin() {
		super("Dolphin", Keyboard.KEY_NONE, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isInWater()) {
				mc.thePlayer.motionY += 0.04;
			}
			super.onUpdate();
		}
	}
	
}
