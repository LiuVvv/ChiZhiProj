package com.edu.mail;

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

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 Properties prop = new Properties();
	     prop.setProperty("mail.host", "smtp.163.com");
		 prop.setProperty("mail.transport.protocol", "smtp");
	     prop.setProperty("mail.smtp.auth", "true");

//	 	Session session=Session.getInstance(prop,new Authenticator() {
//			public PasswordAuthentication getPasswordAuthentication() { 
//				return new PasswordAuthentication("18131166590@163.", "");
//			}
//
//		});
//			
	     
	     //使用JavaMail发送邮件的5个步骤
	     //1、创建session
        Session session = Session.getInstance(prop);
	     //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	     session.setDebug(true);
	      //2、通过session得到transport对象
	     Transport ts = session.getTransport("smtp");
		  //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和 给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
		 ts.connect("smtp.163.com", "18131166590@163.com", "1qaz2wsx");
		 
		 
		 
		  //4、创建邮件
		 Message message = createSimpleMail(session);
//		 Transport.send(message);
//		  5、发送邮件
	     ts.sendMessage(message, message.getAllRecipients());
		 ts.close();
 
	}
	
	 public static MimeMessage createSimpleMail(Session session)
	            throws Exception {
	        //创建邮件对象
	        MimeMessage message = new MimeMessage(session);
	        //指明邮件的发件人
	        message.setFrom(new InternetAddress("18131166590@163.com"));
	        //指明邮件的收件人，
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1535937433@qq.com"));
	        //邮件的标题
	        message.setSubject("只包含文本的简单邮件");
	        //邮件的文本内容
	        message.setContent("你好啊！", "text/html;charset=UTF-8");
	        //返回创建好的邮件对象
	        return message;
	    }
	}
/*
 * 带附件的邮件	
 * @param session
 * @return
 * @throws Exception
 
	public static MimeMessage createAttachMail(Session session) throws Exception{
		
	   MimeMessage message = new MimeMessage(session);	  
	//设置邮件的基本信息
	   //发件人
	   message.setFrom(new InternetAddress("18131166590@163.com"));
	      //收件人
       message.setRecipient(Message.RecipientType.TO, new InternetAddress("1535937433@qq.com"));
	        //邮件标题
       message.setSubject("JavaMail邮件发送测试");
        
	      //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码  
	        MimeBodyPart text = new MimeBodyPart();
	         text.setContent("使用JavaMail创建的带附件的邮件", "text/html;charset=UTF-8");
	     /* 
	      //创建邮件附件
		      MimeBodyPart attach = new MimeBodyPart();
		      DataHandler dh = new DataHandler(new FileDataSource("src\\2.jpg"));
	          attach.setDataHandler(dh);
		      attach.setFileName(dh.getName());  
		 */
		        
/*	       //创建容器描述数据关系
	       MimeMultipart mp = new MimeMultipart();
	       mp.addBodyPart(text);
	      //邮件 mp.addBodyPart(attach);
	       mp.setSubType("mixed");
       
	       message.setContent(mp);
	       message.saveChanges();
	       //将创建的Email写入到E盘存储
	       //返回生成的邮件
		         return message;
		     }
		 }
		 
 **/


