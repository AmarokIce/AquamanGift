package club.someoneice.aquaman_gift.bean;

import club.someoneice.aquaman_gift.Modinfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import project.studio.manametalmod.blocks.BlockSlabBase;

import java.util.Random;

public class BlockSlab extends BlockSlabBase {
    public BlockSlab(String name, Block modelBlock) {
        super(name, Material.rock, modelBlock);

        this.blockHardness = 1.0F;
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(Modinfo.AG_TAB);

        GameRegistry.registerBlock(this, name);
        GameRegistry.addRecipe(new ItemStack(this, 6), "###", '#', new ItemStack(modelBlock));
    }

    @Override
    public Item getItemDropped(int number, Random random, int number2) {
        return Item.getItemFromBlock(this);
    }
}
