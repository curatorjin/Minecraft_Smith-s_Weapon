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
import cn.curatorjin.smsweapon.items.moulds.Mould;
import cn.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * 锤模具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class HammerMould extends Item implements Mould
{
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
