/*
 *
 * 文件名: SmithTableTEntity.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  22:35
 *
 */
package cn.curatorjin.smsweapon.entity.tile.impl;

import cn.curatorjin.smsweapon.anno.SmsTileEntity;
import cn.curatorjin.smsweapon.beans.BlockSide;
import cn.curatorjin.smsweapon.beans.SmithTableSlotType;
import cn.curatorjin.smsweapon.entity.tile.SmithsTileEntity;
import cn.curatorjin.smsweapon.machines.smstable.SmithTableContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;


/**
 * SmithTable的实体
 *
 * @author : 0newing
 * @version : 1.0
 */
@SmsTileEntity
public class SmithTableTEntity extends SmithsTileEntity implements ISidedInventory
{

    /**
     * 实例
     */
    private static SmithTableTEntity INSTANCE;

    /**
     * 工作台容器
     */
    private SmithTableContainer container;

    /**
     * 某个面可以访问到的物品槽索引数组
     *
     * @param side 访问的面
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return new int[] {0, 1, 2, 3, 4};
    }

    /**
     * 判断是否可以从某个面向某个物品槽自动输入(漏斗)给定的物品
     *
     * @param slot      物品槽
     * @param itemStack 物品
     * @param side      面
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side)
    {
        if (side == BlockSide.BOTTOM.getCode())
        {
            return false;
        }
        return false;
    }

    /**
     * 判断实体的某一个面是否可以用指定的物品槽输出指定的物品
     *
     * @param slot      物品槽
     * @param itemStack 物品
     * @param side      面
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side)
    {
        return (side != BlockSide.TOP.getCode() && slot == SmithTableSlotType.MOULD.getIndex());
    }

    /**
     * 物品栏中包含的物品槽数目(容量)
     */
    @Override
    public int getSizeInventory()
    {
        return 5;
    }

    /**
     * 某个物品槽上的物品
     *
     * @param index 物品槽索引
     */
    @Override
    public ItemStack getStackInSlot(int index)
    {
        if (null == container)
        {
            return null;
        }
        return container.getSmithTableInput().getStackInSlot(index);
    }

    /**
     * 将某个物品槽内的物品移除掉一部分并返回
     *
     * @param slot   物品槽
     * @param number 数量
     */
    @Override
    public ItemStack decrStackSize(int slot, int number)
    {
        ItemStack itemStack = getStackInSlot(slot);
        int originSize = itemStack.stackSize;
        if (number > originSize)
        {
            number = itemStack.stackSize;
        }
        itemStack.stackSize = originSize - number;
        setInventorySlotContents(slot, itemStack);
        return new ItemStack(itemStack.getItem(), number);
    }

    /**
     * 当Container被关闭时对每一个slot进行的操作，返回值为物品掉落
     *
     * @param slot 物品槽
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        return null;
    }

    /**
     * 将指定的物品槽设为指定物品
     *
     * @param slot      物品槽
     * @param itemStack 指定物品
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        if (container == null)
        {
            return;
        }
        container.getSmithTableInput().setInventorySlotContents(slot, itemStack);
    }

    /**
     * 获取物品栏名称
     */
    @Override
    public String getInventoryName()
    {
        return null;
    }

    /**
     * 判断物品栏是否已被命名
     */
    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    /**
     * 物品槽的最大容量
     */
    @Override
    public int getInventoryStackLimit()
    {
        return 16;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     *
     * @param player 玩家实体
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return false;
    }

    @Override
    public void openInventory()
    {

    }

    @Override
    public void closeInventory()
    {

    }

    /**
     * 判断是否能无视容量向一个物品槽自动输入物品
     *
     * @param slot      物品槽
     * @param itemStack 物品
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return false;
    }

    /**
     * 获取ID
     *
     * @return 实体ID
     */
    @Override
    public String getID()
    {
        return "SmithTableEntity";
    }

    /**
     * 获取当前实例
     *
     * @return 当前实例
     */
    public static SmithTableTEntity getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SmithTableTEntity();
        }
        return INSTANCE;
    }

    /**
     * 获取工作台容器
     *
     * @param inventory 玩家物品栏
     * @return 容器对象
     */
    public SmithTableContainer getContainer(InventoryPlayer inventory)
    {
        if (null == container)
        {
            container = new SmithTableContainer(inventory);
        }
        return container;
    }
}
