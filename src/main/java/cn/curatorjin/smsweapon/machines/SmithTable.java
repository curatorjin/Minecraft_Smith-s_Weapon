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
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


/**
 * Smith工作台
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTable extends Block
{

    public SmithTable()
    {
        super(Material.iron);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y,
                                    int z, EntityPlayer player, int p_149727_6_,
                                    float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        player.openGui(SmithsWeapon.getINSTANCE(),1,world,x,y,z);
        return true;
    }
}
