package io.github.curatorjin.smsweapon.utils;

import io.github.curatorjin.smsweapon.beans.Position;


/**
 * 计算坐标值
 * 使用方法:利用玩家的坐标值仰角偏角以及与目标的距离进行构造，
 * 该对象的XYZ坐标值属性即为目标对象的XYZ坐标
 *
 * @author 0newing
 */
public class PositionCaculator
{
    /**
     * 目标的X坐标
     */
    private Double posX;

    /**
     * 目标的Y坐标
     */
    private Double posY;

    /**
     * 目标的Z坐标
     */
    private Double posZ;

    /**
     * 距离 极坐标R
     */
    private Double length;

    /**
     * 原X坐标
     */
    private Double rawX;

    /**
     * 原Y坐标
     */
    private Double rawY;

    /**
     * 原Z坐标
     */
    private Double rawZ;

    /**
     * 水平偏角
     */
    private Double yaw;

    /**
     * 仰角
     */
    private Double pitch;

    /**
     * 构造方法
     *
     * @param length 与玩家的距离
     * @param position 玩家的坐标
     */
    public PositionCaculator(Double length, Position position)
    {
        this.length = length;
        this.pitch = position.getPitch() / 360 * 2 * Math.PI;
        this.yaw = position.getYaw() / 360 * 2 * Math.PI;
        this.rawX = position.getPosX();
        this.rawY = position.getPosY();
        this.rawZ = position.getPosZ();
        this.posX = rawX - length * Math.cos(this.pitch) * Math.sin(this.yaw);
        this.posY = rawY - length * Math.sin(this.pitch);
        this.posZ = rawZ + length * Math.cos(this.pitch) * Math.cos(this.yaw);
    }

    /**
     * 设置目标与玩家的距离
     *
     * @param length 与玩家的距离
     */
    public void setLength(Double length)
    {
        this.length = length;
        this.posX = rawX - length * Math.cos(pitch) * Math.sin(yaw);
        this.posY = rawY - length * Math.sin(pitch);
        this.posZ = rawZ + length * Math.cos(pitch) * Math.cos(yaw);
    }

    /**
     * 设置玩家的X坐标
     *
     * @param rawX 玩家的X坐标
     */
    public void setRawX(Double rawX)
    {
        this.rawX = rawX;
        this.posX = rawX - length * Math.cos(pitch) * Math.sin(yaw);

    }

    /**
     * 设置玩家的Y坐标
     *
     * @param rawY 玩家的Y坐标
     */
    public void setRawY(Double rawY)
    {
        this.rawY = rawY;
        this.posY = rawY - length * Math.sin(pitch);
    }

    /**
     * 设置玩家的Z坐标
     *
     * @param rawZ 玩家的Z坐标
     */
    public void setRawZ(Double rawZ)
    {
        this.rawZ = rawZ;
        this.posZ = rawZ + length * Math.cos(pitch) * Math.cos(yaw);
    }

    /**
     * 设置玩家的水平偏角
     *
     * @param yaw 水平偏角
     */
    public void setYaw(Float yaw)
    {
        this.yaw = yaw / 360 * 2 * Math.PI;
        this.posX = rawX - length * Math.cos(pitch) * Math.sin(this.yaw);
        this.posZ = rawZ + length * Math.cos(pitch) * Math.cos(this.yaw);
    }

    /**
     * 设置玩家的仰角
     *
     * @param pitch 仰角
     */
    public void setPitch(Float pitch)
    {
        this.pitch = pitch / 360 * 2 * Math.PI;
        this.posX = rawX - length * Math.cos(this.pitch) * Math.sin(yaw);
        this.posY = rawY - length * Math.sin(this.pitch);
        this.posZ = rawZ + length * Math.cos(this.pitch) * Math.cos(yaw);
    }

    public Double getPosX()
    {
        return posX;
    }

    public Double getPosY()
    {
        return posY;
    }

    public Double getPosZ()
    {
        return posZ;
    }
}
