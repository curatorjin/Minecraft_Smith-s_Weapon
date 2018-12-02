/*
 *
 * 文件名: SmithTableResultSlot.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  15:31
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableResultSlot extends SlotCrafting
{
    /**
     *
     */
    private EntityPlayer player;

    /**
     *
     */
    private IInventory inputSlot;

    /**
     *
     */
    private SmithTableCrafting uncraftingMatrix;

    /**
     *
     */
    private InventoryCrafting assemblyMatrix;

    /**
     *
     */
    private IInventory resultSlot;

    /**
     * 构造
     *
     * @param player 玩家实例
     * @param input 输入
     * @param uncraftingMatrix
     * @param assemblyMatrix
     * @param result
     * @param slotIndex
     * @param x
     * @param y
     */
    public SmithTableResultSlot(EntityPlayer player, IInventory input, IInventory uncraftingMatrix,
                                IInventory assemblyMatrix, IInventory result, int slotIndex, int x,
                                int y)
    {
        super(player, assemblyMatrix, result, slotIndex, x, y);
        this.player = player;
        this.inputSlot = input;
        this.uncraftingMatrix = ((SmithTableCrafting)uncraftingMatrix);
        this.assemblyMatrix = ((InventoryCrafting)assemblyMatrix);
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        super.onPickupFromSlot(player, itemStack);
    }
}
