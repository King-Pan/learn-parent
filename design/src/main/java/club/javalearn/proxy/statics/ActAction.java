package club.javalearn.proxy.statics;

/**
 * 静态代理: 接口类实现类
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class ActAction implements Action {

    @Override
    public void show() {
        System.out.println("开始我的表演");
    }
}
