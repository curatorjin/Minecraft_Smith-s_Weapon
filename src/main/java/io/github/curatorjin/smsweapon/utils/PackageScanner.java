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
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


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
        String[] jarPathInfo = PackageScanner.class.getProtectionDomain().getCodeSource().getLocation().getPath().split(
            "!");
        if (jarPathInfo.length == 1)
        {
            getAllClassesInFile(list, packagePath);
        }
        else
        {
            JarFile jarFile = null;

            try
            {
                jarFile = new JarFile(jarPathInfo[0].substring(jarPathInfo[0].indexOf("/")));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            getAllClassesInJar(list, packagePath, jarFile);
        }

    }

    /**
     * 获取Jar包中某包下的所有类
     *
     * @param list        返回的Class集合
     * @param packagePath 包路径
     * @param jarFile     Jar文件
     */
    private static void getAllClassesInJar(List<Class> list, String packagePath, JarFile jarFile)
    {
        if (null == jarFile)
        {
            return;
        }
        ClassLoader loader = SmithsWeapon.class.getClassLoader();
        packagePath = packagePath.replace(".","/");
        Enumeration<JarEntry> entrys = jarFile.entries();
        while (entrys.hasMoreElements())
        {
            JarEntry entry = entrys.nextElement();
            String entryName = entry.getName();
            if (entryName.endsWith(".class") && entryName.startsWith(packagePath))
            {
                entryName = entryName.replace("/", ".");
                entryName = entryName.substring(0,entryName.lastIndexOf("."));
                Class<?> clazz = null;

                try
                {
                    clazz = loader.loadClass(entryName);
                }
                catch (ClassNotFoundException e)
                {
                    e.printStackTrace();
                }

                if (null != clazz)
                {
                    list.add(clazz);
                }
            }
        }
    }

    /**
     * 获取文件夹中的所有类
     *
     * @param list        返回的Class集合
     * @param packagePath 包路径
     */
    private static void getAllClassesInFile(List<Class> list, String packagePath)
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
                try
                {
                    Class<?> clazz = SmithsWeapon.class.getClassLoader().loadClass(
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
