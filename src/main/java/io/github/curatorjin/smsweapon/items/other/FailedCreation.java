/*
 *
 * 文件名: FailedCreation.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/10  23:53
 *
 */
package io.github.curatorjin.smsweapon.items.other;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import io.github.curatorjin.smsweapon.items.SmithItem;


/**
 * 失败作
 *
 * @author : 0newing
 * @version : 1.0
 */

public class FailedCreation extends SmithItem
{

    /**
     * 本类实例对象
     */
    private static FailedCreation INSTANCE;

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
            INSTANCE = new FailedCreation();
        }
        return INSTANCE;
    }

    public FailedCreation()
    {
        super();
        this.setUnlocalizedName("failedCreation");
        this.setTextureName("smsweaponmod:failedCreation");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }
}
