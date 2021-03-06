package tk.nukeduck.hud.element.text;

import static tk.nukeduck.hud.BetterHud.MC;

import net.minecraft.client.resources.I18n;
import tk.nukeduck.hud.element.settings.SettingBoolean;
import tk.nukeduck.hud.util.Direction;

public class FullInvIndicator extends TextElement {
	private final SettingBoolean offHand = new SettingBoolean("offhand");

	@Override
	public void loadDefaults() {
		super.loadDefaults();

		this.settings.set(true);
		position.set(Direction.NORTH_EAST);
		offHand.set(false);
	}

	public FullInvIndicator() {
		super("fullInvIndicator");
		settings.add(offHand);
	}

	@Override
	protected String[] getText() {
		return new String[] {I18n.format("betterHud.hud.fullInv")};
	}

	@Override
	public boolean shouldRender() {
		return MC.player.inventory.getFirstEmptyStack() == -1 &&
			(!offHand.get() || !MC.player.inventory.offHandInventory.get(0).isEmpty());
	}
}
