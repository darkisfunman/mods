package club.insomnia.module.accessibility;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class AutoJump extends Module {
	
	public AutoJump() {
		super("AutoJump", Keyboard.KEY_NONE, Category.ACCESSIBILITY, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isCollidedHorizontally && mc.thePlayer.onGround && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isSneaking() && !mc.thePlayer.isInWater())
				mc.thePlayer.jump();
		}
		super.onUpdate();
	}
	
}
