package com.changgou.demo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class Test2 {
    public int f(int i) {
        i++;
        return i;
    }

    public static void main(String[] args) throws Exception {
//        ClassPool.getDefault().insertClassPath("D:\\GoogleDownloads\\aspose-pdf-17.8.jar");
        //设置目标类的路径(即目标类的class路径，我这里的test2.class是在工程下WebRoot/WEB-INF/classes/com/hcj/javaassist)
        CtClass z123 = ClassPool.getDefault().getCtClass("com.aspose.pdf.z123");
        CtMethod[] ms =z123.getDeclaredMethods();
        for (CtMethod c: ms) {
            CtClass[] ps = c.getParameterTypes();
            if(c.getName().equals("m1")&&ps.length==2
            && ps[0].getName().equals("org.w3c.dom.Node")
            && ps[1].getName().equals("org.w3c.dom.Node")){
                String aaa = "{return;}";
                System.out.println(aaa);
                c.setBody(aaa);
                z123.writeFile();
            }
        }
        z123.writeFile();
    }
}
