package com.edu.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class AnalyzeHtml {
	//ģ���ļ�λ��
	private static final String DEFAULT_TEMPLATE = "conf/reportTemplate.html";  
	
	   public String getTemplatePath() {   
	        return "";   
	    }  
	   
	   public String run(Map context) throws Exception{   
	    	return executeFreemarker(context); 
	    } 
	   //ִ��fm
	   private String executeFreemarker(Map context)throws Exception{   
	    
//		   String content="";
	   
	        Configuration cfg = new Configuration();  
	        // ͨ��Freemaker��Configuration��ȡ��Ӧ��ģ��
	        
	        
	        cfg.setDirectoryForTemplateLoading(   
	                new File(getTemplatePath()));   
	        cfg.setEncoding(Locale.CHINA, "UTF-8");
	        cfg.setObjectWrapper(new DefaultObjectWrapper());              
	        cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250)); 
	        // ��ģ���ļ�Ŀ¼���ҵ�ģ��
	        Template temp = cfg.getTemplate(getTemplate());  
	        // ͨ��Template���Խ�ģ���ļ��������Ӧ����
	        StringWriter out = new StringWriter();  
	        //�ض��������
	        temp.process(context, out);   
	        //System.out.print(out.toString());
	        //???
	        return out.toString();
	    }  
	   
	   
	   public String getTemplate() {   
	        // TODO Auto-generated method stub   
	        return DEFAULT_TEMPLATE;   
	    }     

	
	
	
}
