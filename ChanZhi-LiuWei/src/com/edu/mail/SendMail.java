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
	     
	     //ʹ��JavaMail�����ʼ���5������
	     //1������session
        Session session = Session.getInstance(prop);
	     //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
	     session.setDebug(true);
	      //2��ͨ��session�õ�transport����
	     Transport ts = session.getTransport("smtp");
		  //3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����� ��smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
		 ts.connect("smtp.163.com", "18131166590@163.com", "1qaz2wsx");
		 
		 
		 
		  //4�������ʼ�
		 Message message = createSimpleMail(session);
//		 Transport.send(message);
//		  5�������ʼ�
	     ts.sendMessage(message, message.getAllRecipients());
		 ts.close();
 
	}
	
	 public static MimeMessage createSimpleMail(Session session)
	            throws Exception {
	        //�����ʼ�����
	        MimeMessage message = new MimeMessage(session);
	        //ָ���ʼ��ķ�����
	        message.setFrom(new InternetAddress("18131166590@163.com"));
	        //ָ���ʼ����ռ��ˣ�
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1535937433@qq.com"));
	        //�ʼ��ı���
	        message.setSubject("ֻ�����ı��ļ��ʼ�");
	        //�ʼ����ı�����
	        message.setContent("��ð���", "text/html;charset=UTF-8");
	        //���ش����õ��ʼ�����
	        return message;
	    }
	}
/*
 * ���������ʼ�	
 * @param session
 * @return
 * @throws Exception
 
	public static MimeMessage createAttachMail(Session session) throws Exception{
		
	   MimeMessage message = new MimeMessage(session);	  
	//�����ʼ��Ļ�����Ϣ
	   //������
	   message.setFrom(new InternetAddress("18131166590@163.com"));
	      //�ռ���
       message.setRecipient(Message.RecipientType.TO, new InternetAddress("1535937433@qq.com"));
	        //�ʼ�����
       message.setSubject("JavaMail�ʼ����Ͳ���");
        
	      //�����ʼ����ģ�Ϊ�˱����ʼ����������������⣬��Ҫʹ��charset=UTF-8ָ���ַ�����  
	        MimeBodyPart text = new MimeBodyPart();
	         text.setContent("ʹ��JavaMail�����Ĵ��������ʼ�", "text/html;charset=UTF-8");
	     /* 
	      //�����ʼ�����
		      MimeBodyPart attach = new MimeBodyPart();
		      DataHandler dh = new DataHandler(new FileDataSource("src\\2.jpg"));
	          attach.setDataHandler(dh);
		      attach.setFileName(dh.getName());  
		 */
		        
/*	       //���������������ݹ�ϵ
	       MimeMultipart mp = new MimeMultipart();
	       mp.addBodyPart(text);
	      //�ʼ� mp.addBodyPart(attach);
	       mp.setSubType("mixed");
       
	       message.setContent(mp);
	       message.saveChanges();
	       //��������Emailд�뵽E�̴洢
	       //�������ɵ��ʼ�
		         return message;
		     }
		 }
		 
 **/


