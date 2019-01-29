/*
 *
 * 文件名: ClientProxy.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/12/2  17:42
 *
 */
package cn.curatorjin.smsweapon.client;

import cn.curatorjin.smsweapon.CommonProxy;
import net.minecraftforge.common.MinecraftForge;


/**
 * Class/Interface/Enum description
 *
 * @author : 0newing
 * @version : 1.0
 */
public class ClientProxy extends CommonProxy
{
    /**
     * 预加载
     */
    @Override
    public void init()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
