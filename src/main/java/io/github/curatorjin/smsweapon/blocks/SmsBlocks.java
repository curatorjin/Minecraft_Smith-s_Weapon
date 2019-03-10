/*
 *
 * 文件名: SmsBlocks.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  11:54
 *
 */
package io.github.curatorjin.smsweapon.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.curatorjin.smsweapon.anno.SmsBlock;
import io.github.curatorjin.smsweapon.anno.SmsNoReg;
import net.minecraft.block.Block;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;


/**
 * 方块的总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsBlocks
{

    /**
     * 注册所有的方块
     *
     * @param list 类集合
     */
    public static void registerBlocks(List<Class> list)
    {
        for (Class<?> c : list)
        {
            try
            {
                Annotation tag = c.getAnnotation(SmsBlock.class);
                if (tag == null)
                {
                    continue;
                }
                tag = c.getAnnotation(SmsNoReg.class);
                if (tag != null)
                {
                    continue;
                }

                Method m = c.getDeclaredMethod("getInstance");
                Object object = m.invoke(c.newInstance());
                if (object instanceof Block)
                {
                    registerSmsBlock((Block)object);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 注册方块
     *
     * @param block 要注册的方块
     */
    private static void registerSmsBlock(Block block)
    {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    }

}
