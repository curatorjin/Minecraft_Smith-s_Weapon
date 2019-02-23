/*
 *
 * 文件名: SmithTableTEntity.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  22:35
 *
 */
package io.github.curatorjin.smsweapon.entity.tile.impl;

import io.github.curatorjin.smsweapon.beans.BlockSide;
import io.github.curatorjin.smsweapon.beans.SmithTableSlotType;
import io.github.curatorjin.smsweapon.entity.tile.SmithTileEntity;
import io.github.curatorjin.smsweapon.items.weapons.impl.sword.FireSword;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;


/**
 * SmithTable的实体
 *
 * @author : 0newing
 * @version : 1.0
 */

public class SmithTableTEntity extends SmithTileEntity implements ISidedInventory
{

    /**
     * 实例
     */
    private static SmithTableTEntity INSTANCE;

    /**
     * 实体的物品栏
     */
    private ItemStack[] smithTableItems = new ItemStack[5];

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
        return this.smithTableItems[index];
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
        this.smithTableItems[slot] = itemStack;

        if (null != itemStack && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        if (isCraftable())
        {
            ItemStack item = handleCraft();
            for (int i = 0; i < this.smithTableItems.length; i++)
            {
                this.smithTableItems[i] = null;
            }
            this.smithTableItems[SmithTableSlotType.MOULD.getIndex()] = item;
        }
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
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this &&
               player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D,
                   (double)this.zCoord + 0.5D) <= 64.0D;
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
     * 获取当前实例
     *
     * @return 当前实例
     */
    @Override
    public SmithTableTEntity getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new SmithTableTEntity();
        }
        return INSTANCE;
    }

    /**
     * 获取实体ID
     *
     * @return 实体ID
     */
    @Override
    public String getID()
    {
        return "SmithTableTEntity";
    }

    /**
     * 判断是否可以合成武器
     *
     * @return 判断结果
     */
    private boolean isCraftable()
    {
        for (ItemStack item :
            smithTableItems)
        {
            if (null == item)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 处理物品
     *
     * @return 结果武器
     */
    private ItemStack handleCraft()
    {
        return new ItemStack(new FireSword().getInstance(), 1);
    }

}
