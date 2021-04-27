package com.changgou.demo;

import java.io.*;

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
        String str= "and_or";
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
        String eee = str.substring(0,str.indexOf("_"));
        System.out.println(eee);
    }
}
