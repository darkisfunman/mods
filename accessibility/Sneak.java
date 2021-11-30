package club.insomnia.module.accessibility;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class Sneak extends Module {
	
	public Sneak() {
		super("Sneak", Keyboard.KEY_B, Category.ACCESSIBILITY, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindSneak.pressed = true;
			super.onUpdate();
		}
	}
	
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindSneak.pressed = false;
		super.onDisable();
	}
	
}
