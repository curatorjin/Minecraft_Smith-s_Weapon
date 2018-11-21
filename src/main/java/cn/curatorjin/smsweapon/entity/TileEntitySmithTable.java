/*
 *
 * 文件名: TileEntitySmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  22:35
 *
 */
package cn.curatorjin.smsweapon.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;


/**
 * SmithTable的实体
 *
 * @author : 0newing
 * @version : 1.0
 */
public class TileEntitySmithTable extends TileEntity implements ISidedInventory
{

    /**
     * 某个面可以访问到的物品槽索引数组
     *
     * @param side 访问的面
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        return new int[0];
    }

    /**
     * 判断是否可以从某个面向某个物品槽自动输入(漏斗)
     * 给定的物品
     *
     * @param slot 物品槽
     * @param itemStack 物品
     * @param side 面
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side)
    {
        return false;
    }

    /**
     * 判断实体的某一个面是否可以用指定的物品槽输出指定的物品
     *
     * @param slot 物品槽
     * @param itemStack 物品
     * @param side 面
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side)
    {
        return false;
    }

    /**
     * 物品栏中包含的物品槽数目(容量)
     */
    @Override
    public int getSizeInventory()
    {
        return 0;
    }

    /**
     * 某个物品槽上的物品
     *
     * @param index 物品槽索引
     */
    @Override
    public ItemStack getStackInSlot(int index)
    {
        return null;
    }

    /**
     * 将某个物品槽内的物品移除掉一部分并返回
     *
     * @param slot 物品槽
     * @param number 数量
     */
    @Override
    public ItemStack decrStackSize(int slot, int number)
    {
        return null;
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
     * @param slot 物品槽
     * @param itemStack 指定物品
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {

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
        return 0;
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
     * @param slot 物品槽
     * @param itemStack 物品
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return false;
    }
}
