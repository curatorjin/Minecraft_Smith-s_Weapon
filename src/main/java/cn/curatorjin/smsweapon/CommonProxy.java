/*
 *
 * 文件名: CommonProxy.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  16:59
 *
 */
package cn.curatorjin.smsweapon;

import cn.curatorjin.smsweapon.client.GuiSmithTable;
import cn.curatorjin.smsweapon.machines.smstable.ContainerSmithTable;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class CommonProxy implements IGuiHandler
{

    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y,
                                      int z)
    {
        return new ContainerSmithTable(player.inventory,world,x,y,z);
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y,
                                      int z)
    {
        return new GuiSmithTable(player.inventory,world,x,y,z);
    }

    /**
     * 预加载
     */
    public void init()
    {
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("加载完成");
    }
}
