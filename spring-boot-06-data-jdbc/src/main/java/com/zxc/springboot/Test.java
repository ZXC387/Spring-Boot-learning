package com.zxc.springboot;

/**
 * @author ZXC
 * @create 2021-03-09 10:02
 */
interface Aa{}
public class Test {
    private class A implements Aa{
        private A(){
            System.out.println("ss");
        }
    }

    public A to(){return new A();}

    public static void main(String[] args) {
       Test t = new Test();
         Aa to = t.new A();
    }
}
