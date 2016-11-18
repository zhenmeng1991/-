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

public class mustRange {

	/**
	 * @param args
	 */
	public static String inputFileName = logicEveluation.address.getText().replace("\\", "//");
	public static String main(String args) {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel(); 
		InputStream in = FileManager.get().open( inputFileName );  
        if (in == null) {  
            throw new IllegalArgumentException(  
                                     "File: " + inputFileName + " not found");  
        }  
  
        // 读取RDF/XML 文件  
        model.read(in, null);  
        int k=0;
        StmtIterator iter = model.listStatements();        
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();   
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();
                       
            String s1=subject.toString();  
            String s2=predicate.toString();    
            String s3=object.toString();
            
            if (logicEveluation.mustRange.getText()!=null&&s2.equals(logicEveluation.mustRange.getText())) {
            	if (Integer.parseInt(s3)>=Integer.parseInt(logicEveluation.mustRange1.getText())&&Integer.parseInt(s3)<=Integer.parseInt(logicEveluation.mustRange2.getText())) {
				}else {
					System.out.println(s3+"     "+logicEveluation.mustRange1.getText()+"  "+logicEveluation.mustRange2.getText());
					k++;
				}
			}
            
            
        }

        String logicresult2=new String();
        logicresult2="4、不满足值域约束的客体实体有"+k+"条."+"\r\n";
        return logicresult2;
	}

}
