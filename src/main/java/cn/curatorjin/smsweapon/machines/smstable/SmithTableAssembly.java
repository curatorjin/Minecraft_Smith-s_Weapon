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
 * 工作台装配
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableAssembly extends Slot
{

    /**
     * 构造方法
     *
     * @param par1EntityPlayer 玩家实体
     * @param inputSlot 输入物品槽
     * @param assemblyMatrix 矩阵
     * @param uncraftingMatrix 分解矩阵
     * @param slotNum 物品槽数
     * @param x X坐标
     * @param y Y坐标
     */
    public SmithTableAssembly(EntityPlayer par1EntityPlayer, IInventory inputSlot,
                              IInventory assemblyMatrix, IInventory uncraftingMatrix, int slotNum,
                              int x, int y)
    {
        super(assemblyMatrix, slotNum, x, y);
    }
}
