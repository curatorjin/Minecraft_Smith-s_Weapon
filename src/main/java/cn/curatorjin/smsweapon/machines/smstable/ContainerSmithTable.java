/*
 *
 * 文件名: ContainerSmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  0:27
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import cn.curatorjin.smsweapon.beans.SmithTableSlotType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * 工作台容器
 *
 * @author : 0newing
 * @version : 1.0
 */
public class ContainerSmithTable extends Container
{

    /**
     * 世界实例
     */
    private World worldObj;

    /**
     * 物品栏
     */
    private SmithTableCrafting smithCraftingMatrix = new SmithTableCrafting(this);

    /**
     * 输入物品栏
     */
    private IInventory smithTableInput = new SmithTableInput(this);

    /**
     * 结果物品栏
     */
    private IInventory smithTableResult = new InventoryCraftResult();

    /**
     * 构造
     *
     * @param inventory 玩家物品
     * @param world     世界
     * @param x         坐标X
     * @param y         坐标Y
     * @param z         坐标Z
     */
    public ContainerSmithTable(InventoryPlayer inventory, World world, int x, int y, int z)
    {
        this.worldObj = world;
        addSlotToContainer(
            new Slot(this.smithTableInput, SmithTableSlotType.FIRST_MATERIAL.getIndex(), 53, 33));
        addSlotToContainer(
            new Slot(this.smithTableInput, SmithTableSlotType.SECEND_MATERIAL.getIndex(), 80, 7));
        addSlotToContainer(
            new Slot(this.smithTableInput, SmithTableSlotType.THIRD_MATERIAL.getIndex(), 107, 33));
        addSlotToContainer(
            new Slot(this.smithTableInput, SmithTableSlotType.MOULD.getIndex(), 80, 33));
        addSlotToContainer(
            new Slot(this.smithTableInput, SmithTableSlotType.FLUE.getIndex(), 80, 61));

        importPlayerInv(inventory);

        onCraftMatrixChanged(this.smithTableInput);
    }

    /**
     * 合成矩阵改变事件
     *
     * @param inventory 物品栏
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventory)
    {
        int i;
        if (inventory == this.smithTableInput)
        {
            ItemStack inputStack = this.smithTableInput.getStackInSlot(0);

        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
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
}
