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
	//模板文件位置
	private static final String DEFAULT_TEMPLATE = "conf/reportTemplate.html";  
	
	   public String getTemplatePath() {   
	        return "";   
	    }  
	   
	   public String run(Map context) throws Exception{   
	    	return executeFreemarker(context); 
	    } 
	   //执行fm
	   private String executeFreemarker(Map context)throws Exception{   
	    
//		   String content="";
	   
	        Configuration cfg = new Configuration();  
	        // 通过Freemaker的Configuration读取相应的模板
	        
	        
	        cfg.setDirectoryForTemplateLoading(   
	                new File(getTemplatePath()));   
	        cfg.setEncoding(Locale.CHINA, "UTF-8");
	        cfg.setObjectWrapper(new DefaultObjectWrapper());              
	        cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250)); 
	        // 在模板文件目录中找到模板
	        Template temp = cfg.getTemplate(getTemplate());  
	        // 通过Template可以将模板文件输出到相应的流
	        StringWriter out = new StringWriter();  
	        //重定向输出流
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
