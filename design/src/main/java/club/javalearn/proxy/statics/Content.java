package club.javalearn.proxy.statics;

/**
 * 静态代理: 测试
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class Content {
    public static void main(String[] args) {
        Action act = new ActAction();
        ProxyAction action = new ProxyAction();
        action.setAction(act);
        action.show();
    }
}
