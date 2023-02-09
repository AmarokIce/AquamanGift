package club.someoneice.aquaman_gift.bean;

import club.someoneice.aquaman_gift.Modinfo;
import club.someoneice.aquaman_gift.Util;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockBase extends Block {
    public BlockBase(String name) {
        super(Material.rock);
        this.textureName = Util.getTexturesName(name);
        this.setBlockName(name);
        this.blockHardness = 1.0F;
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(Modinfo.AG_TAB);
        GameRegistry.registerBlock(this, name);
    }

    @Override
    public Item getItemDropped(int number, Random random, int number2) {
        return Item.getItemFromBlock(this);
    }
}
