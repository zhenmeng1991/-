package ARTICLE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class NTripleFilter {

	/**
	 * @param args
	 */
	public static String inputFileName = "C://Users//123//Desktop//1.nt";
	public static String inputFileName1 = "C://Users//123//Desktop//2.nt";
	public static String inputFileName3 = "C://Users//123//Desktop//3.nt";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Model model = ModelFactory.createDefaultModel(); 
		 model.read(inputFileName); 
		 StmtIterator iter = model.listStatements();
		 int n=0;
		 Set allurl=new HashSet();
		 while(iter.hasNext()){  
	            Statement stmt = iter.nextStatement();  
	            Resource subject = stmt.getSubject();  
	            Property predicate = stmt.getPredicate();
	            RDFNode object = stmt.getObject();
	            
	            String s1=subject.toString();
	            String s2=predicate.toString();
           	    String s3=object.toString();     	    
	            if(s2.contains("http://iflastandards.info/ns/isbd/elements/P1154")){ 		            
		            allurl.add(s1); 	            
	            	
	            	n++;
//		            System.out.print(subject.toString()+"  ");  
//		            System.out.print(" "+predicate.toString()+"  ");   
//	                 if(object instanceof Resource){  
//	                System.out.print(object.toString()+".\n");  
//	            }else{  
//	                System.out.print("\"" + object.toString() + "\""+".\n");  
//	            }
	            } 
	            //System.out.println(".");             
	        }

		 Model model1 = ModelFactory.createDefaultModel();
		 Model model2 = ModelFactory.createDefaultModel();
		 model1.read(inputFileName1); 
		 StmtIterator iter1 = model1.listStatements();
		 while(iter1.hasNext()){  
	            Statement stmt1 = iter1.nextStatement();  
	            Resource subject1 = stmt1.getSubject();  
	            Property predicate1 = stmt1.getPredicate();
	            RDFNode object1 = stmt1.getObject();
	            
	            if(allurl.contains(subject1.toString())){ 		                        
	            	model2.add(subject1, predicate1, object1);
	            	
		            System.out.print(subject1.toString()+"  ");  
		            System.out.print(" "+predicate1.toString()+"  ");   
	                 if(object1 instanceof Resource){  
	                System.out.print(object1.toString()+".\n");  
	            }else{  
	                System.out.print("\"" + object1.toString() + "\""+".\n");  
	            }
	            }  
		 }

		 Set urlobject2=new HashSet();
		 StmtIterator iter2 = model2.listStatements();
		 while(iter2.hasNext()){
		 Statement stmt2 = iter2.nextStatement();	 
		 Resource subject2 = stmt2.getSubject();  
         Property predicate2 = stmt2.getPredicate();
         RDFNode object2 = stmt2.getObject();
         
         if (object2.isURIResource()) {
			urlobject2.add(object2.toString());
		}
		 }
		 System.out.println(urlobject2.size());
		 
		 Model model3 = ModelFactory.createDefaultModel(); 
		 model3.read(inputFileName3); 
		 StmtIterator iter3 = model3.listStatements();
		 
		 while(iter3.hasNext()){  
	            Statement stmt3 = iter3.nextStatement();  
	            Resource subject3 = stmt3.getSubject();  
	            Property predicate3 = stmt3.getPredicate();
	            RDFNode object3 = stmt3.getObject();
	            
	            if (urlobject2.contains(subject3.toString())) {
	            	model2.add(subject3, predicate3, object3);
					
				}
		 }
		 System.out.println(model2.size());
		 
		 
	       String filename = "C://Users//123//Desktop//NLS.nt";
		      File outfile=new File(filename);
		      if(!outfile.exists())
		      {
		         outfile.createNewFile();
		         OutputStream out=new FileOutputStream(outfile,true);
				 model2.write(out, "N-TRIPLE");
	             out.close();
		      }

	}

}
