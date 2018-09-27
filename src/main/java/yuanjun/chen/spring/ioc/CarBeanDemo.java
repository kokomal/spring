/**  
 * @Title: CarBeanDemo.java   
 * @Package: yuanjun.chen.spring.ioc   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年9月27日 下午2:28:40   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import yuanjun.chen.spring.ioc.model.Car;

/**   
 * @ClassName: CarBeanDemo   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年9月27日 下午2:28:40  
 */
public class CarBeanDemo {
    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("init BeanFactory.");
        Car car = bf.getBean("car", Car.class);
        System.out.println("car bean is ready for use!---" + car);
    }
}
