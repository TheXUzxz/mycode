package com.cy.juc;
/**
 * 面向函数式编程Lamda表达式
 *  拷贝中括号  写死右箭头   落地大括号
 *  函数式接口有且只有一个实例方法
 * */
@FunctionalInterface
interface  Foo{
    //  public void sayHello();
      public String sayHelloWord(String s);
      public  default  int sum(int x, int y){
          return  x*y;
      }
      static  int add (int a,int b){
          return  a+b;
      }

}
public class TestLamda {
    public static void main(String[] args) {
        //lamda表达式
        Foo foo1 = (String s)->{ return  s; };
        String s = foo1.sayHelloWord( "hello Word" );
        System.out.println(s);
        int sum = foo1.sum( 10, 20 );
        System.out.println(sum);
        int add = Foo.add( 100, 200 );
        System.out.println(add);
    }
}
