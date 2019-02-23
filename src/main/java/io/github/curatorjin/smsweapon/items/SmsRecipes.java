/*
 *
 * 文件名: SmsRecipes.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/20  23:40
 *
 */
package io.github.curatorjin.smsweapon.items;

import io.github.curatorjin.smsweapon.blocks.FireBlock;
import io.github.curatorjin.smsweapon.items.materials.impl.FireDust;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;


/**
 * 配方总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsRecipes
{

    /**
     * 注册所有的合成公式
     */
    public static void registerSmsRecipes()
    {
        //冶炼公式
        GameRegistry.addSmelting(new FireBlock().getInstance(),
            new ItemStack(new FireDust().getInstance(), 1), 50f);
    }
}
