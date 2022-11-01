package com.spring.study;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Description TODO
 * @Author Qi
 * @Date 2022/2/16 21:43
 */
public class Test1 extends ClassLoader{
    private int aa;
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();

        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i]);
        }


//        String s = "asdf";
//        s.length();

        String s = null;
        Test1 test1 = new Test1(30);
        System.out.println(test1.aa);

        String a = "abc123";
//        char b[] = "xyz";

        Base driver = new Driver();
        driver.methodTwo();
        System.gc();
    }
    Test1(int aaa){
        aa = aaa;
    }
    float aa(){
//        public class a1{}
//        private class a2{}
        final class a3{};
        abstract class a4{};
        long a = 1L;
        return a;

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
