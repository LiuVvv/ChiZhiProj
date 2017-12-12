package com.edu.tool;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;







public class SendMail {
	static String server = "smtp.163.com";
	static String user = "18131166590@163.com";
    static String password = "1qaz2wsx";
    static String recevie = "18131166590@163.com";
    static String from = "刘薇";
	public static void sendMail(String email, String subject, String body) throws Exception {
		// TODO Auto-generated method stub
		 Properties prop = new Properties();
	     prop.setProperty("mail.host", "smtp.163.com");
		 prop.setProperty("mail.transport.protocol", "smtp");
	     prop.setProperty("mail.smtp.auth", "true");     
	     //使用JavaMail发送邮件的5个步骤
	     //1、创建session
        Session session = Session.getInstance(prop);
	     //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	     session.setDebug(true);
	      //2、通过session得到transport对象
	     Transport ts = session.getTransport("smtp");
		  //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和 给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
		 ts.connect(server,user ,password );
		 //4、创建邮件
		 //创建邮件对象
	     MimeMessage message = new MimeMessage(session);
	     //指明邮件的发件人
         message.setFrom(new InternetAddress(user));
         
         InternetAddress fromAddress = new InternetAddress(user,from,"UTF-8");
         message.setFrom(fromAddress);
         String emailList[]=email.split(",");
         InternetAddress[] toAddress = new InternetAddress[emailList.length];
         
         for(int i=0;i<emailList.length;i++)
         {
         	toAddress[i]=new InternetAddress(emailList[i]);
         }
         //指明邮件的收件人，
         message.addRecipients(Message.RecipientType.TO, toAddress);
         message.setSubject(subject, "UTF-8");   
         message.setContent(body, "text/html;charset=utf-8");
         message.saveChanges();
//		 Transport.send(message);
//		  5、发送邮件
		 
	     ts.sendMessage(message, message.getAllRecipients());
		 ts.close();
	}
	
//	 public static void main(String args[]) throws Exception
//	    {
//	    	
//	    	SendMail.sendMail("18131166590@163.com", "ceshi", "ce");
////			if(System.getProperty("os.name").contains("w"))
////			{
////				System.out.println(System.getProperty("os.name"));
////				System.out.println("ok");
////			} 
//	        
//	    }
	
}
	
//	 public static MimeMessage createAttachMail(Session session)
//	            throws Exception {
//	        //创建邮件对象
//	        MimeMessage message = new MimeMessage(session);
//	        //指明邮件的发件人
//	        message.setFrom(new InternetAddress("18131166590@163.com"));
//	        //指明邮件的收件人，
//	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1535937433@qq.com"));
//	        //邮件的标题
//	        message.setSubject("禅知项目测试报告_刘薇");
//	        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码  
//	        MimeBodyPart text = new MimeBodyPart();
//	        //邮件的文本内容
//	        text.setContent("测试报告在附件当中", "text/html;charset=UTF-8");
//	      
//	        //创建邮件附件
//		     MimeBodyPart attach = new MimeBodyPart();
//		     DataHandler dh = new DataHandler(new FileDataSource("D:/GitHubCode/ChiZhiProj/ChanZhi-LiuWei/test-output/index.html"));
//	         attach.setDataHandler(dh);
//		     attach.setFileName(dh.getName());  
//		 
//		        
//		  //创建容器描述数据关系
//	        MimeMultipart mp = new MimeMultipart();
//	        mp.addBodyPart(text);
//	        mp.addBodyPart(attach);
//	        mp.setSubType("mixed");
//       
//	        message.setContent(mp);
//	        message.saveChanges();
//	      //将创建的Email写入到E盘存储
//	        message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
//	      //返回生成的邮件
//		    return message;
//	        
//	    }
//	}
