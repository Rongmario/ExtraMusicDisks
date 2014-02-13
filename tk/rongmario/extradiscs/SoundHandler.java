package tk.rongmario.extradiscs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler
{
    @SideOnly(Side.CLIENT)
    @ForgeSubscribe
    public void onSoundsLoaded(SoundLoadEvent event)
    {
        SoundManager manager = event.manager;
        addOggToStreaming(manager, "dubstep1");
		addOggToStreaming(manager, "dubstep2");
		addOggToStreaming(manager, "dubstep3");
		addOggToStreaming(manager, "dubstep4");
		addOggToStreaming(manager, "dubstep5");
        addOggToStreaming(manager, "classical1");
        addOggToStreaming(manager, "nightowl");
        addOggToStreaming(manager, "eclosion");
        addOggToStreaming(manager, "chiptune1");
        addOggToStreaming(manager, "zabriskie1");
        addOggToStreaming(manager, "zabriskie2");
        addOggToStreaming(manager, "rvegners");
		addOggToStreaming(manager, "goobypls");
		addOggToStreaming(manager, "chiptune2");
		addOggToStreaming(manager, "pony1");
    }

    private void addOggToStreaming(SoundManager manager, String fileName)
    {
        manager.addStreaming(ExtraDiscs.ASSETS + fileName + ".ogg");
    }
}
