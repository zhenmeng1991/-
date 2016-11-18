package ARTICLE;

import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

public class grammerError {
	public static String inputFileName = grammerEveluation.address.getText().replace("\\", "//");
//	public static String inputFileName = "C://Users//123//Desktop//实验.rdf";
	
	public static String main(String args) {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel();  
	      
        // 使用 FileManager 查找文件  
        InputStream in = FileManager.get().open( inputFileName );  
        if (in == null) {  
            throw new IllegalArgumentException(  
                                     "File: " + inputFileName + " not found");  
        }  
  
        // 读取RDF/XML 文件  
//        model.read(in, null); 
        String yufaresult1=new String();
        if (model.read(in, null)!=null) {
        	System.out.println("没有语法错误");
            yufaresult1="1、文档没有语法错误."+"\r\n";
		}else {
			yufaresult1="1、文档存在语法错误."+"\r\n";
		}
        return yufaresult1;
	}
	
}
