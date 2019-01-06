/*
 *
 * 文件名: SmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  1:30
 *
 */
package cn.curatorjin.smsweapon.machines;

import cn.curatorjin.smsweapon.SmithsWeapon;
import cn.curatorjin.smsweapon.entity.tile.impl.SmithTableTEntity;
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
public class SmithTable extends Block implements ITileEntityProvider
{

    /**
     * 顶部材质
     */
    private static IIcon TINKER_TOP;

    /**
     * 侧面材质
     */
    private static IIcon TINKER_SIDE;

    SmithTable()
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
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     *
     * @param world    世界对象
     * @param x        X坐标
     * @param y        Y坐标
     * @param z        Z坐标
     * @param side     右键方块的面
     * @param hitX     右键点击的X坐标
     * @param hitY     右键点击的Y坐标
     * @param hitZ     右键点击的Z坐标
     * @param metaData 方块MetaData
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z,
                             int side, float hitX, float hitY,
                             float hitZ, int metaData)
    {
        return metaData;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param metaData
     */
    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return SmithTableTEntity.getInstance();
    }
}
