package io.github.curatorjin.smsweapon.items.moulds.impl;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import io.github.curatorjin.smsweapon.anno.SmsMould;
import io.github.curatorjin.smsweapon.items.SmithItem;
import io.github.curatorjin.smsweapon.items.moulds.Mould;
import io.github.curatorjin.smsweapon.items.weapons.Weapon;
import io.github.curatorjin.smsweapon.items.weapons.impl.sword.FireSword;
import net.minecraft.item.ItemStack;


/**
 * 剑模具
 *
 * @author 0newing
 */

@SmsMould
public class SwordMould extends SmithItem implements Mould
{

    /**
     * 本类实例对象
     */
    private static SwordMould INSTANCE;

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
            INSTANCE = new SwordMould();
        }
        return INSTANCE;
    }

    public SwordMould()
    {
        super();
        this.setUnlocalizedName("swordMould");
        this.setTextureName("smsweaponmod:swordMould");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

    @Override
    public Weapon synthetic(ItemStack... itemStack)
    {
        return (Weapon)new FireSword().getInstance();
    }

}
