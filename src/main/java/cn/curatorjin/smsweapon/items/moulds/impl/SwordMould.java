package cn.curatorjin.smsweapon.items.moulds.impl;

import cn.curatorjin.smsweapon.SmithsWeapon;
import cn.curatorjin.smsweapon.items.moulds.Mould;
import cn.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * 剑模具
 *
 * @author 0newing
 */
public class SwordMould extends Item implements Mould
{

    public SwordMould()
    {
        super();
        this.setUnlocalizedName("swordMould");
        this.setTextureName("smsweaponmod:swordMould");
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public Weapon synthetic(ItemStack... itemStack)
    {
        return SmithsWeapon.getFireSword();
    }

}
