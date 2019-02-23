/*
 *
 * 文件名: DaggerMould.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/11  0:04
 *
 */
package io.github.curatorjin.smsweapon.items.moulds.impl;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import io.github.curatorjin.smsweapon.anno.SmsMould;
import io.github.curatorjin.smsweapon.items.SmithItem;
import io.github.curatorjin.smsweapon.items.moulds.Mould;
import io.github.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.item.ItemStack;


/**
 * 匕首模具
 *
 * @author : 0newing
 * @version : 1.0
 */
@SmsMould
public class DaggerMould extends SmithItem implements Mould
{

    /**
     * 实例对象
     */
    private static DaggerMould INSTANCE;

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
            INSTANCE = new DaggerMould();
        }
        return INSTANCE;
    }

    public DaggerMould()
    {
        super();
        this.setUnlocalizedName("daggerMould");
        this.setTextureName("smsweaponmod:daggerMould");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

    @Override
    public Weapon synthetic(ItemStack... itemStack)
    {
        return null;
    }
}
