/*
 *
 * 文件名: SmsEntity.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/23  23:39
 *
 */
package cn.curatorjin.smsweapon.entity;

import cn.curatorjin.smsweapon.entity.tile.SmithsTileEntity;
import cn.curatorjin.smsweapon.entity.tile.impl.SmithTableTEntity;
import cpw.mods.fml.common.registry.GameRegistry;


/**
 * 实体的总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsEntity
{
    /**
     * 默认交互范围
     */
    public static final int DEFAULT_TRACK_RANGE = 64;

    /**
     * 工作台实体
     */
    private static SmithTableTEntity SMITH_TABLE_TENTITY = SmithTableTEntity.getInstance();

    public static SmithTableTEntity getSmithTableTentity()
    {
        return SMITH_TABLE_TENTITY;
    }

    /**
     * 注册所有的实体
     */
    public static void registerAllEntities()
    {
        registerEntity(SmithTableTEntity.getInstance());
    }

    /**
     * 注册实体TileEntity
     *
     * @param entity 要注册的实体
     */
    private static void registerEntity(SmithsTileEntity entity)
    {
        GameRegistry.registerTileEntity(entity.getClass(), entity.getID());
    }
}
