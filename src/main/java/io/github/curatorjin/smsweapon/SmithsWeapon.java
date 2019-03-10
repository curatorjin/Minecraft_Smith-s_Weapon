package io.github.curatorjin.smsweapon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import io.github.curatorjin.smsweapon.blocks.SmsBlocks;
import io.github.curatorjin.smsweapon.entity.SmsEntities;
import io.github.curatorjin.smsweapon.items.SmsItems;
import io.github.curatorjin.smsweapon.items.SmsRecipes;
import io.github.curatorjin.smsweapon.items.moulds.impl.SwordMould;
import io.github.curatorjin.smsweapon.machines.SmsMachines;
import io.github.curatorjin.smsweapon.utils.PackageScanner;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.LinkedList;
import java.util.List;


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

    /**
     * 包路径
     */
    private static final String PACKAGE_PATH = "io.github.curatorjin.smsweapon";

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
     * 代理实例
     */
    @SidedProxy(modId = "smsweapon",
        clientSide = "io.github.curatorjin.smsweapon.client.ClientProxy",
        serverSide = "io.github.curatorjin.smsweapon.CommonProxy")
    private static CommonProxy PROXY;

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
        List<Class> everything = new LinkedList<>();
        PackageScanner.getAllClasses(everything, PACKAGE_PATH);
        SmsBlocks.registerBlocks(everything);
        SmsItems.registerSmsItems(everything);
        SmsMachines.registerSmsMachines(everything);
        SmsRecipes.registerSmsRecipes();
        SmsEntities.registerAllEntities(everything);
    }

    /**
     * 加载
     *
     * @param event 加载事件
     */
    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, PROXY);
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
            return new SwordMould().getInstance();
        }
    }

    public static CommonProxy getPROXY()
    {
        return PROXY;
    }

    public static void setPROXY(CommonProxy proxy)
    {
        SmithsWeapon.PROXY = proxy;
    }
}
