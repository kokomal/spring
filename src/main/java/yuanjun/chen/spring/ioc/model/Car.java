/**
 * @Title: Car.java
 * @Package: yuanjun.chen.spring.ioc.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年9月27日 下午2:26:36
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.spring.ioc.model;

/**
 * @ClassName: Car
 * @Description: 简单pojo
 * @author: 陈元俊
 * @date: 2018年9月27日 下午2:26:36
 */
public class Car {
    private String brand;

    private String color;

    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
    }

}
