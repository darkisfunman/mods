package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class AirJump extends Module {
	
	public AirJump() {
		super("AirJump", Keyboard.KEY_NONE, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.gameSettings.keyBindJump.isPressed()) {
				mc.thePlayer.jump();
			}
			super.onUpdate();
		}
	}
	
}
