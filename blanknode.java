package ARTICLE;

import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

public class blanknode {

	/**
	 * @param args
	 */
	public static String inputFileName = grammerEveluation.address.getText().replace("\\", "//");
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
        model.read(in, null);  
//		model.read(inputFileName); 
        int i=0;
        int h=0;
        StmtIterator iter = model.listStatements();
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();  
            Resource subject = stmt.getSubject();  
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();
            
            String s1=subject.toString();
            String s2=predicate.toString();    
            String s3=object.toString();

            if (!s1.contains("http://")&&(s1.length()>0 )) {
                h++;
                System.out.println(s1+s2+s3);
			}          
     
           i++;               
        }

        System.out.println("四、 空白节点共计"+h+"条.");
        String yufaresult1=new String();
        yufaresult1="4、空白节点共计"+h+"条."+"\r\n";
        return yufaresult1;
	}

}
