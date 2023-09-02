package de.pixl.pixlclient.cosmetics.cape.capes;

import de.pixl.pixlclient.cosmetics.cape.Cape;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.ConcurrentLinkedQueue;

public class LightningCape implements Cape {

    private final ConcurrentLinkedQueue<ResourceLocation> locations;

    public LightningCape() {
        locations = new ConcurrentLinkedQueue<>();
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_00.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_01.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_02.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_03.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_04.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_05.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_06.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_07.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_08.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_09.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_10.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_11.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_12.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_13.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_14.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_15.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_16.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_17.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_18.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_19.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_20.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_21.png"));
        locations.add(new ResourceLocation("pixlclient/capes/lightning/frame_22.png"));
    }

    @Override
    public String name() {
        return "lightning";
    }

    @Override
    public ResourceLocation getResourceLocation() {
        ResourceLocation current = locations.poll();
        locations.add(current);
        return current;
    }

    @Override
    public int getDelay() {
        return 85;
    }

    @Override
    public boolean isAnimated() {
        return true;
    }
}
