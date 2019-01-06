/*
 *
 * 文件名: DaggerMould.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/11  0:04
 *
 */
package cn.curatorjin.smsweapon.items.moulds.impl;

import cn.curatorjin.smsweapon.SmithsWeapon;
import cn.curatorjin.smsweapon.anno.SmsMould;
import cn.curatorjin.smsweapon.items.moulds.Mould;
import cn.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * 匕首模具
 *
 * @author : 0newing
 * @version : 1.0
 */
@SmsMould
public class DaggerMould extends Item implements Mould
{

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
