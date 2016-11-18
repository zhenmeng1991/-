package ARTICLE;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.apache.xerces.impl.Constants;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;

 public class upLoad {

	/**
	 * @param args
	 */
	 JFrame frame = new JFrame("关联书目数据质量评估原型系统");
	 Container c = frame.getContentPane();
	 static JTextField address = new JTextField();
	 static JTextField shchresult1 = new JTextField();
	 static JTextArea result1 = new JTextArea();
	
	static JButton liulan = new JButton("浏览...");
	static JButton shch = new JButton("上传");
	static JButton start = new JButton("开始统计");
	 static JButton next = new JButton("下一步");
	 static  String shchresult=new String();
	 
	static  JCheckBox tongji1 = new JCheckBox();
	 static JCheckBox tongji2 = new JCheckBox();
	static  JCheckBox tongji3 = new JCheckBox();
	 
	public upLoad() {
		// TODO Auto-generated constructor stub{
		frame.setSize(800,700);
		c.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initFrame();
	
		frame.setVisible(true);
	}
public void initFrame() {
	   

		//顶部
		
		//中部表单
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		JLabel title=new JLabel("第一步：上传待评估的关联书目数据文件");
		title.setBounds(250, 50, 400, 20);
		title.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title);
		JLabel l1 = new JLabel("文件地址:");
		l1.setBounds(130, 80, 200, 20);
		fieldPanel.add(l1);
		address.setBounds(190,80,260,20);
		fieldPanel.add(address);
		liulan.setBounds(450, 80, 100, 20);
		fieldPanel.add(liulan);

		shch.setBounds(553, 80, 100, 20);
		fieldPanel.add(shch);
		
		JLabel zhuangtai = new JLabel("上传状态:");
		zhuangtai.setBounds(130, 100, 200, 20);
		fieldPanel.add(zhuangtai);
		
		shchresult1.setBounds(190, 100, 200, 20);
		fieldPanel.add(shchresult1);
		
		JLabel title2=new JLabel("第二步：开始进行统计性评估");
		title2.setBounds(250, 130, 300, 20);
		title2.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title2);
	
		
	    tongji1.setText("三元组总数量、存在数据问题的主谓宾数量、各类型客体资源数量");
	    tongji1.setMnemonic(KeyEvent.VK_C);
	    tongji1.setSelected(false);
	    tongji1.setBounds(190, 160,800, 20);
	    fieldPanel.add(tongji1);
	    
	    tongji2.setText("主体去重后数量、谓词去重后数量、sameAs与seeAlso链接数量、外链与内敛数量");
	    tongji2.setMnemonic(KeyEvent.VK_C);
	    tongji2.setSelected(false);
	    tongji2.setBounds(190, 190,800, 20);
	    fieldPanel.add(tongji2);
			    
	    tongji3.setText("关联字段数量、命名空间数量、链接数量、链接平均长度");
	    tongji3.setMnemonic(KeyEvent.VK_C);
	    tongji3.setSelected(false);
	    tongji3.setBounds(190, 220,800, 20);
	    fieldPanel.add(tongji3);
	    
	    
		start.setBounds(300, 250, 100, 30);
		fieldPanel.add(start);
		
		result1.setBounds(200,300,500,290);
		fieldPanel.add(result1);
		JLabel l2 = new JLabel("统计结果为:");
		l2.setBounds(130, 300, 200, 20);
		fieldPanel.add(l2);		
		next.setBounds(300, 600, 100, 30);
		fieldPanel.add(next);
		
		c.add(fieldPanel,"Center");
		
		//底部按钮

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new upLoad();
		liulan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
//				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.showOpenDialog(null);
				String path=chooser.getSelectedFile().getPath();
//				System.out.println(path);
				address.setText(path);
			}
		});
		shch.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String path=address.getText();					   
				if (path==null) {
				     shchresult="上传失败！";				    				     
				}else {
					 shchresult="上传成功！";
				};
				shchresult1.setText(shchresult);
			}
		});
		
		start.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String a=new String();
			 if (tongji1.isSelected()) {
	             a=new tripleStatistics().main(address.getText().replace("\\", "//"));
	             result1.setText(a);
			};
			 String b=new String();
			if (tongji2.isSelected()) {
				 b=new subjectDuplicateRemoval().main(address.getText().replace("\\", "//"))+new propertyDuplicateRemoval().main(address.getText().replace("\\", "//"))+new sameAsAndseeAlsoDetection().main(address.getText().replace("\\", "//"))+new detectionForwardOrBackwardLinks().main(address.getText().replace("\\", "//"));
				//b=new subjectDuplicateRemoval().main(address.getText().replace("\\", "//"));
				//b=new propertyDuplicateRemoval().main(address.getText().replace("\\", "//"));
				result1.setText(a+b);
			};
			
			 String c=new String();
			if (tongji3.isSelected()) {
				 c=new detectionLinkedDataSet().main(address.getText().replace("\\", "//"))+new schemaResources().main(address.getText().replace("\\", "//"))+new uriStatistics().main(address.getText().replace("\\", "//"));
				result1.setText(a+b+c);
			};
			
			}
		});
		next.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				new grammerEveluation();
				new grammerEveluation().initFrame();
			};
		});

	}

}
