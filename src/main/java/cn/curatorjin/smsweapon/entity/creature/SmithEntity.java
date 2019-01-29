/*
 *
 * 文件名: SmithEntity.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/18  21:50
 *
 */
package cn.curatorjin.smsweapon.entity.creature;

import cn.curatorjin.smsweapon.anno.SmsEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;


/**
 * Entity模板类
 *
 * @author : 0newing
 * @version : 1.0
 */

@SmsEntity
public abstract class SmithEntity extends Entity
{
    /**
     * 构造方法
     *
     * @param world 生物所处的世界
     */
    public SmithEntity(World world)
    {
        super(world);
    }

    /**
     * 获取生物ID
     *
     * @return 生物ID
     */
    public abstract int getID();

    /**
     * @return 实体名
     */
    public abstract String getName();

    /**
     * 获取实体单例
     *
     * @return 实体单例对象
     */
    public abstract SmithEntity getInstance();

    /**
     * 获取交互范围
     *
     * @return 交互范围
     */
    public abstract int getTrackRange();

    /**
     * 获取更新频率
     *
     * @return 更新频率
     */
    public abstract int getUpdateFrequency();

    /**
     * 是否发送速度更新
     *
     * @return 是否发送速度更新
     */
    public abstract boolean sendsVelocityUpdates();
}
