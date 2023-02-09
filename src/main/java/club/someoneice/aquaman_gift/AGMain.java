package club.someoneice.aquaman_gift;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Modinfo.MOD_ID, version = Modinfo.VERSION, dependencies = "required-after:manametalmod")
public class AGMain {
    public static Logger LOGGER = LogManager.getLogger();

    @Mod.EventHandler
    public void ModInitEvent(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void ModInit(FMLInitializationEvent event) {
        new BlockInit();

    }
}
