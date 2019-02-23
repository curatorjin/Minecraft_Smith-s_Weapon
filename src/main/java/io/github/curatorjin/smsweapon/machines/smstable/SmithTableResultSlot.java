/*
 *
 * 文件名: SmithTableResultSlot.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  15:31
 *
 */
package io.github.curatorjin.smsweapon.machines.smstable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


/**
 * 工作台结果物品槽
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableResultSlot extends Slot
{
    /**
     * 玩家实体
     */
    private EntityPlayer player;

    /**
     * 输入物品槽
     */
    private IInventory inputSlot;

    /**
     * 结果物品槽
     */
    private IInventory resultSlot;

    /**
     * 构造
     *
     * @param player    玩家实例
     * @param input     输入物品槽
     * @param result    结果物品槽
     * @param slotIndex 物品槽索引
     * @param x         X坐标
     * @param y         Y坐标
     */
    public SmithTableResultSlot(EntityPlayer player, IInventory input,
                                IInventory result, int slotIndex, int x,
                                int y)
    {
        super(result, slotIndex, x, y);
        this.player = player;
        this.inputSlot = input;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        super.onPickupFromSlot(player, itemStack);
    }
}
