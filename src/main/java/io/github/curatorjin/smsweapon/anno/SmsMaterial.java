/*
 *
 * 文件名: SmsMaterial.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/3  23:07
 *
 */
package io.github.curatorjin.smsweapon.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 合成材料
 *
 * @author : 0newing
 * @version : 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface SmsMaterial
{
}
