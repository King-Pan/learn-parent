package com;

import org.junit.Test;

/**
 * learn-parent
 *
 * @author king-pan
 * @date 2018-05-29
 **/
public class CpuTest {

    @Test
    public void getCpuNum(){
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

class Singleton{
    private Singleton(){}

    public static Singleton getInstanct(){
        return SingletonHepper.INSTANCE;
    }

    private static class SingletonHepper{
        private static final Singleton INSTANCE = new Singleton();
    }

}

