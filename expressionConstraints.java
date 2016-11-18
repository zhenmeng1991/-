package ARTICLE;

import java.io.InputStream;
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

public class expressionConstraints {

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
            
            if (logicEveluation.mustConstructrue.getText()!=null&&s2.equals(logicEveluation.mustConstructrue.getText())) {
//            	Pattern pat = Pattern.compile(logicEveluation.mustConstructrue1.getText()); 
//            	Matcher mat = pat.matcher(s3); 
//            	mat.find();
//            	^(0|[1-9]\d*)$
            	if (s3.matches(logicEveluation.mustConstructrue1.getText())) {
				}else {
					System.out.println(s3+"     "+logicEveluation.mustConstructrue1.getText());
					k++;
				}
			}
            
        }

        String logicresult2=new String();
        logicresult2="2、不满足约束规则的客体实体有"+k+"条."+"\r\n";
        return logicresult2;
		
	}

}
