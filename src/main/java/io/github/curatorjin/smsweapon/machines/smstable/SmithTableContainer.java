/*
 *
 * 文件名: SmithTableContainer.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  0:27
 *
 */
package io.github.curatorjin.smsweapon.machines.smstable;

import io.github.curatorjin.smsweapon.beans.SmithTableSlotType;
import io.github.curatorjin.smsweapon.entity.tile.impl.SmithTableTEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;


/**
 * 工作台容器
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmithTableContainer extends Container
{

    /**
     * 结果物品栏
     */
    private IInventory smithTableResult = new InventoryCraftResult();

    /**
     * 工作台实体
     */
    private SmithTableTEntity tileEntity;

    /**
     * 构造
     *
     * @param inventory 玩家物品
     */
    public SmithTableContainer(InventoryPlayer inventory, SmithTableTEntity smithTableTEntity)
    {
        this.tileEntity = smithTableTEntity;
        addSlotToContainer(
            new SmithTableCraftSlot(inventory.player, tileEntity,
                SmithTableSlotType.FIRST_MATERIAL.getIndex(), 53, 33));
        addSlotToContainer(
            new SmithTableCraftSlot(inventory.player, tileEntity,
                SmithTableSlotType.SECEND_MATERIAL.getIndex(), 80, 7));
        addSlotToContainer(
            new SmithTableCraftSlot(inventory.player, tileEntity,
                SmithTableSlotType.THIRD_MATERIAL.getIndex(), 107, 33));
        addSlotToContainer(
            new SmithTableCraftSlot(inventory.player, tileEntity,
                SmithTableSlotType.MOULD.getIndex(), 80, 33));
        addSlotToContainer(
            new SmithTableCraftSlot(inventory.player, tileEntity,
                SmithTableSlotType.FLUE.getIndex(), 80, 61));

        importPlayerInv(inventory);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.tileEntity.isUseableByPlayer(player);
    }

    /**
     * 将玩家背包中道具导入Container
     *
     * @param inventory 玩家物品栏
     */
    private void importPlayerInv(InventoryPlayer inventory)
    {
        for (int invX = 0; invX < 3; invX++)
        {
            for (int invY = 0; invY < 9; invY++)
            {
                addSlotToContainer(
                    new Slot(inventory, invY + invX * 9 + 9, 8 + invY * 18, 84 + invX * 18));
            }
        }

        for (int invX = 0; invX < 9; invX++)
        {
            addSlotToContainer(new Slot(inventory, invX, 8 + invX * 18, 142));
        }
    }

    /**
     * 当玩家Shift右键物品时触发
     *
     * @param player    玩家实例
     * @param slotIndex 物品槽索引
     * @return 返回物品
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotIndex == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (slotIndex != 1 && slotIndex != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (slotIndex < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (slotIndex < 39 &&
                         !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
