package io.github.curatorjin.smsweapon.items.weapons.impl.sword;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import io.github.curatorjin.smsweapon.items.SmithItem;
import io.github.curatorjin.smsweapon.items.materials.impl.FireDust;
import io.github.curatorjin.smsweapon.items.moulds.Mould;
import io.github.curatorjin.smsweapon.items.moulds.impl.SwordMould;
import io.github.curatorjin.smsweapon.items.weapons.Weapon;
import net.minecraft.item.ItemStack;


/**
 * 炎之剑·武器
 *
 * @author 0newing
 * @version 1.0
 */

public class FireSword extends SmithItem implements Weapon
{

    /**
     * 本类实例对象
     */
    private static FireSword INSTANCE;

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
            INSTANCE = new FireSword();
        }
        return INSTANCE;
    }

    /**
     * 需要的模具
     */
    private Mould mould;

    /**
     * 需要的材料
     */
    private ItemStack itemStack;

    public FireSword()
    {
        super();
        mould = (Mould)new SwordMould().getInstance();
        itemStack = new ItemStack(new FireDust().getInstance(), 1);
        this.setUnlocalizedName("fireSword");
        this.setTextureName("smsweaponmod:fireSword");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

    public Mould getMould()
    {
        return mould;
    }

    public void setMould(Mould mould)
    {
        this.mould = mould;
    }

    public ItemStack getItemStack()
    {
        return itemStack;
    }

    @Override
    public Mould decompose()
    {
        return mould;
    }
}
