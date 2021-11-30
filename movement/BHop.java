package club.insomnia.module.movement;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;
import de.Hero.settings.Setting;

public class BHop extends Module {
	
	public BHop() {
		super("BHop", Keyboard.KEY_NONE, Category.MOVEMENT, false);
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.setSprinting(false);
		mc.gameSettings.keyBindForward.pressed = false;
		super.onDisable();
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.onGround)
				mc.thePlayer.jump();
			mc.gameSettings.keyBindForward.pressed = true;
			mc.thePlayer.setSprinting(true);
			super.onUpdate();
		}
	}
	
}
