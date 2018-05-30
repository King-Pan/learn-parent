package club.javalearn.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理: 代理类: 链家中国最黑心的房地产交易公司
 *
 *
 * 动态代理类详细分析：
 *
 *    动态代理的步骤：
 *
 *　　　　　1. 首先获得一个被代理对象的引用，
 *
 *　　　　　2. 获得该引用的接口
 *
 *　　　　　3. 生成一个类，这个类实现了我们给的代理对象所实现的接口
 *
 *　　　　　4. 上述类编译生成了.class字节码供JVM使用
 *
 *　　　　　5. 调用上述生成的class
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class HomeLink implements InvocationHandler {


    private Saleable target;

    public Object getInstance(Saleable target){
        this.target = target;
        Class clazz = target.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是链家，我帮别人找房子..");
        System.out.println("我是链家, 我们提供了房源信息搜索，免费看房，免费过户等服务");
        //第一个参数是target,也就是被代理类的对象；第二个参数是方法中的参数
        method.invoke(target, args);
        System.out.println("我是链家，我的服务完毕，欢迎下次光临");
        return null;
    }
}
