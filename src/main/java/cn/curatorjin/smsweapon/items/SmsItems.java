/*
 *
 * 文件名: SmsItems.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/18  11:55
 *
 */
package cn.curatorjin.smsweapon.items;

import cn.curatorjin.smsweapon.items.materials.impl.FireDust;
import cn.curatorjin.smsweapon.items.moulds.impl.SwordMould;
import cn.curatorjin.smsweapon.items.weapons.impl.sword.FireSword;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;


/**
 * 物品的总类、统一工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public class SmsItems
{

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
     * 注册所有物品，供主类调用
     *
     */
    public static void registerSmsItems()
    {

        //物品声明

        FIRE_DUST = new FireDust();
        SWORD_MOULD = new SwordMould();
        FIRE_SWORD = new FireSword();

        //物品注册
        registerSmsItem(FIRE_DUST);
        registerSmsItem(SWORD_MOULD);
        registerSmsItem(FIRE_SWORD);
    }

    /**
     * 注册物品
     *
     * @param item 要注册的物品
     */
    private static void registerSmsItem(Item item)
    {
        GameRegistry.registerItem(item,item.getUnlocalizedName().substring(5));
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
