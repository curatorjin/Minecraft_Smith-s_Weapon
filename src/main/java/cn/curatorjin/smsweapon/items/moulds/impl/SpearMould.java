/*
 *
 * 文件名: SpearMould.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/11  0:03
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
 * 枪模具
 *
 * @author : 0newing
 * @version : 1.0
 */

@SmsMould
public class SpearMould extends Item implements Mould
{

    public SpearMould()
    {
        super();
        this.setUnlocalizedName("spearMould");
        this.setTextureName("smsweaponmod:spearMould");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

    @Override
    public Weapon synthetic(ItemStack... itemStack)
    {
        return null;
    }
}
