package com.cy.jvm;

import com.cy.juc.Person;

public class TestTransferValue {
    public void changeValue1(int age){
        age =30;

    }

    public void changeValue2(Person person){
            person.setName( "theshy" );

    }
    public void changeValue3(String  str){
            str="xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test =  new TestTransferValue();
        int age =20;
        test.changeValue1( age );
        System.out.println(age);

        Person person = new Person( "faker" );
        test.changeValue2( person );
        System.out.println(person.getName());

        String str ="abc";
        test.changeValue3( str );
        System.out.println(str);
    }
}
