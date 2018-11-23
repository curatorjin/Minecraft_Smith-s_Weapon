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
import cn.curatorjin.smsweapon.entity.tile.impl.TileEntitySmithTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;


/**
 * Smith工作台
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTable extends BlockContainer
{

    SmithTable()
    {
        super(Material.iron);

        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
        this.setBlockName("smithTable");
        this.setBlockTextureName("smsweaponmod:smithTable");

        setHardness(5.0f);
        setResistance(10.0f);
        setLightLevel(0f);
        setHarvestLevel("pickaxe", 1);
        setStepSound(Block.soundTypeStone);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return null;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);

    }

    @Override
    public boolean onBlockActivated(World world, int x, int y,
                                    int z, EntityPlayer player, int side,
                                    float blockX, float blockY, float blockZ)
    {
        System.out.println(side);
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new TileEntitySmithTable();
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y,
                                         int z, int metaData)
    {
        super.onBlockDestroyedByPlayer(world, x, y, z, metaData);
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y,
                                            int z, Explosion explosion)
    {
        super.onBlockDestroyedByExplosion(world, x, y, z, explosion);
    }
}
