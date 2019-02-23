/*
 *
 * 文件名: SmithTableSlotType.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/22  23:33
 *
 */
package io.github.curatorjin.smsweapon.beans;

/**
 * Smith工作台物品槽
 *
 * @author : 0newing
 * @version : 1.0
 */
public enum SmithTableSlotType
{
    /**
     * 一号材料位
     */
    FIRST_MATERIAL(0),

    /**
     * 二号材料位
     */
    SECEND_MATERIAL(1),

    /**
     * 三号材料位
     */
    THIRD_MATERIAL(2),

    /**
     * 模具位
     */
    MOULD(3),

    /**
     * 燃料位
     */
    FLUE(4);

    /**
     * 对应的索引
     */
    private int index;

    SmithTableSlotType(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }
}


