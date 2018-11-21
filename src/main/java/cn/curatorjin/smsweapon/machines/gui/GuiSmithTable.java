/*
 *
 * 文件名: GuiSmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/21  0:25
 *
 */
package cn.curatorjin.smsweapon.machines.gui;

import net.minecraft.client.gui.inventory.GuiContainer;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : ${VERSION}
 */
public class GuiSmithTable extends GuiContainer
{

    public GuiSmithTable()
    {
        super(new ContainerSmithTable());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
                                                   int p_146976_3_)
    {

    }
}
