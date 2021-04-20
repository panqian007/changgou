package com.changgou.demo;

import io.netty.util.concurrent.SingleThreadEventExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class J8Test {
    public static void main(String[] args) {
//        Arrays.asList( "a", "b","c", "d" ).forEach(e -> System.out.println( e ) );
//            Thread1 thread1 = new Thread1();
//            Thread1 thread2 =new Thread1();
//            thread1.start();
//            thread2.start();
//        Thread2 thread2 = new Thread2();
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
//        executorService1.submit(thread2);
//        executorService1.submit(thread1);
//        executorService1.submit(thread2);
//        executorService1.submit(thread1);
        List<User> users = new ArrayList<User>();
        users.add(new User(21, "张三","长沙"));
        users.add(new User(22, "李四","广州"));
        users.add(new User(10, "王五","长沙"));

//        Stream<User> stream = users.stream();
//       stream.filter(a -> a.getAddress().equals("长沙")).limit(2).forEach(b->{
//           System.out.println(b.getName());
//       });
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
//            int result = e1.compareTo( e2 );
//            System.out.println(result);
//            return result;
//        } );
//        userList.forEach(a->a.getName());
//        for (User s:userList
//             ) {
//            System.out.println(s.getName());
//        }
        Integer value1 = new Integer(10);
        Integer value2 = null;
        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value2);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value1);
        sum(a,b);
    }
    public final static int i =1;
    public static void test1(){
        Runnable runnable =()->{
            tb("拉姆达");
            System.out.println("拉姆达表达式创建的线程"+i);
        };
        new Thread(runnable).start();
    };
    public static void test2(){
            Runnable runnable =new Runnable() {
                @Override
                public void run() {
                    tb("内部类");
                    System.out.println("内部类创建的线程"+i);
                }

    };
            runnable.run();
    }
    public static  void tb(String name){
        int count =0;
            for (int i =0;i<10;i++){
                count++;
                System.out.println(name+"运行了"+i+"次");
            }
        System.out.println("count:"+count);
    }
    public static Integer sum(Optional<Integer> a, Optional<Integer> b){
        // Optional.isPresent - 判断值是否存在
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(1));
        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value1+value2);
        return value1 + value2;
    }

}
