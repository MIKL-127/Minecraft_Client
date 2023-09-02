package de.pixl.pixlclient.input.keys;

import com.mojang.blaze3d.platform.InputConstants;
import de.pixl.pixlclient.Client;
import de.pixl.pixlclient.input.IKey;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.network.chat.Component;

public class NameTagInF5Key implements IKey {
    @Override
    public void tick() { }

    public static boolean shouldShowNameTagInF5 = false;

    @Override
    public void keyPressed() {
        shouldShowNameTagInF5 = !shouldShowNameTagInF5;
        ToastComponent component = Client.minecraft.getToasts();
        SystemToast.addOrUpdate(component,
                SystemToast.SystemToastIds.PERIODIC_NOTIFICATION,
                Component.literal("Nametag in F5"),
                Component.literal(shouldShowNameTagInF5 ? "visible" : "invisible"));
    }

    @Override
    public void keyReleased() { }

    private static final KeyMapping mapping = new KeyMapping("key.nameTagInF5", InputConstants.KEY_N, "key.categories.pixlclient");

    public static KeyMapping getMapping() {
        return mapping;
    }
}
