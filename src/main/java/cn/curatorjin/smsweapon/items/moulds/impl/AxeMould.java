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
import cn.curatorjin.smsweapon.items.moulds.Mould;
import cn.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * 斧模具
 *
 * @author : 0newing
 * @version : 1.0
 */
@SmsMould
public class AxeMould extends Item implements Mould
{

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
