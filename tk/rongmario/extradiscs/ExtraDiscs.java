package tk.rongmario.extradiscs;

import java.util.Arrays;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ExtraDiscs.MODID, name = ExtraDiscs.NAME, version = ExtraDiscs.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ExtraDiscs
{
    public static final String MODID = "extradiscs";
    public static final String NAME = "Extra Music Discs";
    public static final String VERSION = "1.0.2";
    public static final String ASSETS = MODID + ":";

    @Mod.Instance(MODID)
    public static ExtraDiscs instance;

    public static final CreativeTabs tabED = new CreativeTabs(MODID)
    {
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
            return recordDubstep1.itemID;
        }
    };

    private int nextItemID = 22256;

    public static int recordDubstep1ID, recordClassical1ID, recordNightOwlID, recordEclosionID, recordChiptune1ID, recordZabriskie1ID, recordZabriskie2ID, recordRVegnersID, recordGoobyPlsID, recordChiptune2ID, recordPony1ID, recordDubstep2ID;
    public static Item recordDubstep1, recordClassical1, recordNightOwl, recordEclosion, recordChiptune1, recordZabriskie1, recordZabriskie2, recordRVegners, recordGoobyPls, recordChiptune2, recordPony1, recordDubstep2;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModMetadata modMeta = event.getModMetadata();
        modMeta.authorList = Arrays.asList(new String[]{"Rongmario", "general3214"});
        modMeta.autogenerated = false;
        modMeta.credits = "Music authors, OpenSourceMusic.com, FreeMusicArchive.org, SoundCloud";
        modMeta.description = "Mod that aims to add more music to the world of Minecraft :3";
        modMeta.url = "https://github.com/Rongmario/ExtraMusicDisks";
        
		//General3214's fail, didn't load and save config file >.<
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
        recordDubstep1ID = getNextItemID(config, "recordDubstep1ID");
		recordDubstep2ID = getNextItemID(config, "recordDubstep2ID");
        recordClassical1ID = getNextItemID(config, "recordClassical1ID");
        recordNightOwlID = getNextItemID(config, "recordNightOwlID");
        recordEclosionID = getNextItemID(config, "recordEclosionID");
        recordChiptune1ID = getNextItemID(config, "recordChiptune1ID");
		recordChiptune2ID = getNextItemID(config, "recordChiptune2ID");
        recordZabriskie1ID = getNextItemID(config, "recordZabriskie1ID");
        recordZabriskie2ID = getNextItemID(config, "recordZabriskie2ID");
        recordRVegnersID = getNextItemID(config, "recordRVegnersID");
		recordGoobyPlsID = getNextItemID(config, "recordGoobyplsID");
		recordPony1ID = getNextItemID(config, "recordPony1ID");
		config.save();
		
		
    }   //Will try make users make their own content pack, in 1.7 or 1.8

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)   {   
		recordDubstep1 = (new ItemEDRecord(recordDubstep1ID, ASSETS + "dubstep1", "Double the Trouble")).setRecordArtist("3dNOW").setTextureName(ASSETS + "record_dubstep1");
		recordDubstep2 = (new ItemEDRecord(recordDubstep2ID, ASSETS + "dubstep2", "Rock your Emotions 8Bit")).setRecordArtist("SestCH & Kitsune^2").setTextureName(ASSETS + "record_dubstep2");
        recordClassical1 = (new ItemEDRecord(recordClassical1ID, ASSETS + "classical1", "K. 525, Allegro")).setRecordArtist("W. A. Mozart").setTextureName(ASSETS + "record_classical1");
        recordNightOwl = (new ItemEDRecord(recordNightOwlID, ASSETS + "nightowl", "Night Owl")).setRecordArtist("Broke For Free").setTextureName(ASSETS + "record_nightowl");
        recordEclosion = (new ItemEDRecord(recordEclosionID, ASSETS + "eclosion", "Eclosion")).setRecordArtist("Salmo").setTextureName(ASSETS + "record_eclosion");
        recordChiptune1 = (new ItemEDRecord(recordChiptune1ID, ASSETS + "chiptune1", "A Ninja Among Oscillators")).setRecordArtist("Rolemusic").setTextureName(ASSETS + "record_chiptune1");
		recordChiptune2 = (new ItemEDRecord(recordChiptune2ID, ASSETS + "chiptune2", "Happy Chiptunes")).setRecordArtist("Soniau").setTextureName(ASSETS + "record_chiptune2");
        recordZabriskie1 = (new ItemEDRecord(recordZabriskie1ID, ASSETS + "zabriskie1", "The Temperature of the Air on the Bow of the Kaleetan")).setRecordArtist("Chris Zabriskie").setTextureName(ASSETS + "record_zabriskie1");
        recordZabriskie2 = (new ItemEDRecord(recordZabriskie2ID, ASSETS + "zabriskie2", "That Kid in Fourth Grade Who Really Liked the Denver Broncos")).setRecordArtist("Chris Zabriskie").setTextureName(ASSETS + "record_zabriskie2");
        recordRVegners = (new ItemEDRecord(recordRVegnersID, ASSETS + "rvegners", "Rolands Vegners")).setRecordArtist("Ergo Phizmiz & Margita Zalite").setTextureName(ASSETS + "record_rvegners");
		recordGoobyPls = (new ItemEDRecord(recordGoobyPlsID, ASSETS + "goobypls", "Gooby Pls")).setRecordArtist("Sim Gretina").setTextureName(ASSETS + "record_goobypls");
		recordPony1 = (new ItemEDRecord(recordPony1ID, ASSETS + "pony1", "Love me Cheerilee")).setRecordArtist("The Living Tombstone & Wooden Toaster").setTextureName(ASSETS + "record_pony1");

        MinecraftForge.EVENT_BUS.register(new SoundHandler());

        // Add in-game localization for tabED
        LanguageRegistry.instance().addStringLocalization("itemGroup." + MODID, NAME);
	
	//Rongmario Fixed his code himself :O (Thanks MineMaarten and Domi1819!)
	    WeightedRandomChestContent item = new WeightedRandomChestContent(new ItemStack(recordDubstep1.itemID, 1, 0), 1, 8, 15);
        ChestGenHooks.addItem("dungeonChest", item);
	    ChestGenHooks.addItem("strongholdCorridor", item);
	    ChestGenHooks.addItem("strongholdCrossing", item);
        ChestGenHooks.addItem("pyramidDesertyChest", item);
        ChestGenHooks.addItem("pyramidJungleChest", item);
        ChestGenHooks.addItem("villageBlacksmith", item);
    }

    private int getNextItemID(Configuration config, String label)
    {   //Did this so the internet ppl doesn't get confused <3
        return config.get("item", label, nextItemID++).getInt() - 256; // Item IDs are automatically added by 256
    }
}
