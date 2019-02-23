package io.github.curatorjin.smsweapon.blocks;

import io.github.curatorjin.smsweapon.SmithsWeapon;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


/**
 * 烈焰岩·方块
 *
 * @author 0newing
 * @version 1.0
 */

public class FireBlock extends SmithBlock
{

    /**
     * 单例对象
     */
    private static FireBlock INSTANCE;

    /**
     * 获取实体对象(单例)
     *
     * @return 实例
     */
    @Override
    public SmithBlock getInstance()
    {
        if (null == INSTANCE)
        {
            INSTANCE = new FireBlock();
        }
        return INSTANCE;
    }

    public FireBlock()
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
