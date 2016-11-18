package ARTICLE;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

public class mustHave {
	public static String inputFileName = logicEveluation.address.getText().replace("\\", "//");
	/**
	 * @param args
	 */
	
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
//		model.read(inputFileName); 
        Set setsubject=new HashSet();
        StmtIterator iter = model.listStatements();
        
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();   
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();
            
            
            String s1=subject.toString();
            if (s1.contains("http://data.theeuropeanlibrary.org/Resource/") && !s1.contains("#") ) {
//            	http://data.theeuropeanlibrary.org/BibliographicResource/
	           setsubject.add(s1); 
            };          
            String s2=predicate.toString();    
            String s3=object.toString();
        }

        Iterator it1= setsubject.iterator();
        int k=0;
        while (it1.hasNext()) {
        	String subject1=it1.next().toString();
         	 String weici=new String();
            if (subject1!=null) {          	 
            	 StmtIterator iter1 = model.listStatements(); 
            	 while(iter1.hasNext()){
                     Statement stmt = iter1.nextStatement();   
                     Resource subject = stmt.getSubject();
                     Property predicate = stmt.getPredicate();
                     RDFNode object = stmt.getObject();
                     
                     
                     String s1=subject.toString();                       
                     String s2=predicate.toString();  
                     if (s1.equals(subject1)) {
                    	 weici=weici+s2;
					}
                 }
          	 String mh=new String();
          	 mh=logicEveluation.mustHave1.getText();
//          	System.out.println(weici+"!!!");
               if (weici.contains(mh)) {
    			}else {
    				System.out.println(subject1+"不具备该属性");
    				k++;
    			}            	 	 
			}
           
        }
        String logicresult2=new String();
        logicresult2="1、不满足属性必备的主体实体有"+k+"条."+"\r\n";
        return logicresult2;
	}
}
