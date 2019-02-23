/*
 *
 * 文件名: SmsEntities.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/23  23:39
 *
 */
package io.github.curatorjin.smsweapon.entity;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import io.github.curatorjin.smsweapon.anno.SmsEntity;
import io.github.curatorjin.smsweapon.entity.creature.SmithEntity;
import io.github.curatorjin.smsweapon.entity.tile.SmithTileEntity;
import io.github.curatorjin.smsweapon.utils.PackageScanner;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * 实体的总类、注册工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsEntities
{
    /**
     * 实体对应的包路径
     */
    private static final String PACKAGE_PATH = "io.github.curatorjin.smsweapon.entity";

    /**
     * 默认交互范围
     */
    public static final int DEFAULT_TRACK_RANGE = 64;

    /**
     * 注册所有的实体
     */
    public static void registerAllEntities()
    {
        List<Class> list = new ArrayList<Class>();
        PackageScanner.getAllClasses(list, PACKAGE_PATH);
        for (Class<?> c : list)
        {
            try
            {
                Annotation tag = c.getAnnotation(SmsEntity.class);
                if (tag == null)
                {
                    continue;
                }
                Method m = c.getDeclaredMethod("getInstance");
                Object object = m.invoke(c.newInstance());
                if (object instanceof SmithTileEntity)
                {
                    registerEntity((SmithTileEntity)object);
                }
                if (object instanceof SmithEntity)
                {
                    registerEntity((SmithEntity)object);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    /**
     * 注册实体TileEntity
     *
     * @param entity 要注册的实体
     */
    private static void registerEntity(SmithTileEntity entity)
    {
        GameRegistry.registerTileEntity(entity.getClass(), entity.getID());
    }

    /**
     * 注册实体Entity
     *
     * @param entity 要注册的实体
     */
    private static void registerEntity(SmithEntity entity)
    {
        EntityRegistry.registerModEntity(entity.getClass(), entity.getName(), entity.getID(),
            SmithsWeapon.getINSTANCE(), entity.getTrackRange(), entity.getUpdateFrequency(),
            entity.sendsVelocityUpdates());
    }
}
