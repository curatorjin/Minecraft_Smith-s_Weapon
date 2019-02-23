/*
 *
 * 文件名: SmithBlock.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/18  21:35
 *
 */
package io.github.curatorjin.smsweapon.blocks;

import io.github.curatorjin.smsweapon.anno.SmsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


/**
 * Block的模板类
 *
 * @author : 0newing
 * @version : 1.0
 */

@SmsBlock
public abstract class SmithBlock extends Block
{

    public SmithBlock(Material material)
    {
        super(material);
    }

    /**
     * 获取实体对象(单例)
     *
     * @return 实例
     */
    public abstract SmithBlock getInstance();
}
