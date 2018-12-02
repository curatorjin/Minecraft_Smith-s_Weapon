/*
 *
 * 文件名: SmithTableCrafting.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  15:10
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableCrafting implements IInventory
{
    /**
     *
     */
    private ItemStack[] contents = new ItemStack[9];

    /**
     *
     */
    private int numberOfInputItems;

    /**
     *
     */
    private int uncraftingCost;

    /**
     *
     */
    private int recraftingCost;

    public SmithTableCrafting(ContainerSmithTable containerSmithTable)
    {

    }

    /**
     * 物品槽数量
     */
    @Override
    public int getSizeInventory()
    {
        return 9;
    }

    /**
     * 获取指定索引处的物品
     *
     * @param index 物品槽索引
     */
    @Override
    public ItemStack getStackInSlot(int index)
    {
        return this.contents[index];
    }

    /**
     * 从指定的物品槽中移除至指定数量的物品，并将其返回
     *
     * @param index 指定物品槽索引
     * @param num   物品数量
     */
    @Override
    public ItemStack decrStackSize(int index, int num)
    {
        if (this.contents[index] != null)
        {
            if (this.contents[index].stackSize <= num)
            {
                ItemStack takenStack = this.contents[index];
                this.contents[index] = null;
                return takenStack;
            }
            ItemStack takenStack = this.contents[index].splitStack(num);
            if (this.contents[index].stackSize == 0)
            {
                this.contents[index] = null;
            }
            return takenStack;
        }
        return null;
    }

    /**
     * 当GUI关闭时对每一个物品槽的处理
     *
     * @param index 物品槽索引
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        if (this.contents[index] != null)
        {
            ItemStack drop = this.contents[index];
            this.contents[index] = null;
            return drop;
        }
        return null;
    }

    /**
     * 将指定的物品槽设为指定的物品
     *
     * @param index     指定的物品槽索引
     * @param itemStack 指定的物品
     */
    @Override
    public void setInventorySlotContents(int index, ItemStack itemStack)
    {
        this.contents[index] = itemStack;
        if ((itemStack != null) && (itemStack.stackSize > getInventoryStackLimit()))
        {
            itemStack.stackSize = getInventoryStackLimit();
        }
        markDirty();
    }

    /**
     * 物品栏名称
     */
    @Override
    public String getInventoryName()
    {
        return "SmithCrafting";
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
     * 物品槽最大容量
     */
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    @Override
    public void markDirty()
    {

    }

    /**
     * 判断是否被玩家使用
     *
     * @param player
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return true;
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
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     *
     * @param p_94041_1_
     * @param p_94041_2_
     */
    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return false;
    }
}
