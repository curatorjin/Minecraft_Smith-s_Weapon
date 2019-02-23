/*
 *
 * 文件名: SmithItem.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/18  21:27
 *
 */
package io.github.curatorjin.smsweapon.items;

import io.github.curatorjin.smsweapon.anno.SmsItem;
import net.minecraft.item.Item;


/**
 * 物品类的模板类
 *
 * @author : 0newing
 * @version : 1.0
 */

@SmsItem
public abstract class SmithItem extends Item
{
    /**
     * 获取实例
     *
     * @return 本身的实例对象(单例)
     */
    public abstract SmithItem getInstance();
}
