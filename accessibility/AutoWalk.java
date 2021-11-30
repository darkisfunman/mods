package club.insomnia.module.accessibility;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class AutoWalk extends Module {
	
	public AutoWalk() {
		super("AutoWalk", Keyboard.KEY_NONE, Category.ACCESSIBILITY, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindForward.pressed = true;
			if(mc.thePlayer.isCollidedHorizontally && mc.thePlayer.onGround && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isSneaking() && !mc.thePlayer.isInWater())
				mc.thePlayer.jump();
		}
		super.onUpdate();
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
		super.onDisable();
	}
	
}
