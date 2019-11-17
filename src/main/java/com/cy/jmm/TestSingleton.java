package com.cy.jmm;

public class TestSingleton {
    private static TestSingleton instance =null;
    private TestSingleton(){
        System.out.println(Thread.currentThread().getName()+"\t 单例");
    }
    //dcl 模式   双端检索机制
    public static TestSingleton getInstance(){
        if (instance==null){
            synchronized (TestSingleton.class) {
                if (instance==null) {
                    instance = new TestSingleton();
                }
            }
        }
        return  instance ;
    }
    public void  getTest(){}
    public static void main(String[] args) {
//        System.out.println(TestSingleton.getInstance()==TestSingleton.getInstance());
//        System.out.println(TestSingleton.getInstance()==TestSingleton.getInstance());
//        System.out.println(TestSingleton.getInstance()==TestSingleton.getInstance());
        for (int i = 0; i < 100 ; i++) {
            new Thread( ()->{
                TestSingleton    test=  TestSingleton.getInstance() ;

                test.getTest();
            },String.valueOf( i ) ).start();
        }

    }

}
