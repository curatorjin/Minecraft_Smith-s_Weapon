/*
 *
 * 文件名: SmithItem.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2018/11/26  21:58
 *
 */
package cn.curatorjin.smsweapon.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * SMSItem注释
 *
 * @author : 0newing
 * @version : 1.0
 */

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SmsItem
{
}
