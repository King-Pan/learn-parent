package club.javalearn.proxy.statics;

/**
 * 静态代理： 代理类
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class ProxyAction implements Action {

    private Action action;

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public void show() {
        System.out.println("开始化妆......");
        action.show();
        System.out.println("开始卸妆......");
    }
}
