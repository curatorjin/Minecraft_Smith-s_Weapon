/*
 *
 * 文件名: SmithTileEntity.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/18  21:47
 *
 */
package cn.curatorjin.smsweapon.entity.tile;

import cn.curatorjin.smsweapon.anno.SmsEntity;
import net.minecraft.tileentity.TileEntity;


/**
 * TileEntity模板类
 *
 * @author : 0newing
 * @version : 1.0
 */

@SmsEntity
public abstract class SmithTileEntity extends TileEntity
{
    /**
     * 获取本类实例
     *
     * @return 单例实例
     */
    public abstract SmithTileEntity getInstance();

    /**
     * 获取实体ID
     *
     * @return 实体ID
     */
    public abstract String getID();

}
