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
    static String from = "��ޱ";
	public static void sendMail(String email, String subject, String body) throws Exception {
		// TODO Auto-generated method stub
		 Properties prop = new Properties();
	     prop.setProperty("mail.host", "smtp.163.com");
		 prop.setProperty("mail.transport.protocol", "smtp");
	     prop.setProperty("mail.smtp.auth", "true");     
	     //ʹ��JavaMail�����ʼ���5������
	     //1������session
        Session session = Session.getInstance(prop);
	     //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
	     session.setDebug(true);
	      //2��ͨ��session�õ�transport����
	     Transport ts = session.getTransport("smtp");
		  //3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����� ��smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
		 ts.connect(server,user ,password );
		 //4�������ʼ�
		 //�����ʼ�����
	     MimeMessage message = new MimeMessage(session);
	     //ָ���ʼ��ķ�����
         message.setFrom(new InternetAddress(user));
         
         InternetAddress fromAddress = new InternetAddress(user,from,"UTF-8");
         message.setFrom(fromAddress);
         String emailList[]=email.split(",");
         InternetAddress[] toAddress = new InternetAddress[emailList.length];
         
         for(int i=0;i<emailList.length;i++)
         {
         	toAddress[i]=new InternetAddress(emailList[i]);
         }
         //ָ���ʼ����ռ��ˣ�
         message.addRecipients(Message.RecipientType.TO, toAddress);
         message.setSubject(subject, "UTF-8");   
         message.setContent(body, "text/html;charset=utf-8");
         message.saveChanges();
//		 Transport.send(message);
//		  5�������ʼ�
		 
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
//	        //�����ʼ�����
//	        MimeMessage message = new MimeMessage(session);
//	        //ָ���ʼ��ķ�����
//	        message.setFrom(new InternetAddress("18131166590@163.com"));
//	        //ָ���ʼ����ռ��ˣ�
//	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1535937433@qq.com"));
//	        //�ʼ��ı���
//	        message.setSubject("��֪��Ŀ���Ա���_��ޱ");
//	        //�����ʼ����ģ�Ϊ�˱����ʼ����������������⣬��Ҫʹ��charset=UTF-8ָ���ַ�����  
//	        MimeBodyPart text = new MimeBodyPart();
//	        //�ʼ����ı�����
//	        text.setContent("���Ա����ڸ�������", "text/html;charset=UTF-8");
//	      
//	        //�����ʼ�����
//		     MimeBodyPart attach = new MimeBodyPart();
//		     DataHandler dh = new DataHandler(new FileDataSource("D:/GitHubCode/ChiZhiProj/ChanZhi-LiuWei/test-output/index.html"));
//	         attach.setDataHandler(dh);
//		     attach.setFileName(dh.getName());  
//		 
//		        
//		  //���������������ݹ�ϵ
//	        MimeMultipart mp = new MimeMultipart();
//	        mp.addBodyPart(text);
//	        mp.addBodyPart(attach);
//	        mp.setSubType("mixed");
//       
//	        message.setContent(mp);
//	        message.saveChanges();
//	      //��������Emailд�뵽E�̴洢
//	        message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
//	      //�������ɵ��ʼ�
//		    return message;
//	        
//	    }
//	}
