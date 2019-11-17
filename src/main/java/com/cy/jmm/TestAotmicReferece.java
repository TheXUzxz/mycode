package com.cy.jmm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User{
    String name;
    int age;
}
//原子引用
public class TestAotmicReferece {
    public static void main(String[] args) {
        User u1 = new User( "z3",25 );
        User u2 = new User( "lisi",23 );
        AtomicReference<User>  atomicReference = new AtomicReference<>(  );
        atomicReference.set( u1 );
        System.out.println(atomicReference  .compareAndSet( u1,u2 )
                +"\t "+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet( u1,u2 )
                +"\t "+atomicReference.get().toString());

    }

}
