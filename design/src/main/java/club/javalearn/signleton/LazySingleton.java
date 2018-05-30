package club.javalearn.signleton;

/**
 * 懒汉模式： 只有在调用getInstance方法时，才创建LazySingleton对象，静态内部类实现了线程安全。
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class LazySingleton {

    private LazySingleton() {
    }

    private static class LazySingletonHepper {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return LazySingletonHepper.INSTANCE;
    }
}
