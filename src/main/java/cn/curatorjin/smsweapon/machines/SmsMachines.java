/*
 *
 * 文件名: SmsMachines.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  11:55
 *
 */
package cn.curatorjin.smsweapon.machines;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;


/**
 * 机器的总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsMachines
{

    /**
     * 注册所有的机器
     */
    public static void registerSmsMachines()
    {

    }

    /**
     * 注册机器
     *
     * @param machine 要注册的机器
     */
    private static void registerMachine(Item machine)
    {
        GameRegistry.registerItem(machine,machine.getUnlocalizedName().substring(5));
    }
}
