/*
 *
 * 文件名: SmsNoReg.java
 * 描述: 不注册的注解
 * 创建人: 0newing
 * 时间: 2019/2/24  3:02
 *
 */
package io.github.curatorjin.smsweapon.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 被此注解标记后将不予注册
 *
 * @author : 0newing
 * @version : 1.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SmsNoReg
{
}
