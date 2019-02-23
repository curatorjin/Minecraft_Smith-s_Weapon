/*
 *
 * 文件名: SmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  1:30
 *
 */
package io.github.curatorjin.smsweapon.machines;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import io.github.curatorjin.smsweapon.anno.SmsMachine;
import io.github.curatorjin.smsweapon.blocks.SmithBlock;
import io.github.curatorjin.smsweapon.entity.tile.impl.SmithTableTEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;


/**
 * Smith工作台
 *
 * @author : 0newing
 * @version : 1.0
 */

@SmsMachine
public class SmithTable extends SmithBlock implements ITileEntityProvider
{

    /**
     * 本类实例对象
     */
    private static SmithTable INSTANCE;

    /**
     * 获取实体对象(单例)
     *
     * @return 实例
     */
    @Override
    public SmithBlock getInstance()
    {
        if (null == INSTANCE)
        {
            INSTANCE = new SmithTable();
        }
        return INSTANCE;
    }

    /**
     * 顶部材质
     */
    private static IIcon TINKER_TOP;

    /**
     * 侧面材质
     */
    private static IIcon TINKER_SIDE;

    public SmithTable()
    {
        super(Material.rock);

        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
        this.setBlockName("smithTable");
        this.setBlockTextureName("smsweaponmod:smithTable");

        setHardness(5.0f);
        setResistance(10.0f);
        setLightLevel(0f);
        setHarvestLevel("pickaxe", 1);
        setStepSound(Block.soundTypeStone);
    }

    /**
     * Gets the block's texture. Args: side, meta
     *
     * @param side ddd
     * @param meta sd
     */
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? TINKER_TOP : TINKER_SIDE;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iIconRegister)
    {
        TINKER_TOP = iIconRegister.registerIcon("smsweaponmod:smithTable_top");
        TINKER_SIDE = iIconRegister.registerIcon("smsweaponmod:smithTable_side");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y,
                                    int z, EntityPlayer player, int side,
                                    float blockX, float blockY, float blockZ)
    {
        player.openGui(SmithsWeapon.getINSTANCE(), 1, world, x, y, z);
        return true;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     *
     * @param item 物品
     * @param tabs 物品栏
     * @param list 列表
     */
    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
        list.add(new ItemStack(item, 1, 0));
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world    世界实例
     * @param metaData 方块MetaData
     */
    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new SmithTableTEntity();
    }
}
