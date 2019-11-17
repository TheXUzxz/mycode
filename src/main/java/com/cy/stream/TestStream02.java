package com.cy.stream;


import java.util.Arrays;
import java.util.List;

public class TestStream02 {
    public static void main(String[] args) {
        User u1 = new User(11,"a",23  );
        User u2 = new User(12,"b",24  );
        User u3 = new User(13,"c",22  );
        User u4 = new User(14,"d",28  );
        User u5 = new User(16,"e",26  );
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream().filter( t->  t.getId()%2==0   ).
                filter( t-> t.getAge()>24 ).
                map( m-> m.getUserName().toUpperCase()  ).
                sorted( (n1,n2)->n2.compareTo( n1 ) ).
                limit( 1 ).
                forEach( System.out::println );

    }
}
