/*
 *
 * 文件名: AxeMould.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/11  0:00
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
 * 斧模具
 *
 * @author : 0newing
 * @version : 1.0
 */
@SmsMould
public class AxeMould extends SmithItem implements Mould
{

    /**
     * 本类实例对象
     */
    private static AxeMould INSTANCE;

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
            INSTANCE = new AxeMould();
        }
        return INSTANCE;
    }

    public AxeMould()
    {
        super();
        this.setUnlocalizedName("axeMould");
        this.setTextureName("smsweaponmod:axeMould");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

    @Override
    public Weapon synthetic(ItemStack... itemStack)
    {
        return null;
    }
}
