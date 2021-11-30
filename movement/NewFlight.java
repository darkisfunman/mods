package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;

public class NewFlight extends Module {
	
	public static float flyHackSpeed = 0.1f;
	
	public NewFlight() {
		super("NewFlight", Keyboard.KEY_G, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.capabilities.isFlying = true;
			
			if(mc.gameSettings.keyBindJump.isPressed())
				mc.thePlayer.motionY += 0.2f;
			
			if(mc.gameSettings.keyBindSneak.isPressed())
				mc.thePlayer.motionY -= 0.2f;
			
			if(mc.gameSettings.keyBindForward.isPressed())
				mc.thePlayer.capabilities.setFlySpeed(flyHackSpeed);
			
			super.onUpdate();
		}
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	
}
