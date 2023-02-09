package club.someoneice.aquaman_gift;

import club.someoneice.aquaman_gift.bean.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockInit {
    public static Block aquamanBlock = blockAutoMakeBlockStone("aquaman_block");
    public static Block chiseledAquamanBlock = blockAutoMakeBlockStone("chiseled_aquaman_block");
    public static Block smoothAquamanBlock = blockAutoMakeBlockStone("smooth_aquaman_block");
    public static Block glazedAquamanBlock = blockAutoMakeBlockStone("glazed_aquaman_block");
    public static Block pillarAquamanBlock = new PillarBlock();

    public BlockInit() {
        GameRegistry.addSmelting(ItemInit.aquamanBucketFull, new ItemStack(aquamanBlock, 2), 0.5F);
        GameRegistry.addRecipe(new ItemStack(chiseledAquamanBlock), "#", "#", '#', GameRegistry.findItem(Modinfo.MOD_ID, "aquaman_block_slab"));
        GameRegistry.addRecipe(new ItemStack(pillarAquamanBlock), "#", "#", '#', aquamanBlock);
        GameRegistry.addRecipe(new ItemStack(smoothAquamanBlock), "##", "##", '#', aquamanBlock);
        GameRegistry.addSmelting(aquamanBlock, new ItemStack(glazedAquamanBlock), 0.5F);
    }

    public static Block blockAutoMakeBlockStone(String name) {
        Block block = new BlockBase(name);
        new BlockFences(name + "_fence", block);
        new BlockSlab(name + "_slab", block);
        new BlockStair(name + "_stair", block);
        new BlockWall(name + "_wall", block);

        return block;
    }

    private static class PillarBlock extends BlockRotatedPillar {
        @SideOnly(Side.CLIENT)
        protected IIcon sideIcon, topIcon;

        public PillarBlock() {
            super(Material.rock);
            this.setBlockName("aquaman_block_pillar");
            this.blockHardness = 1.0F;
            this.setHarvestLevel("pickaxe", 2);
            this.setCreativeTab(Modinfo.AG_TAB);
            GameRegistry.registerBlock(this, "aquaman_block_pillar");
        }

        @SideOnly(Side.CLIENT)
        protected IIcon getSideIcon(int p_150163_1_) {
            return this.sideIcon;
        }

        @SideOnly(Side.CLIENT)
        protected IIcon getTopIcon(int p_150161_1_) {
            return this.topIcon;
        }

        @Override
        public boolean isWood(IBlockAccess world, int x, int y, int z) {
            return true;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister icon) {
            this.blockIcon = icon.registerIcon(Modinfo.MOD_ID + ":aquaman_block_pillar_top");
            this.sideIcon = icon.registerIcon(Modinfo.MOD_ID + ":aquaman_block_pillar_side");
            this.topIcon = icon.registerIcon(Modinfo.MOD_ID + ":aquaman_block_pillar_top");
        }

        @Override
        public Item getItemDropped(int number, Random random, int number2) {
            return Item.getItemFromBlock(this);
        }
    }
}
