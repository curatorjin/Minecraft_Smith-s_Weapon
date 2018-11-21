package cn.curatorjin.smsweapon;

import cn.curatorjin.smsweapon.blocks.SmsBlocks;
import cn.curatorjin.smsweapon.items.SmsItems;
import cn.curatorjin.smsweapon.items.SmsRecipes;
import cn.curatorjin.smsweapon.machines.SmsMachines;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


/**
 * MOD加载入口
 *
 * @author 0newing
 * @version 1.0
 */
@Mod(modid = "smsweapon", name = "Smith's Weapon", version = "1.0.0")
public class SmithsWeapon
{

    /**
     * MOD_ID
     */
    private static final String MODID = "smsweapon";

    public static String getMODID()
    {
        return MODID;
    }

    /**
     * Mod实例
     */
    @Mod.Instance("smsweapon")
    private static SmithsWeapon INSTANCE;

    public SmithsWeapon()
    {
        INSTANCE = this;
    }

    /**
     * 分页
     */
    private static SmithsWeaponTab SMITHS_WEAPON_TAB = new SmithsWeaponTab("Smith's Weapon");

    public static SmithsWeaponTab getSmithsWeaponTab()
    {
        return SMITHS_WEAPON_TAB;
    }

    /**
     * 预加载
     *
     * @param event 加载事件
     */
    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        SmsBlocks.registerBlocks();
        SmsItems.registerSmsItems();
        SmsMachines.registerSmsMachines();
        SmsRecipes.registerSmsRecipes();
    }

    /**
     * 加载
     *
     * @param event 加载事件
     */
    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {

    }

    /**
     * 后置加载
     *
     * @param event 加载事件
     */
    @Mod.EventHandler
    public void postLoad(FMLPostInitializationEvent event)
    {

    }

    public static SmithsWeapon getINSTANCE()
    {
        return INSTANCE;
    }

    /**
     * 创造模式分页
     */
    private static class SmithsWeaponTab extends CreativeTabs
    {
        SmithsWeaponTab(String label)
        {
            super(label);
        }

        @Override
        public Item getTabIconItem()
        {
            return SmsItems.getSwordMould();
        }
    }
}
