package de.pixl.pixlclient.cosmetics.cape;

import de.pixl.pixlclient.cosmetics.cape.capes.LightningCape;
import de.pixl.pixlclient.cosmetics.cape.capes.PixlCape;
import de.pixl.pixlclient.cosmetics.cape.capes.TestCape;
import de.pixl.pixlclient.cosmetics.cape.capes.YinYangCape;
import net.minecraft.resources.ResourceLocation;

public interface Cape {

    String name();
    ResourceLocation getResourceLocation();

    default int getDelay() {
        return 0;
    }

    default boolean isAnimated() {
        return false;
    }

    static Cape fromName(String name) {
        return switch (name.toLowerCase()) {
            case "test" -> new TestCape();
            case "pixlcape" -> new PixlCape();
            case "yinyangcape" -> new YinYangCape();
            case "lightning" -> new LightningCape();
            default -> null;
        };
    }
}
