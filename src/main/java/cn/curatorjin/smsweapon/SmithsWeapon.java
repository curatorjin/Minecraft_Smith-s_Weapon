package cn.curatorjin.smsweapon;

import cn.curatorjin.smsweapon.blocks.FireBlock;
import cn.curatorjin.smsweapon.items.materials.impl.FireDust;
import cn.curatorjin.smsweapon.items.moulds.impl.SwordMould;
import cn.curatorjin.smsweapon.items.weapons.impl.sword.FireSword;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;


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
     * 烈焰岩
     */
    private static FireBlock FIRE_BLOCK;

    /**
     * 烈焰尘
     */
    private static FireDust FIRE_DUST;

    /**
     * 剑模具
     */
    private static SwordMould SWORD_MOULD;

    /**
     * 炎之剑
     */
    private static FireSword FIRE_SWORD;

    /**
     * 预加载
     *
     * @param event 加载事件
     */
    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {

        //物品声明
        FIRE_BLOCK = new FireBlock();
        FIRE_DUST = new FireDust();
        SWORD_MOULD = new SwordMould();
        FIRE_SWORD = new FireSword();

        //物品注册
        GameRegistry.registerBlock(FIRE_BLOCK, FIRE_BLOCK.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(FIRE_DUST, FIRE_DUST.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(SWORD_MOULD, SWORD_MOULD.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(FIRE_SWORD, FIRE_SWORD.getUnlocalizedName().substring(5));

        //冶炼公式注册
        GameRegistry.addSmelting(FIRE_BLOCK, new ItemStack(FIRE_DUST, 1), 50f);
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

    public static FireBlock getFireBlock()
    {
        return FIRE_BLOCK;
    }

    public static FireDust getFireDust()
    {
        return FIRE_DUST;
    }

    public static SwordMould getSwordMould()
    {
        return SWORD_MOULD;
    }

    public static FireSword getFireSword()
    {
        return FIRE_SWORD;
    }
}
