package club.insomnia.module.movement;

import org.lwjgl.input.Keyboard;

import club.insomnia.module.Category;
import club.insomnia.module.Module;
import club.insomnia.utils.Invoker;

public class Spider extends Module {

	public Spider() {
		super("Spider", Keyboard.KEY_NONE, Category.MOVEMENT, false);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(Invoker.isCollidedHorizontally()) {
				Invoker.setMotionY(0.2);
				
				float var6 = 0.15F;
				
				if(Invoker.getMotionX() < (double) -var6) {
					Invoker.setMotionX((double) -var6);
				}
				
				if(Invoker.getMotionX() > (double) var6) {
					Invoker.setMotionX((double) var6);
				}
				
				if(Invoker.getMotionZ() < (double) -var6) {
					Invoker.setMotionZ((double) -var6);
				}
				
				if(Invoker.getMotionZ() > (double) var6) {
					Invoker.setMotionZ((double) var6);
				}
				
				Invoker.setFallDistance(0);
				
				if(Invoker.getMotionY() < 0.15D) {
					Invoker.setMotionY(-0.15D);
				}
			}
		}
	}
	
}
