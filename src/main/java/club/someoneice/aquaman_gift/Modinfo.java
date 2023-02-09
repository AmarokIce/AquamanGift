package club.someoneice.aquaman_gift;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import project.studio.manametalmod.produce.fishing.FishingCore;

public class Modinfo {
    public static final String MOD_ID = "aquaman_gift";
    public static final String VERSION = "1.0";
    public static final String ANOTHER = "Someoneice";

    public static final CreativeTabs AG_TAB = new CreativeTabs("aquaman_gift") {
        @Override
        public Item getTabIconItem() {
            return FishingCore.oceanItem;
        }
    };

}
