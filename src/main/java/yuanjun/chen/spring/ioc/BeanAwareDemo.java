/**
 * @Title: BeanAwareDemo.java
 * @Package: yuanjun.chen.spring.ioc
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年9月27日 下午5:11:00
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yuanjun.chen.spring.ioc.model.aware.User;
import yuanjun.chen.spring.ioc.model.aware.User2;

/**
 * @ClassName: BeanAwareDemo
 * @Description: [初步理解]BeanNameAware只有一个方法即设置BeanName的值，这样bean会记录beanName，知悉bean的名字
 * 在XmlBeanFactory的初始化里面，会无视BeanNameAware的Autowired注入，这个注入会失败
 * @author: 陈元俊
 * @date: 2018年9月27日 下午5:11:00
 */
public class BeanAwareDemo {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("awareusers.xml");

        User user = context.getBean(User.class); // 有BeanNameAware
        System.out.println(String.format("实现了BeanNameAware接口的信息BeanId=%s,所有信息=%s", user.getId(), user.toString()));

        User2 user2 = context.getBean(User2.class); // 普通pojo
        System.out.println(String.format("未实现BeanNameAware接口的信息BeanId=%s,所有信息=%s", user2.getId(), user2.toString()));
    }
}
