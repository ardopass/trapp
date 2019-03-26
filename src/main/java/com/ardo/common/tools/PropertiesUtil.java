/*
 * 文 件 名:  PropertyUtil.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  c00221720
 * 修改时间:  2013-7-25
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ardo.common.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  c00221720
 * @version  [版本号, 2013-7-25]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class PropertiesUtil
{
    
    private static Properties pro = new Properties();
    static
    {
        pro = loadProperties("baseConfig.properties");
    }
    
    /**
     * 获取对应key的值
     * 
     * @param key
     * @return
     */
    public static String getValue(String key)
    {
        return pro.getProperty(key);
    }
    
    /**
     * 获取对应key的值
     * 
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public static String getValue(String key, String defaultValue)
    {
        return pro.getProperty(key, defaultValue);
    }
    
    /**
     * 加载配置文件
     * <功能详细描述>
     * @param path
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Properties loadProperties(String path)
    {
        
        InputStream in = null;
        
        Properties p = new Properties();
        
        try
        {
            /************方法一：该加载修改配置文件后需要重启服务*****************/
        	//加载配置文件到文件流
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
            p.load(in);
            
            /************方法二：该加载修改配置文件后不需要重启服务*****************/
//            Properties prop = new Properties();  
//            String rootpath = PropertiesUtil.class.getClassLoader().getResource(path).getPath();  
//            System.out.println("0000000000000000000000000===================$$$$$$$rootpath==="+rootpath);
//            InputStream is = new FileInputStream(rootpath);  
//            prop.load(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //处理异常
        finally
        {
            if (null != in)
            {
                try
                {
                    //关闭文件流
                    in.close();
                    in = null;
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
        return p;
    }
}
