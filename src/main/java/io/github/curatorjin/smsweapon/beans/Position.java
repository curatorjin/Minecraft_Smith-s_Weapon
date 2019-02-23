/*
 *
 * 文件名: Position.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/3  18:53
 *
 */
package io.github.curatorjin.smsweapon.beans;

/**
 * 坐标
 *
 * @author : 0newing
 * @version : 1.0
 */
public class Position
{
    /**
     * X坐标
     */
    private Double posX;

    /**
     * Y坐标
     */
    private Double posY;

    /**
     * Z坐标
     */
    private Double posZ;

    /**
     * 水平偏角
     */
    private Float yaw;

    /**
     * 仰角
     */
    private Float pitch;

    public Position(){}

    public Position(Double posX, Double posY, Double posZ, Float yaw, Float pitch)
    {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Double getPosX()
    {
        return posX;
    }

    public void setPosX(Double posX)
    {
        this.posX = posX;
    }

    public Double getPosY()
    {
        return posY;
    }

    public void setPosY(Double posY)
    {
        this.posY = posY;
    }

    public Double getPosZ()
    {
        return posZ;
    }

    public void setPosZ(Double posZ)
    {
        this.posZ = posZ;
    }

    public Float getYaw()
    {
        return yaw;
    }

    public void setYaw(Float yaw)
    {
        this.yaw = yaw;
    }

    public Float getPitch()
    {
        return pitch;
    }

    public void setPitch(Float pitch)
    {
        this.pitch = pitch;
    }

    @Override
    public String toString()
    {
        return "Position{" +
               "posX=" + posX +
               ", posY=" + posY +
               ", posZ=" + posZ +
               ", yaw=" + yaw +
               ", pitch=" + pitch +
               '}';
    }
}
