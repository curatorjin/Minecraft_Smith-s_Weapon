/*
 *
 * 文件名: SmsBlock.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/26  21:58
 *
 */
package io.github.curatorjin.smsweapon.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * SMSBlock注解
 *
 * @author : 0newing
 * @version : 1.0
 */

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SmsBlock
{
}
