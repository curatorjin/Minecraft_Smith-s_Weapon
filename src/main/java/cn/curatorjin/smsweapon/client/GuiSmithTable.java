/*
 *
 * 文件名: GuiSmithTable.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  17:02
 *
 */
package cn.curatorjin.smsweapon.client;

import cn.curatorjin.smsweapon.machines.smstable.SmithTableContainer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;


/**
 * 工作台GUI类
 *
 * @author : 0newing
 * @version : 1.0
 */
public class GuiSmithTable extends GuiContainer
{

    /**
     * 材质保存位置
     */
    private static final ResourceLocation SMSTABLE_TEXTURE = new ResourceLocation(
        "smsweaponmod:textures/gui/smstable.png");

    /**
     * 构造方法
     *
     * @param container 工作台容器
     */
    public GuiSmithTable(Container container)
    {
        super(container);
    }

    /**
     * 绘制前图层
     *
     * @param var1 变量一
     * @param var2 变量二
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int var1, int var2)
    {
        this.fontRendererObj.drawString("Smith工作台", 8, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8,
            this.guiTop - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_,
                                                   int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(SMSTABLE_TEXTURE);
        int frameX = (this.width - this.xSize) / 2;
        int frameY = (this.height - this.ySize) / 2;
        drawTexturedModalRect(frameX, frameY, 0, 0, this.xSize, this.ySize);

        SmithTableContainer smsContainer = (SmithTableContainer)this.inventorySlots;

        RenderHelper.enableGUIStandardItemLighting();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.guiLeft, this.guiTop, 0.0F);

        for (int i = 0; i < 2; i++)
        {
            Slot uncrafting = smsContainer.getSlot(i);
            Slot assembly = smsContainer.getSlot(i);

            if (uncrafting.getStack() != null)
            {
                drawSlotAsBackground(uncrafting, assembly);
            }
        }
        GL11.glPopMatrix();

        FontRenderer fontRenderer = this.mc.standardGalacticFontRenderer;
        RenderHelper.disableStandardItemLighting();

    }

    /**
     * @param backgroundSlot 界面背景
     * @param appearSlot     显示的物品栏
     */
    private void drawSlotAsBackground(Slot backgroundSlot, Slot appearSlot)
    {
        int screenX = appearSlot.xDisplayPosition;
        int screenY = appearSlot.yDisplayPosition;
        ItemStack itemStackToRender = backgroundSlot.getStack();
        this.zLevel = 50.0F;

        GL11.glDisable(2896);
        GL11.glDisable(2929);
        Gui.drawRect(screenX, screenY, screenX + 128, screenY + 16, -1618244725);
        GL11.glEnable(2896);
        GL11.glEnable(2929);

        this.zLevel = 0.0F;
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
    }
}
