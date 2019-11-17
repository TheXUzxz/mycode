package com.cy.company.java.oop.feature;
interface  MailService{
	void send(String msg);
}
class DefaultMailService implements MailService{
	@Override
	public void send(String msg) {
		System.out.println(msg);
		
	}
}
class LogMailService{
	private MailService mailService;
	
	public LogMailService(MailService mailService) {
		this.mailService = mailService;
	}
	public void send (String msg) {
		System.out.println("start:"+System.nanoTime() );
		mailService.send(msg);
		System.out.println("end:"+System.nanoTime() );
	}
	
}
public class TestCompose01 {
	 public static void main(String[] args) {
		 MailService ms = new DefaultMailService();
		 LogMailService lms = new LogMailService(ms);
		 lms.send("你好");
	}
}
