/*
 *
 * 文件名: SmithTableCraftSlot.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  15:44
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableCraftSlot extends Slot
{
    /**
     *
     */
    private EntityPlayer thePlayer;

    /**
     *
     */
    private IInventory inputSlot;

    /**
     *
     */
    private SmithTableCrafting craftingMatrix;

    /**
     *
     */
    private IInventory assemblyMatrix;

    /**
     * 构造
     *
     * @param player           玩家实例
     * @param inputSlot        输入
     * @param uncraftingMatrix
     * @param assemblyMatrix
     * @param slotNum
     * @param x
     * @param y
     */
    public SmithTableCraftSlot(EntityPlayer player, IInventory inputSlot,
                               SmithTableCrafting uncraftingMatrix,
                               IInventory assemblyMatrix, int slotNum, int x, int y)
    {
        super(uncraftingMatrix, slotNum, x, y);
        this.thePlayer = player;
        this.inputSlot = inputSlot;
        this.craftingMatrix = uncraftingMatrix;
        this.assemblyMatrix = assemblyMatrix;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     *
     * @param p_75214_1_
     */
    @Override
    public boolean isItemValid(ItemStack p_75214_1_)
    {
        return false;
    }

    /**
     * Return whether this slot's stack can be taken from this slot.
     *
     * @param player
     */
    @Override
    public boolean canTakeStack(EntityPlayer player)
    {
        for (int i = 0; i < this.assemblyMatrix.getSizeInventory(); i++)
        {
            if (this.assemblyMatrix.getStackInSlot(i) != null)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        super.onPickupFromSlot(player, itemStack);
    }
}
