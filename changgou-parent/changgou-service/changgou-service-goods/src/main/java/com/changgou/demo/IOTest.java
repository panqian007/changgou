package com.changgou.demo;

import com.changgou.utils.DateUtil;
import com.changgou.utils.DateUtil1;
import org.apache.commons.lang.time.DateUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class IOTest {
    public static void main(String[] args) throws IOException {
//        File file1 = new File("1.txt");
//        String str = "没有耕坏的田，只有累死的牛。";
//        File file2 = new File("2.txt");
//        FileOutputStream fos = null;
//        FileInputStream fis = null;
//            fos = new FileOutputStream(file2);
//            fos.write(str.getBytes());
//            fis = new FileInputStream(file1);
//            byte[] bytes =new byte[1024];
//            int i;
//            while ((i=fis.read(bytes))!=-1) {
//                fos.write(bytes, 0, i);
//                fos.close();
//                fis.close();
//
//            }
//        String str= "=\"" + "23" + "\"";
//        String str = "718590";
//        StringBuffer buffer = new StringBuffer("and or");
//        String eee = buffer.toString().substring(buffer.length()-2,buffer.length());
//        int i = 1;
//       try {
//           i = buffer.lastIndexOf("or");
//       }catch (Exception e){
//
//       }
//       String sss =buffer.toString().substring(0,i);
//       sss+=")";
//       String shtr1 = str.substring(i,i+2);
//        if(!Objects.equals("=",str.charAt(0))&&!Objects.equals("\"",str.charAt(str.length()-1))){
//            System.out.println(str.startsWith("=\""));
//            System.out.println(str.endsWith("\""));
//        }
//        String eee = str.substring(str.indexOf("=\"")+2,str.lastIndexOf("\""));
//        System.out.println(eee);
//        Date now = new Date();
        DateFormat d2 = DateFormat.getDateInstance();
        String str2 = d2.format(new Date());
        DateFormat d3 = DateFormat.getDateTimeInstance();
        String str3 = d3.format(new Date());
//        DateFormat d6 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
//        String str6 = d6.format(now);
        String time = str2+" 23:59:59";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date dateTime = null;
//        try {
//            dateTime = simpleDateFormat.parse(time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Date date2 = DateUtil1.parse(str2+" 13:54","yyyy-mm-dd HH:mm");
        Date date3 = DateUtil1.parse(str3,"yyyy-mm-dd HH:mm");
        System.out.println(date3.compareTo(date2));
//        String i = "001313?sdasdasdasdasd=asdasd";
//        System.out.println(0%2);
//
//        String str1 = new String("xx");
//
//        String str2 = new String("xx");
//
//        System.out.println(str1 == str2);
//
//        Map<String ,String> map = new IdentityHashMap<String ,String>();
//
//        map.put(str1, "nihao");
//
//        map.put(str2, "baiduzhidao");
//
//        for(Map.Entry<String,String> entry : map.entrySet())
//
//        {
//
//            System.out.println(entry.getKey()+"   " + entry.getValue());
//
//        }
//
//        System.out.println("     containsKey---> " + map.containsKey("xx"));
//
//        System.out.println("str1 containsKey---> " + map.containsKey(str1));
//
//        System.out.println("str2 containsKey---> " + map.containsKey(str2));
//
//        System.out.println("    value----> " + map.get("xx"));
//
//        System.out.println("str1  value----> " + map.get(str1));
//
//        System.out.println("str2  value----> " + map.get(str2));
//
    }
}
