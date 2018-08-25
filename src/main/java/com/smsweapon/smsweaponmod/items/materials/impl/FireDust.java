package com.smsweapon.smsweaponmod.items.materials.impl;

import com.smsweapon.smsweaponmod.SmithsWeapon;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class FireDust extends Item{

    public FireDust (){
        super();
        this.setUnlocalizedName("fireDust");
        this.setTextureName("smsweaponmod:fireDust");
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    //添加物品描述
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean flag) {
        list.add(StatCollector.translateToLocal("item.fireDust.desc0"));
        super.addInformation(itemStack,player,list,flag);
    }
}
