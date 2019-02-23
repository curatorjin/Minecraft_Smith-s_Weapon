/*
 *
 * 文件名: PackageScanner.java
 * 描述: 一句话描述
 * 创建人: 0newing
 * 时间: 2019/1/18  22:22
 *
 */
package io.github.curatorjin.smsweapon.utils;

import io.github.curatorjin.smsweapon.SmithsWeapon;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;


/**
 * 包扫描工具
 *
 * @author : 0newing
 * @version : 1.0
 */
public final class PackageScanner
{
    private PackageScanner()
    {
    }

    /**
     * 获取包路径下的所有类
     *
     * @param list        返回的Class集合
     * @param packagePath 包路径
     */
    public static void getAllClasses(List<Class> list, String packagePath)
    {
        String filePath = packagePath.replace(".", "/");
        if (packagePath.endsWith(".class"))
        {
            filePath = filePath.replace("/class", ".class");
        }
        URL rootPath = SmithsWeapon.class.getClassLoader().getResource(
            filePath);

        File file = null;
        try
        {
            if (null != rootPath)
            {
                file = new File(rootPath.toURI());
            }
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        if (null == file)
        {
            return;
        }
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            if (null != files)
            {
                for (File f : files)
                {
                    getAllClasses(list, packagePath + "." + f.getName());
                }
            }
        }
        else
        {
            if (file.getName().endsWith(".class"))
            {
                Class<?> clazz = null;
                try
                {
                    clazz = SmithsWeapon.class.getClassLoader().loadClass(
                        packagePath.replace(".class", ""));
                    list.add(clazz);
                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
