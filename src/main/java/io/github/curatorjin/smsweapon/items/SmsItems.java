/*
 *
 * 文件名: SmsItems.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  11:55
 *
 */
package io.github.curatorjin.smsweapon.items;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.curatorjin.smsweapon.anno.SmsItem;
import io.github.curatorjin.smsweapon.anno.SmsNoReg;
import net.minecraft.item.Item;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;


/**
 * 物品的总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsItems
{

    /**
     * 注册所有物品
     *
     * @param list 类集合
     */
    public static void registerSmsItems(List<Class> list)
    {
        for (Class<?> c : list)
        {
            try
            {
                Annotation tag = c.getAnnotation(SmsItem.class);
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
                if (object instanceof Item)
                {
                    registerSmsItem((Item)object);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 注册物品
     *
     * @param item 要注册的物品
     */
    private static void registerSmsItem(Item item)
    {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }
}
