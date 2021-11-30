package club.insomnia.module.render;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class Fullbright extends Module {
	
	public Fullbright() {
		super("Fullbright", Keyboard.KEY_NONE, Category.RENDER, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.gammaSetting = 1000f;
		}
	}
	
}
