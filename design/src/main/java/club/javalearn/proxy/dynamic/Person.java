package club.javalearn.proxy.dynamic;

/**
 * 普通人卖房子
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class Person implements Saleable {
    @Override
    public void saleHouse() {
        System.out.println("A小区B栋C单元D室房子出售");
    }
}
