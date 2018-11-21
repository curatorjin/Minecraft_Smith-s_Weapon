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
import net.minecraft.block.Block;
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
     * Smith工作台
     */
    private static SmithTable SMITH_TABLE;

    public static SmithTable getSmithTable()
    {
        return SMITH_TABLE;
    }

    /**
     * 注册所有的机器、供主类调用
     */
    public static void registerSmsMachines()
    {
        //声明
        SMITH_TABLE = new SmithTable();

        //注册
        registerMachine(SMITH_TABLE);
    }

    /**
     * 注册机器
     *
     * @param machine 要注册的机器
     */
    private static void registerMachine(Item machine)
    {
        GameRegistry.registerItem(machine, machine.getUnlocalizedName().substring(5));
    }

    /**
     * 注册机器
     *
     * @param machine 要注册的机器
     */
    private static void registerMachine(Block machine)
    {
        GameRegistry.registerBlock(machine, machine.getUnlocalizedName().substring(5));
    }
}
