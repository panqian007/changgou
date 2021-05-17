package com.changgou.demo;

import com.changgou.utils.DateUtil;
import com.changgou.utils.DateUtil1;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;

import java.text.DateFormat;
import java.util.*;

public class ForDemo {
    public static void main(String[] args) {
//        User user1 = new User(11,"pq","sc");
//        User user2 = new User(12,"pq2","sc2");
//        User user3 = new User(13,"潘谦","长沙");
//        List<User> userList = new ArrayList<>();
//        userList.add(user1);
//        userList.add(user2);
//        for (User user :
//                userList) {
//            System.out.println(user.getName());
//            if(user.getAge()==12){
//                BeanUtils.copyProperties(user3,user);
//            }
//        }
//        for (User user :
//                userList) {
//            System.out.println(user.getName());
//        }
        DateFormat df = DateFormat.getDateInstance();
//        String nowDay = df.format(new Date());
//        Calendar cal = df.getCalendar();
//        int year=cal.get(Calendar.YEAR);//年
//        int month=cal.get(Calendar.MONTH)+1;//月 默认是从0开始 即1月获取到的是0
//        int day=cal.get(Calendar.DAY_OF_MONTH);//日，即一个月中的第几天
//        int hour=cal.get(Calendar.HOUR_OF_DAY);
//        int minute=cal.get(Calendar.MINUTE);//分
//        String nowTime = year+"-"+month+"-"+day+" "+hour+":"+minute;
        Calendar cla=Calendar.getInstance();
//        System.out.println(DateUtil1.parse(nowTime,"yyyy-mm-dd HH:mm"));
//        int year=cla.get(Calendar.YEAR);//年
//        int month=cla.get(Calendar.MONTH)+1;//月 默认是从0开始 即1月获取到的是0
//        int day=cla.get(Calendar.DAY_OF_MONTH);//日，即一个月中的第几天
//                String nowDay = year+"-"+month+"-"+day+" ";
//        System.out.println(month);
//        String t = "10:41";
//        Date sysSingOut = DateUtil1.parse("2021-5-13 10:42","yyyy-MM-dd HH:mm");
//        System.out.println(cla.getTime());
//        System.out.println(sysSingOut);
        String str = "ceshi";
        List<String> list = new ArrayList<String>(Collections.singleton(str));
        System.out.println(list.get(0));
    }
}
