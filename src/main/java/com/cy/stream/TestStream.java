package com.cy.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//流式编程
@Data
@NoArgsConstructor
@AllArgsConstructor
class  User{
    private  Integer id;
    private  String userName;
    private int age;
}
//四大函数式结构
public class TestStream {
    public static void main(String[] args) {
        User u1 = new User(11,"a",23  );
        User u2 = new User(12,"b",24  );
        User u3 = new User(13,"c",22  );
        User u4 = new User(14,"d",28  );
        User u5 = new User(16,"e",26  );
        //filter过滤
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        list.stream().
                 filter(  t->{return  t.getId()%2==0;} )
                .filter( t->{return  t.getAge()>24;})
                .map( m->{return m.getUserName().toUpperCase();}  )
                .sorted((n1,n2)->{return  n2.compareTo( n1 );})
                .limit( 1 )
                .forEach( System.out::println );


















//    List<Integer> list2=Arrays.asList(1,2,3  );
//     list2.stream().map( x->{return  x*2;} ).collect( Collectors.toList());
//    list2.forEach(  x->{
//        System.out.println(x);
//    }  );













//        Function<String,Integer> function = s -> {return  s.length();};//一个输入一个返回
//
//        System.out.println( function.apply( "abc" ) );
//        //布尔型接口
//        Predicate<String> predicate = s -> {return  s.isEmpty();};
//        System.out.println( predicate.test( "dwdwa" ) );
//        //消费型接口
//        Consumer<String> consumer =s -> { System.out.println(s);};
//        consumer.accept( "asss" );
//        //供给型接口
//        Supplier<String> supplier = ()->{return  "sss";};
//        System.out.println( supplier.get() );
    }

}
