/*
 *
 * 文件名: HammerMould.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/11  0:03
 *
 */
package cn.curatorjin.smsweapon.items.moulds.impl;

import cn.curatorjin.smsweapon.SmithsWeapon;
import cn.curatorjin.smsweapon.anno.SmsMould;
import cn.curatorjin.smsweapon.items.SmithItem;
import cn.curatorjin.smsweapon.items.moulds.Mould;
import cn.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.item.ItemStack;


/**
 * 锤模具
 *
 * @author : 0newing
 * @version : 1.0
 */
@SmsMould
public class HammerMould extends SmithItem implements Mould
{

    /**
     * 实例对象
     */
    private static HammerMould INSTANCE;

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
            INSTANCE = new HammerMould();
        }
        return INSTANCE;
    }

    public HammerMould()
    {
        super();
        this.setUnlocalizedName("hammerMould");
        this.setTextureName("smsweaponmod:hammerMould");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

    @Override
    public Weapon synthetic(ItemStack... itemStack)
    {
        return null;
    }
}
