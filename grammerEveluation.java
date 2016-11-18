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

public class grammerEveluation {

	/**
	 * @param args
	 */
	static JFrame frame = new JFrame("关联书目数据质量评估原型系统");
	static Container c = frame.getContentPane();
	static JTextField address = new JTextField();
	static JTextField shchresult1 = new JTextField();
	static JButton liulan = new JButton("浏览...");
	static JButton shch = new JButton("上传");
	
	static JTextArea result1 = new JTextArea();
	static JButton start = new JButton("开始语法评估");
	static JButton next = new JButton("下一步");
	 static  String shchresult=new String();
	static  JCheckBox yufa1 = new JCheckBox();
	static  JCheckBox yufa2 = new JCheckBox();
	static  JCheckBox yufa3 = new JCheckBox();
	static  JCheckBox yufa4 = new JCheckBox();
	static  JCheckBox yufa5 = new JCheckBox();
	
	public grammerEveluation() {
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
		JLabel title=new JLabel("第三步：开始进行数据语法评估");
		title.setBounds(250, 20, 400, 20);
		title.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title);
		
		JLabel l1 = new JLabel("文件地址:");
		l1.setBounds(130, 50, 200, 20);
		fieldPanel.add(l1);
		address.setBounds(190,50,260,20);
		fieldPanel.add(address);
		liulan.setBounds(450, 50, 100, 20);
		fieldPanel.add(liulan);
		shch.setBounds(553, 50, 100, 20);
		fieldPanel.add(shch);
		JLabel zhuangtai = new JLabel("上传状态:");
		zhuangtai.setBounds(130, 70, 200, 20);
		fieldPanel.add(zhuangtai);
		shchresult1.setBounds(190, 70, 200, 20);
		fieldPanel.add(shchresult1);
	
		
	    yufa1.setText("语法错误检测（标签封闭、大小写敏感、嵌套、根元素、属性值引号必备、实体引用等）");
	    yufa1.setMnemonic(KeyEvent.VK_C);
	    yufa1.setSelected(false);
	    yufa1.setBounds(190, 100,800, 20);
	    fieldPanel.add(yufa1);
	    
	    yufa2.setText("属性未定义检测、类未定义检测（以LOV词表资源为资源库）");
	    yufa2.setMnemonic(KeyEvent.VK_C);
	    yufa2.setSelected(false);
	    yufa2.setBounds(190, 140,800, 20);
	    fieldPanel.add(yufa2);
	    
	    yufa3.setText("属性值类型不匹配检测");
	    yufa3.setMnemonic(KeyEvent.VK_C);
	    yufa3.setSelected(false);
	    yufa3.setBounds(190, 180,800, 20);
	    fieldPanel.add(yufa3);
	    
	    yufa4.setText("空节点检测");
	    yufa4.setMnemonic(KeyEvent.VK_C);
	    yufa4.setSelected(false);
	    yufa4.setBounds(190, 220,800, 20);
	    fieldPanel.add(yufa4);
	    
	    yufa5.setText("属性值缺失检测");
	    yufa5.setMnemonic(KeyEvent.VK_C);
	    yufa5.setSelected(false);
	    yufa5.setBounds(190, 260,800, 20);
	    fieldPanel.add(yufa5);

		start.setBounds(300, 310, 120, 30);
		fieldPanel.add(start);
		
		JLabel l2 = new JLabel("评估结果为:");
		l2.setBounds(150, 320, 200, 20);
		fieldPanel.add(l2);	
		result1.setBounds(150,340,500,290);
		fieldPanel.add(result1);
	
		next.setBounds(300, 640, 100, 30);
		fieldPanel.add(next);
		
		c.add(fieldPanel,"Center");
		
		//底部按钮
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
			 if (yufa1.isSelected()) {
	             a=new grammerError().main(address.getText().replace("\\", "//"));
	             result1.setText(a);
			};
			 String b=new String();
		 if (yufa2.isSelected()) {
            b=new noDefinedClassOrProperty().main(address.getText().replace("\\", "//"));
            result1.setText(a+b);
		};
		 String c=new String();
		 if (yufa3.isSelected()) {
	            c="3、文档未出现属性值与类型不匹配."+"\r\n";
	            result1.setText(a+b+c);
			};
			 String d=new String();
			 if (yufa4.isSelected()) {
		            d=new blanknode().main(address.getText().replace("\\", "//"));
		            result1.setText(a+b+c+d);
				};
			String e1=new String();
			if (yufa5.isSelected()) {
			        e1=new literalobjectmissing().main(address.getText().replace("\\", "//"));
			        result1.setText(a+b+c+d+e1);
			};
			
			}
		});
		next.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				new logicEveluation();
				new logicEveluation().initFrame();
				
			};
		});

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new grammerEveluation();

	}

}
