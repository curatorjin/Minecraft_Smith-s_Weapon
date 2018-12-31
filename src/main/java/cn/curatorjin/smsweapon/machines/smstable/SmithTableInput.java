/*
 *
 * 文件名: SmithTableInput.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  14:24
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;


/**
 * 工作台输入物品槽
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableInput implements IInventory
{
    /**
     * 物品
     */
    private ItemStack[] stackInput = new ItemStack[5];

    /**
     * 容器
     */
    private ContainerSmithTable craftingContainer;

    public SmithTableInput(ContainerSmithTable containerSmithTable)
    {
        this.craftingContainer = containerSmithTable;
    }


    /**
     * 物品栏的物品槽数量
     */
    @Override
    public int getSizeInventory()
    {
        return 5;
    }

    /**
     * 获取指定索引处的物品
     *
     * @param index 物品索引
     */
    @Override
    public ItemStack getStackInSlot(int index)
    {
        return stackInput[index];
    }

    /**
     * 从指定的物品槽中移除至指定数量的物品，并将其返回
     *
     * @param index 指定物品槽索引
     * @param num 物品数量
     */
    @Override
    public ItemStack decrStackSize(int index, int num)
    {
        if (this.stackInput[index] != null)
        {
            if (this.stackInput[index].stackSize <= num)
            {
                ItemStack takenStack = this.stackInput[index];
                this.stackInput[index] = null;
                this.craftingContainer.onCraftMatrixChanged(this);
                return takenStack;
            }
            ItemStack takenStack = this.stackInput[index].splitStack(num);
            if (this.stackInput[index].stackSize == 0)
            {
                this.stackInput[index] = null;
            }
            this.craftingContainer.onCraftMatrixChanged(this);
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
//        if (this.stackInput[index] != null)
//        {
//            ItemStack drop = this.stackInput[index];
//            this.stackInput[index] = null;
//            return drop;
//        }

        return null;
    }

    /**
     * 将指定的物品槽设为指定的物品
     *
     * @param index 指定的物品槽索引
     * @param itemStack 指定的物品
     */
    @Override
    public void setInventorySlotContents(int index, ItemStack itemStack)
    {
        this.stackInput[index] = itemStack;
        this.craftingContainer.onCraftMatrixChanged(this);
    }

    /**
     * 返回物品栏名称
     */
    @Override
    public String getInventoryName()
    {
        return "Input";
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
     * 返回每个物品槽的最大容量
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
        this.craftingContainer.onCraftMatrixChanged(this);
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

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }
}
