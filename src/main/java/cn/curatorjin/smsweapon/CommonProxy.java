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
 * 公共代理类
 *
 * @author : 0newing
 * @version : 1.0
 */
public class CommonProxy implements IGuiHandler
{

    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param id     GUI的ID
     * @param player 开启GUI的玩家
     * @param world  当前世界
     * @param x      X坐标
     * @param y      Y坐标
     * @param z      Z坐标
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y,
                                      int z)
    {
        return new ContainerSmithTable(player.inventory,world,x,y,z);
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param id     GUI的ID
     * @param player 开启GUI的玩家
     * @param world  当前世界
     * @param x      X坐标
     * @param y      Y坐标
     * @param z      Z坐标
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y,
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
