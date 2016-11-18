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

public class tripleStatistics {
	//public static String inputFileName = "C://Users//123//Desktop//BNBLODB_3000.rdf";
	public static String inputFileName = upLoad.address.getText().replace("\\", "//");

	/**
	 * @param args
	 */
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
  
        //model.write(System.out);  
        int i=0;
        int j=0;
        int k=0;
        int h=0;
        int m=0;
        int n=0;
        StmtIterator iter = model.listStatements();
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();  
            Resource subject = stmt.getSubject();  
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();
            
            String s1=subject.toString();
            String s2=predicate.toString();    
            String s3=object.toString();

            
            if (s1.contains("http://")) {
                j++;
			}else {
				System.out.println(s1);
			}
            if (s2.contains("http://")) {
                k++;
			}
            if (s3.contains("http://")||(s3.length()>0 )) {
                h++;
			}else {
				System.out.println(s1+s2+s3);
			}
            if(object instanceof Resource && object.isURIResource()){
              m++;
          }  
            if( object.isLiteral()){ 
              n++;
          }              
     
           i++;               
        }
//        System.out.println("一、statment共计"+i+"条.");
//        System.out.println("二、问题主语共计"+(i-j)+"条.");
//        System.out.println("三、问题谓语共计"+(i-k)+"条.");
//        System.out.println("四、问题宾语共计"+(i-h)+"条.");
//        System.out.println("五、object为 URI资源的statment共计"+m+"条.");
//        System.out.println("六、object为literal资源的statment共计"+n+"条.");
        String tongjiresult1=new String();
        tongjiresult1="1、文档的三元组总量为"+i+"条."+"\r\n"+"2、URI类型客体数量为"+m+"条."+"\r\n"+"3、数值类型客体数量为"+n+"条."+"\r\n"+"4、问题主语共计"+(i-j)+"条."+"\r\n"+"5、问题谓语共计"+(i-k)+"条."+"\r\n"+"6、问题宾语共计"+(i-h)+"条."+"\r\n";
        return tongjiresult1;
 }
}

