/*
 *
 * 文件名: SmithTableAssembly.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  16:29
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableAssembly extends Slot
{
    public SmithTableAssembly(EntityPlayer par1EntityPlayer, IInventory inputSlot,
                              IInventory assemblyMatrix, IInventory uncraftingMatrix, int slotNum,
                              int x, int y)
    {
        super(assemblyMatrix, slotNum, x, y);
    }
}
