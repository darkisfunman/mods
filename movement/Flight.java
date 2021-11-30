package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class Flight extends Module {
	
	public Flight() {
		super("Flight", Keyboard.KEY_NONE, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.capabilities.allowFlying = true;
			mc.thePlayer.capabilities.isFlying = true;
			super.onUpdate();
		}
	}
	
	@Override
	public void onDisable() {
		if(!mc.thePlayer.capabilities.isCreativeMode)
			mc.thePlayer.capabilities.allowFlying = false;
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	
}
