package com.cy.mynio;

import java.util.Scanner;

public class TestChat {
    public static void main(String[] args)throws  Exception {
        ChatClient chatClient=new ChatClient();
        new Thread( ()->{
            while (true){
                try {
                    chatClient.receiveMsg();
                    Thread.sleep( 2000 );
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } ).start();

        Scanner sc = new Scanner( System.in );
        while (sc.hasNextLine()){
            String msg = sc.next();
            chatClient.senMsg( msg );
        }
    }
}
