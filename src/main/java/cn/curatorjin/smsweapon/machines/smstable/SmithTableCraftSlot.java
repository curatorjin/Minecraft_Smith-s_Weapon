/*
 *
 * 文件名: SmithTableCraftSlot.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  15:44
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import cn.curatorjin.smsweapon.anno.SmsFlue;
import cn.curatorjin.smsweapon.anno.SmsMaterial;
import cn.curatorjin.smsweapon.anno.SmsMould;
import cn.curatorjin.smsweapon.beans.SmithTableSlotType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.lang.annotation.Annotation;


/**
 * 工作台的物品槽
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableCraftSlot extends Slot
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
     * 工作台是否在工作
     */
    private boolean workingState;

    /**
     * 工作台类型
     */
    private int slotType;

    /**
     * 构造
     *
     * @param player                玩家实例
     * @param smithTableCrafting    归属的工作台
     * @param slotNum               物品槽索引
     * @param x                     显示的X坐标
     * @param y                     显示的Y坐标
     */
    public SmithTableCraftSlot(EntityPlayer player, SmithTableCrafting smithTableCrafting,
                               int slotNum, int x, int y)
    {
        super(smithTableCrafting, slotNum, x, y);
        this.player = player;
        this.slotType = slotNum;
    }

    /**
     * 物品是否可以放入物品槽
     *
     * @param itemStack 待检查的物品
     */
    @Override
    public boolean isItemValid(ItemStack itemStack)
    {
        if (workingState)
        {
            return false;
        }
        if (SmithTableSlotType.FIRST_MATERIAL.getIndex() == slotType ||
            SmithTableSlotType.SECEND_MATERIAL.getIndex() == slotType ||
            SmithTableSlotType.THIRD_MATERIAL.getIndex() == slotType)
        {
            Item item = itemStack.getItem();
            Class clazz = item.getClass();
            Annotation annotation = clazz.getAnnotation(SmsMaterial.class);
            return !(null == annotation);
        }
        if (SmithTableSlotType.MOULD.getIndex() == slotType)
        {
            Item item = itemStack.getItem();
            Class clazz = item.getClass();
            Annotation annotation = clazz.getAnnotation(SmsMould.class);
            return !(null == annotation);
        }
        if (SmithTableSlotType.FLUE.getIndex() == slotType)
        {
            Item item = itemStack.getItem();
            Class clazz = item.getClass();
            Annotation annotation = clazz.getAnnotation(SmsFlue.class);
            return !(null == annotation);
        }
        return false;
    }

    /**
     * 物品槽内的物品是否可以被取出
     *
     * @param player 玩家
     */
    @Override
    public boolean canTakeStack(EntityPlayer player)
    {
        return !workingState;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        super.onPickupFromSlot(player, itemStack);
    }

    public EntityPlayer getPlayer()
    {
        return player;
    }

    public void setPlayer(EntityPlayer player)
    {
        this.player = player;
    }

    public IInventory getInputSlot()
    {
        return inputSlot;
    }

    public void setInputSlot(IInventory inputSlot)
    {
        this.inputSlot = inputSlot;
    }

    public boolean isWorkingState()
    {
        return workingState;
    }

    public void setWorkingState(boolean workingState)
    {
        this.workingState = workingState;
    }

    public void setSlotType(int slotType)
    {
        this.slotType = slotType;
    }

    public int getSlotType()
    {
        return slotType;
    }
}
