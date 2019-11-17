package com.cy.gc;

import java.util.ArrayList;
import java.util.List;

public class TestGcOverhead {
    public static void main(String[] args)
    {
        int i = 0;
        List<String> list = new ArrayList<>(  );
        try {
            while (true){
                list.add( String.valueOf( ++i ).intern() );
            }
        }catch (Throwable e){
            System.out.println("*********"+i);
            e.printStackTrace();
            throw  e;
        }finally {

        }
    }
}
