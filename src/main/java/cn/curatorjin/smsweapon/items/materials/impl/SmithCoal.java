/*
 *
 * 文件名: SmithCoal.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/13  22:23
 *
 */
package cn.curatorjin.smsweapon.items.materials.impl;

import cn.curatorjin.smsweapon.SmithsWeapon;
import cn.curatorjin.smsweapon.anno.SmsFlue;
import cn.curatorjin.smsweapon.items.SmithItem;

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
