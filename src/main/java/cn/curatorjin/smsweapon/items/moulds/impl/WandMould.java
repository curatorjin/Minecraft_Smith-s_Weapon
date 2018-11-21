/*
 *
 * 文件名: WandMould.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/11  0:05
 *
 */
package cn.curatorjin.smsweapon.items.moulds.impl;

import cn.curatorjin.smsweapon.SmithsWeapon;
import cn.curatorjin.smsweapon.items.moulds.Mould;
import cn.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * 杖模具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class WandMould extends Item implements Mould
{

    public WandMould()
    {
        super();
        this.setUnlocalizedName("wandMould");
        this.setTextureName("smsweaponmod:wandMould");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

    @Override
    public Weapon synthetic(ItemStack... itemStack)
    {
        if (itemStack.length == 3)
        {
            return null;
        }
        return null;
    }
}
