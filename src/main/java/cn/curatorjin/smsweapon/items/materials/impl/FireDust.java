package cn.curatorjin.smsweapon.items.materials.impl;

import cn.curatorjin.smsweapon.SmithsWeapon;
import cn.curatorjin.smsweapon.anno.SmsMaterial;
import cn.curatorjin.smsweapon.items.SmithItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;


/**
 * 物品：烈焰尘
 *
 * @author 0newing
 */

@SmsMaterial
public class FireDust extends SmithItem
{

    /**
     * 本类实例对象
     */
    private static FireDust INSTANCE;

    public FireDust()
    {
        super();
        this.setUnlocalizedName("fireDust");
        this.setTextureName("smsweaponmod:fireDust");
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
    }

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
            INSTANCE = new FireDust();
        }
        return INSTANCE;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag)
    {
        list.add(StatCollector.translateToLocal("item.fireDust.desc0"));
        super.addInformation(itemStack, player, list, flag);
    }
}
