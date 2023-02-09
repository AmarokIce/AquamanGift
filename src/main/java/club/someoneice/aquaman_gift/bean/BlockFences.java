package club.someoneice.aquaman_gift.bean;

import club.someoneice.aquaman_gift.Modinfo;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import project.studio.manametalmod.blocks.BlockFenceM3;
import project.studio.manametalmod.newmc.BlockFenceGateBase;
import project.studio.manametalmod.produce.fishing.FishingCore;

import java.util.List;
import java.util.Random;

public class BlockFences extends BlockFenceM3 {
    private String name;
    private Block block;
    public BlockFences(String name, Block block) {
        super(name, Material.rock);
        this.setBlockName(name);
        this.block = block;
        this.name = name;
        this.blockHardness = 1.0F;
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(Modinfo.AG_TAB);

        GameRegistry.registerBlock(this, name);
        GameRegistry.addRecipe(new ItemStack(this, 2), "#S#", "#S#", 'S', FishingCore.oceanItem, '#', block);

        Block blockGate = new BlockFenceGate(block);
        GameRegistry.addRecipe(new ItemStack(blockGate), "S#S", "S#S", 'S', FishingCore.oceanItem, '#', block);
    }

    @Override
    public Item getItemDropped(int number, Random random, int number2) {
        return Item.getItemFromBlock(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int data) {
        return this.block.getIcon(side, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    public class BlockFenceGate extends BlockFenceGateBase {
        public BlockFenceGate(Block block) {
            super(block, 0);
            this.setBlockName(name + "_gate");
            this.blockHardness = 1.0F;
            this.setHarvestLevel("pickaxe", 2);
            this.setCreativeTab(Modinfo.AG_TAB);
            GameRegistry.registerBlock(this, name + "_gate");
        }

        @Override
        public Item getItemDropped(int number, Random random, int number2) {
            return Item.getItemFromBlock(this);
        }
    }
}
