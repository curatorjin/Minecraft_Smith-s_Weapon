/*
 *
 * 文件名: SmsBlocks.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  11:54
 *
 */
package cn.curatorjin.smsweapon.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;


/**
 * 方块的总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsBlocks
{
    /**
     * 烈焰岩
     */
    private static FireBlock FIRE_BLOCK;

    /**
     * 注册所有物品，供主类调用
     */
    public static void registerBlocks()
    {
        //创建实例
        FIRE_BLOCK = new FireBlock();

        //注册实例
        registerSmsBlock(FIRE_BLOCK);
    }

    /**
     * 注册方块
     *
     * @param block 要注册的方块
     */
    private static void registerSmsBlock(Block block)
    {
        GameRegistry.registerBlock(block,block.getUnlocalizedName().substring(5));
    }

    public static FireBlock getFireBlock()
    {
        return FIRE_BLOCK;
    }
}
