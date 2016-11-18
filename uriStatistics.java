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

public class uriStatistics {
    public static String inputFileName = upLoad.address.getText().replace("\\", "//"); 
    
    public static String main(String args){  
        Model model = ModelFactory.createDefaultModel();  
  
        // 使用 FileManager 查找文件  
        InputStream in = FileManager.get().open( inputFileName );  
        if (in == null) {  
            throw new IllegalArgumentException(  
                                     "File: " + inputFileName + " not found");  
        }   
        // 读取RDF/XML 文件  
        model.read(in, null); 
//		model.read(inputFileName); 
        
        int n=0;
        int k=0;
        int URIobjectlength=0;
        int uriSubjectlength=0;
        
        StmtIterator iter = model.listStatements();
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();  
            Resource subject = stmt.getSubject(); 
            RDFNode object = stmt.getObject();
                
            if(object instanceof Resource && object.isURIResource()){  
            	n++;
            	URIobjectlength=URIobjectlength+object.toString().length();  
            }   
            
            if (subject.isURIResource()&&subject.toString().contains("http://")) {
            	k++;
				uriSubjectlength=uriSubjectlength+subject.toString().length();
			}
        }
        System.out.println("一、链接数量共计"+n+"个");
        System.out.println("三、链接平均长度为"+(URIobjectlength/n)+"位");
        System.out.println("四、本数据集URI设置平均长度为"+(uriSubjectlength/k)+"位");
        String tongjiresult3=new String();
        tongjiresult3="15、链接数量共计"+n+"个."+"\r\n"+"16、本数据集URI设置平均长度为"+(uriSubjectlength/k)+"位."+"\r\n";
        return tongjiresult3;
        
	}

}

