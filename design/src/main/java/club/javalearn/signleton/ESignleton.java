package club.javalearn.signleton;

/**
 * 单例模式: 饿汉模式,自带私有自身常量，天然的线程安全；缺点类加载时就创建了INSTANCE对象,不是在使用时创建的对象
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class ESignleton {
    private ESignleton() {

    }

    private final static ESignleton INSTANCE = new ESignleton();

    public static ESignleton getInstance() {
        return INSTANCE;
    }
}
