package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;
import net.minecraft.potion.PotionEffect;

public class Speed extends Module {
	
	public Speed() {
		super("Speed", Keyboard.KEY_Y, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if (this.isToggled()) {
			mc.thePlayer.addPotionEffect(new PotionEffect(1, 100, 2));
			super.onUpdate();
		}
	}

	@Override
	public void onDisable() {
		mc.thePlayer.removePotionEffect(1);
		super.onDisable();
	}
	
}
