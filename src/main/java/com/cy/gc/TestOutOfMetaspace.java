package com.cy.gc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestOutOfMetaspace {
    static  class  OOMTest{

    }
    public static void main(String[] args) {
        int i=0;
        try {
            while (true){
                i++;
                Enhancer enhancer =new Enhancer();
                enhancer.setSuperclass( OOMTest.class );
                enhancer.setUseCache( false );
                enhancer.setCallback( new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper( obj,args );
                    }
                } );
                enhancer.create();
            }
        }catch (Exception e){
            System.out.println("多少次以后发生了异常"+i);
            e.printStackTrace();
        }finally {

        }
    }
}
