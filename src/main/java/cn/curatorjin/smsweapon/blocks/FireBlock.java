package cn.curatorjin.smsweapon.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


/**
 * 烈焰岩·方块
 *
 * @author 0newing
 * @version 1.0
 */
public class FireBlock extends Block
{

    public FireBlock()
    {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockName("fireBlock");
        this.setBlockTextureName("smsweaponmod:fireBlock");
        setHardness(5.0f);  //方块硬度
        setResistance(10.0f);   //对爆炸抗性
        setLightLevel(2.0f);    //发光亮度
        setHarvestLevel("pickaxe", 2);  //采集所需工具及其材质
        setStepSound(Block.soundTypeStone);  //踏步音效
    }
}
