package tk.rongmario.extradiscs;

import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import java.util.Arrays;

@Mod(modid = ExtraDisks.MODID, name = ExtraDisks.NAME, version = ExtraDisks.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ExtraDisks
{
    public static final String MODID = "extradiscs";
    public static final String NAME = "Extra Music Discs";
    public static final String VERSION = "1.0.0";
    public static final String ASSETS = MODID + ":";

    @Mod.Instance(MODID)
    public static ExtraDisks instance = new ExtraDisks();

    public static final CreativeTabs tabED = new CreativeTabs(MODID)
    {
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
            return recordDubstep1.itemID;
        }
    };

    private int nextItemID = 20000;

    public static int recordDubstep1ID;
    public static Item recordDubstep1;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModMetadata modMeta = event.getModMetadata();
        modMeta.authorList = Arrays.asList(new String[]{"Rongmario", "general3214"});
        modMeta.autogenerated = false;
        modMeta.credits = "dubstep1.ogg creator";
        modMeta.description = "Mod that aims to add more music to the world of Minecraft :3";
        modMeta.url = "https://github.com/Rongmario/ExtraMusicDisks";

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        recordDubstep1ID = getNextItemID(config, "recordDubstep1ID");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        recordDubstep1 = (new ItemEDRecord(recordDubstep1ID, ASSETS + "dubstep1", "Double the Trouble")).setRecordArtist("3dNOW").setTextureName(ASSETS + "record_dubstep1");

        // Register sound handler
        MinecraftForge.EVENT_BUS.register(new SoundHandler());

        // Add in-game localization for tabED
        LanguageRegistry.instance().addStringLocalization("itemGroup." + MODID, NAME);
    }

    private int getNextItemID(Configuration config, String label)
    {
        return config.get("item", label, nextItemID++).getInt() - 256; // Item IDs are automatically added by 256
    }
}