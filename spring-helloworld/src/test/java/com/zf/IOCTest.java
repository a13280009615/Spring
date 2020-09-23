package com.zf;

import com.zf.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhengfan
 * @create 2020-09-23 下午4:22
 */
public class IOCTest {

    /**
     *
     * 细节：
     *  ApplicationContext 是 ioc的顶级接口
     *  容器中的组件 在容器创建完成的时候就已经创建好了 同一个组件在容器中默认是单实例的
     *  在容器中 如果没有这个组件 在获取的时候 就被报错
     *  在容器中 property标签给属性赋值 默认是通过 javaBean的 set  get 方法给属性赋值
     */

  private   ApplicationContext ioc  = new ClassPathXmlApplicationContext("ioc.xml");

    /**
     * 通过 id 从ioc 容器中获取这个组件
     */
    @Test
    public  void  test01(){
        //根据spring的 ioc配置文件获取 ioc 容器
        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
    }

    /**
     *  根据类型 从 ioc 容器中获取这个组件
     *  如果ioc容器中这个类型的bean 有多个 就会报错
     *  No qualifying bean of type [com.zf.bean.Person] is defined
     */

    @Test
    public  void  test02(){
       // Person person = ioc.getBean(Person.class);

        //可以通过
        Person hua = ioc.getBean("hua", Person.class);
        System.out.println(hua);
    }


    /**
     * 通过 构造器注入属性
     * 可以省略 name 属性  但是必须赋值的时候一一对应  如果不一一对应可以使用index 指定索引
     * 索引从0 开始
     * 如果 构造器有重载  需要使用type 指定类型  指定类型是全限定类名
     */

    @Test
    public  void  test03(){
        // Person person = ioc.getBean(Person.class);

        //可以通过
        Person hua = (Person)ioc.getBean("person02");
        System.out.println(hua);
    }

}


