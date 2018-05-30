package club.javalearn.proxy.dynamic;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-30
 **/
public class TestSaleHouse {
    public static void main(String[] args) {
        Saleable saleHouse = (Saleable) new HomeLink().getInstance(new Person());
        saleHouse.saleHouse();
    }
}
