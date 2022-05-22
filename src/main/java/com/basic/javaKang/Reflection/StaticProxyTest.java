package com.basic.javaKang.Reflection;

/**
 * @Author: 23236
 * @createTime: 2022/4/1   22:08
 * @description: 静态代理测试
 *
 *
 **/

interface  ClothFactory{
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory{

    ClothFactory factory;
    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }
    @Override
    public void produceCloth() {
        System.out.println(this.factory.getClass().getName()+"代理工厂做了一些准备工作");
        this.factory.produceCloth();    //调用被代理类的方法
        System.out.println(this.factory.getClass().getName()+"代理工厂做好了一些准备工作");
    }
}
class  NikeFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("nike 喜欢制造一些衣服");
    }
}



public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nikeFactory = new NikeFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeFactory);
        proxyClothFactory.produceCloth();
    }

}
