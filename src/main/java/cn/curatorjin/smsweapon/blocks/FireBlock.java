package cn.curatorjin.smsweapon.blocks;

import cn.curatorjin.smsweapon.SmithsWeapon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


/**
 * 烈焰岩·方块
 *
 * @author 0newing
 * @version 1.0
 */
class FireBlock extends Block
{

    FireBlock()
    {
        super(Material.iron);
        this.setCreativeTab(SmithsWeapon.getSmithsWeaponTab());
        this.setBlockName("fireBlock");
        this.setBlockTextureName("smsweaponmod:fireBlock");
        setHardness(5.0f);
        setResistance(10.0f);
        setLightLevel(2.0f);
        setHarvestLevel("pickaxe", 2);
        setStepSound(Block.soundTypeStone);
    }
}
