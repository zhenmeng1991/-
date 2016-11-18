package ARTICLE;

import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

public class URIavailable {
    public static String inputFileName = "C://Users//123//Desktop//葡萄牙实验数据（3000条）.rdf";  
    
    public static void main(String[] args){  
        Model model = ModelFactory.createDefaultModel();  
  
//         使用 FileManager 查找文件  
        InputStream in = FileManager.get().open( inputFileName );  
        if (in == null) {  
            throw new IllegalArgumentException(  
                                     "File: " + inputFileName + " not found");  
        }   
        // 读取RDF/XML 文件  
        model.read(in, null); 
//		model.read(inputFileName); 
        
        int m=0;
        double a=0;
        StmtIterator iter = model.listStatements();
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();  
            Resource subject = stmt.getSubject(); 
            RDFNode object = stmt.getObject();
                
            if(object instanceof Resource && object.isURIResource() && object.toString().contains("http://")){   
                URL url;  
                a++;
                try {  
                     url = new URL(object.toString());  
                     InputStream input = url.openStream();  
                     System.out.println("链接可用"); 
                     
                } catch (Exception e1) {  
                     System.out.println("链接打不开!具体信息为"+e1.getCause()); 
                     System.out.println(object.toString());
                     m++;
                     url = null;  
                     System.out.println("出错比率为"+m+"   "+a+"    "+(m/a));
                     
                }
            }   
            
        }
        System.out.println("二、失效链接数量共计"+m+"个"); 
	}

}
