/*
 *
 * 文件名: BlockSide.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/22  23:56
 *
 */
package io.github.curatorjin.smsweapon.beans;

/**
 * 方块的某个面
 *
 * @author : 0newing
 * @version : 1.0
 */
public enum BlockSide
{
    /**
     * 底部
     */
    BOTTOM(0),

    /**
     * 顶部
     */
    TOP(1),

    /**
     * 朝西面
     */
    WEST(2),

    /**
     * 朝东面
     */
    EAST(3),

    /**
     * 朝南面
     */
    SOUTH(4),

    /**
     * 朝北面
     */
    NORTH(5);

    /**
     * 对应的side的整数值
     */
    private int code;

    public int getCode()
    {
        return code;
    }

    BlockSide(int code)
    {
        this.code = code;
    }
}
