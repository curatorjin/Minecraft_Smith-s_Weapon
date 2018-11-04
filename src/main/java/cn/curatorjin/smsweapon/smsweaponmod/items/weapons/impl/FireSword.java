package cn.curatorjin.smsweapon.smsweaponmod.items.weapons.impl;

import cn.curatorjin.smsweapon.smsweaponmod.SmithsWeapon;
import cn.curatorjin.smsweapon.smsweaponmod.items.moulds.Mould;
import cn.curatorjin.smsweapon.smsweaponmod.items.weapons.Weapon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * 炎之剑·武器
 *
 * @author 0newing
 * @version 1.0
 */
public class FireSword extends Item implements Weapon
{

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
        mould = SmithsWeapon.getSwordMould();
        itemStack = new ItemStack(SmithsWeapon.getFireDust(), 1);
        this.setUnlocalizedName("fireSword");
        this.setTextureName("smsweaponmod:fireSword");
        this.setCreativeTab(CreativeTabs.tabCombat);
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
