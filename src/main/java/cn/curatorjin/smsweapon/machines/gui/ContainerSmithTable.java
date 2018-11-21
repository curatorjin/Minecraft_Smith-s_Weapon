/*
 *
 * 文件名: ContainerSmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  0:27
 *
 */
package cn.curatorjin.smsweapon.machines.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;


/**
 * 工作台容器
 *
 * @author : 0newing
 * @version : 1.0
 */
public class ContainerSmithTable extends Container
{
    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return false;
    }
}
