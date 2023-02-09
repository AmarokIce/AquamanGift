package club.someoneice.aquaman_gift.bean;

import club.someoneice.aquaman_gift.Modinfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import project.studio.manametalmod.blocks.BlockStairsBase;

import java.util.Random;

public class BlockStair extends BlockStairsBase {

    public BlockStair(String name, Block block) {
        super(block, 0, name);

        this.blockHardness = 1.0F;
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(Modinfo.AG_TAB);

        GameRegistry.registerBlock(this, name);
        GameRegistry.addRecipe(new ItemStack(this, 4), "#  ", "## ", "###", '#', new ItemStack(block));
        GameRegistry.addRecipe(new ItemStack(this, 4), "  #", " ##", "###", '#', new ItemStack(block));
    }

    @Override
    public Item getItemDropped(int number, Random random, int number2) {
        return Item.getItemFromBlock(this);
    }
}
