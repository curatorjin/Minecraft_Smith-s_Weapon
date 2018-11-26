/*
 *
 * 文件名: SmithsTileEntity.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/24  0:24
 *
 */
package cn.curatorjin.smsweapon.entity.tile;

import net.minecraft.tileentity.TileEntity;


/**
 * TileEntity转换接口
 *
 * @author : 0newing
 * @version : 1.0
 */
public abstract class SmithsTileEntity extends TileEntity
{
    /**
     * 获取ID
     *
     * @return 实体ID
     */
    public abstract String getID();
}
