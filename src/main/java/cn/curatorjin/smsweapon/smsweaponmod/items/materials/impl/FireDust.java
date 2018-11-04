package cn.curatorjin.smsweapon.smsweaponmod.items.materials.impl;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;


/**
 * 物品：烈焰尘
 *
 * @author 0newing
 */
public class FireDust extends Item
{

    public FireDust()
    {
        super();
        this.setUnlocalizedName("fireDust");
        this.setTextureName("smsweaponmod:fireDust");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag)
    {
        list.add(StatCollector.translateToLocal("item.fireDust.desc0"));
        super.addInformation(itemStack, player, list, flag);
    }
}
