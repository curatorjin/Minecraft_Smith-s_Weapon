/*
 *
 * 文件名: SmsMachine.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  11:55
 *
 */
package io.github.curatorjin.smsweapon.machines;

import io.github.curatorjin.smsweapon.anno.SmsMachine;
import io.github.curatorjin.smsweapon.anno.SmsNoReg;
import io.github.curatorjin.smsweapon.utils.PackageScanner;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * 机器的总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsMachines
{

    /**
     * 机器对应的包路径
     */
    private static final String PACKAGE_PATH = "io.github.curatorjin.smsweapon.machines";

    /**
     * 注册所有的机器、供主类调用
     */
    public static void registerSmsMachines()
    {
        List<Class> list = new ArrayList<>();
        PackageScanner.getAllClasses(list, PACKAGE_PATH);
        for (Class<?> c : list)
        {
            try
            {
                Annotation tag = c.getAnnotation(SmsMachine.class);
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
                    registerMachine((Block)object);
                }
                if (object instanceof Item)
                {
                    registerMachine((Item)object);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
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
