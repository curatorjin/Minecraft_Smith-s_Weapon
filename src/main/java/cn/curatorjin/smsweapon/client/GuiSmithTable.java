/*
 *
 * 文件名: GuiSmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  17:02
 *
 */
package cn.curatorjin.smsweapon.client;

import cn.curatorjin.smsweapon.machines.smstable.ContainerSmithTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class GuiSmithTable extends GuiContainer
{

    /**
     * Constructor
     *
     * @param inventory
     * @param world
     * @param x
     * @param y
     * @param z
     */
    public GuiSmithTable(InventoryPlayer inventory, World world, int x, int y, int z)
    {
        super(new ContainerSmithTable(inventory, world, x, y, z));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
                                                   int p_146976_3_)
    {

    }

    /**
     * @param backgroundSlot as
     * @param appearSlot     wtf
     */
    private void drawSlotAsBackground(Slot backgroundSlot, Slot appearSlot)
    {

    }
}
