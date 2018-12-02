/*
 *
 * 文件名: ContainerSmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  0:27
 *
 */
package cn.curatorjin.smsweapon.machines.smstable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
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
     *
     */
    private InventoryCrafting assemblyMatrix = new InventoryCrafting(this, 3, 3);

    /**
     *
     */
    private InventoryCrafting combineMatrix = new InventoryCrafting(this, 3, 3);

    /**
     * 输入物品栏
     */
    private IInventory tinkerInput = new SmithTableInput(this);

    /**
     * 结果物品栏
     */
    private IInventory tinkerResult = new InventoryCraftResult();

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
        addSlotToContainer(new Slot(this.tinkerInput, 0, 13, 35));
        addSlotToContainer(
            new SmithTableResultSlot(inventory.player, this.tinkerInput, this.smithCraftingMatrix,
                this.assemblyMatrix, this.tinkerResult, 0, 147, 35));
        for (int invX = 0; invX < 3; invX++)
        {
            for (int invY = 0; invY < 3; invY++)
            {
                addSlotToContainer(new SmithTableAssembly(inventory.player, this.tinkerInput,
                    this.smithCraftingMatrix, this.assemblyMatrix, invY + invX * 3,
                    300000 + invY * 18, 17 + invX * 18));
            }
        }

        for (int invX = 0; invX < 3; invX++)
        {
            for (int invY = 0; invY < 3; invY++)
            {
                addSlotToContainer(new SmithTableAssembly(inventory.player, this.tinkerInput,
                    this.assemblyMatrix, this.smithCraftingMatrix, invY + invX * 3, 62 + invY * 18,
                    17 + invX * 18));
            }
        }
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

        onCraftMatrixChanged(this.assemblyMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     *
     * @param inventory
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventory)
    {
        int i;
        if (inventory == this.tinkerInput)
        {
            ItemStack inputStack = this.tinkerInput.getStackInSlot(0);

        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }

}
