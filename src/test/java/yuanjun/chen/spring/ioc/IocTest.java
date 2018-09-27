/**
 * @Title: IocTest.java
 * @Package: yuanjun.chen.spring.ioc
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年9月27日 下午2:31:47
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import yuanjun.chen.spring.ioc.model.Car;

/**
 * @ClassName: IocTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年9月27日 下午2:31:47
 */
public class IocTest {
    /**
     * @Title: testPathMatchingResourcePatternResolver
     * @Description: 测试加载classPath下的beans.xml，对bean进行读取并加载
     * @Attention: 注意在spring3.1后XmlBeanFactory被废弃
     * @return: void
     */
    @Test
    @SuppressWarnings("deprecation")
    public void testPathMatchingResourcePatternResolver() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        Car car = bf.getBean("car", Car.class);
        System.out.println("car bean is ready for use!---" + car);
    }

    /**
     * @Title: testXmlBeanFactory
     * @Description: 绕开废弃的XmlBeanFactory的方法
     * @return: void
     */
    @Test
    public void testXmlBeanFactory() {
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
        bdr.loadBeanDefinitions(res);
        Car car = factory.getBean("car", Car.class);
        System.out.println("car bean is ready for use!---" + car);
    }

    /**
     * @Title: testClassPathXmlApplicationContext
     * @Description: ApplicationContext的简单方法，采用ClassPathXmlApplicationContext
     * @return: void
     */
    @SuppressWarnings("resource")
    @Test
    public void testClassPathXmlApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Car car = (Car) context.getBean(Car.class);
        System.out.println("ApplicationContext get a car---" + car);
    }
    
    // FilePath大同小异，但打成jar包之后是否还能找到？
    @SuppressWarnings("resource")
    @Test
    public void testFileSystemApplicationContext() {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beans.xml");
        Car car = (Car) context.getBean(Car.class);
        System.out.println("ApplicationContext get a car---" + car);
    }
}
