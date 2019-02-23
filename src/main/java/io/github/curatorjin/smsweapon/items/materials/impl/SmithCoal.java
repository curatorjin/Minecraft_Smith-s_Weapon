/*
 *
 * 文件名: SmithCoal.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/13  22:23
 *
 */
package io.github.curatorjin.smsweapon.items.materials.impl;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import io.github.curatorjin.smsweapon.anno.SmsFlue;
import io.github.curatorjin.smsweapon.items.SmithItem;

/**
 * 物品：Smith煤
 *
 * @author : 0newing
 * @version : 1.0
 */
@SmsFlue
public class SmithCoal extends SmithItem
{

    /**
     * 本身实例对象
     */
    private static SmithCoal INSTANCE;

    /**
     * 获取实例
     *
     * @return 本身的实例对象(单例)
     */
    @Override
    public SmithItem getInstance()
    {
        if (null == INSTANCE)
        {
            INSTANCE = new SmithCoal();
        }
        return INSTANCE;
    }


    public SmithCoal()
    {
        super();
        this.setUnlocalizedName("smithCoal");
        this.setTextureName("smsweaponmod:smithCoal");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }


}
