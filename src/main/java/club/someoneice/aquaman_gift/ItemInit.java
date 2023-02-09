package club.someoneice.aquaman_gift;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import project.studio.manametalmod.config.M3Config;
import project.studio.manametalmod.produce.fishing.FishingCore;

public class ItemInit {
   public static Item aquamanBucket = new AquamanBucket();
   public static Item aquamanBucketFull = new AquamanBucketFull();
    public ItemInit() {
        GameRegistry.addRecipe(new ItemStack(aquamanBucket, 2), "OBO", " O ", 'O', FishingCore.oceanItem, 'B', Items.bucket);
    }


    private static class AquamanBucket extends Item {
        public AquamanBucket() {
            this.setUnlocalizedName("aquaman_bucket");
            this.setTextureName(Util.getTexturesName("aquaman_bucket"));
            this.setCreativeTab(Modinfo.AG_TAB);
            GameRegistry.registerItem(this, "aquaman_bucket", Modinfo.MOD_ID);
        }

        @Override
        public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
            if (!world.isRemote && world.provider.dimensionId == M3Config.WorldOceanID) {
                MovingObjectPosition object = this.getMovingObjectPositionFromPlayer(world, player, true);
                if (object != null && world.getBlock(object.blockX, object.blockY, object.blockZ).getMaterial() == Material.water) {
                    --item.stackSize;
                    if (item.stackSize <= 0) return new ItemStack(aquamanBucketFull);

                    if (!player.inventory.addItemStackToInventory(new ItemStack(aquamanBucketFull)))
                        player.dropPlayerItemWithRandomChoice(new ItemStack(aquamanBucketFull, 1, 0), false);

                    return item;
                }
            }

            return item;
        }
    }

    private static class AquamanBucketFull extends Item {
        public AquamanBucketFull() {
            this.setUnlocalizedName("aquaman_bucket_full");
            this.setTextureName(Util.getTexturesName("aquaman_bucket_full"));
            this.setCreativeTab(Modinfo.AG_TAB);
            GameRegistry.registerItem(this, "aquaman_bucket_full", Modinfo.MOD_ID);
        }
    }
}
