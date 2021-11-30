package club.insomnia.module.accessibility;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class AutoSprint extends Module {

	public AutoSprint() {
		super("AutoSprint", Keyboard.KEY_F, Category.ACCESSIBILITY, false);
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.setSprinting(mc.gameSettings.keyBindSprint.isPressed());
		super.onDisable();
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isUsingItem() && !mc.thePlayer.isSneaking() && !mc.thePlayer.isCollidedHorizontally)
				mc.thePlayer.setSprinting(true);
		}
		super.onUpdate();
	}
	
}
