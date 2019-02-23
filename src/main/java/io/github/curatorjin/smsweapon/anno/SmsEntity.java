/*
 *
 * 文件名: SmsEntities.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/26  22:01
 *
 */
package io.github.curatorjin.smsweapon.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * SMSEntity注解
 *
 * @author : 0newing
 * @version : 1.0
 */

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SmsEntity
{
}
