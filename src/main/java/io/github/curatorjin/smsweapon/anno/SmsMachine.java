/*
 *
 * 文件名: SmsMachine.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/19  0:00
 *
 */
package io.github.curatorjin.smsweapon.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 机器注解
 *
 * @author : 0newing
 * @version : 1.0
 */

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SmsMachine
{
}
