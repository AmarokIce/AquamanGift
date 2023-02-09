package club.someoneice.aquaman_gift.bean;

import club.someoneice.aquaman_gift.Modinfo;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import project.studio.manametalmod.blocks.BlockWallBase;

import java.util.Random;

public class BlockWall extends BlockWallBase {
    public BlockWall(String name, Block Block) {
        super(Block, 0, name);
        this.blockHardness = 1.0F;
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(Modinfo.AG_TAB);

        GameRegistry.registerBlock(this, name);
        GameRegistry.addRecipe(new ItemStack(this, 6), "###", "###", '#', new ItemStack(Block));

    }

    @Override
    public Item getItemDropped(int number, Random random, int number2) {
        return Item.getItemFromBlock(this);
    }
}
