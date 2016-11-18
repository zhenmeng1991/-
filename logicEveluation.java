package ARTICLE;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class logicEveluation {

	/**
	 * @param args
	 */
	static JFrame frame = new JFrame("关联书目数据质量评估原型系统");
	static Container c = frame.getContentPane();
	static JTextArea result1 = new JTextArea();
	public static JTextField mustHave1 = new JTextField();
	static JTextField mustConstructrue = new JTextField();
	static JTextField mustConstructrue1 = new JTextField();
	static JTextField mustRelation = new JTextField();
	static JTextField mustRelation1 = new JTextField();
	static JTextField mustRelation2 = new JTextField();
	static JTextField mustRange = new JTextField();
	static JTextField mustRange1 = new JTextField();
	static JTextField mustRange2 = new JTextField();
	static JTextField address = new JTextField();
	static JTextField shchresult1 = new JTextField();
	static JButton liulan = new JButton("浏览...");
	static JButton shch = new JButton("上传");
	 static  String shchresult=new String();
	 static String allresult=new String();

	static JButton start = new JButton("开始统计");
	static JButton download = new JButton("保存整个报告");
	
	public logicEveluation() {
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
		JLabel title=new JLabel("第四步：开始逻辑性质量评估");
		title.setBounds(250, 20, 400, 20);
		title.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title);
		
		JLabel l = new JLabel("文件地址:");
		l.setBounds(130, 50, 200, 20);
		fieldPanel.add(l);
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
		
		JLabel l1 = new JLabel("参数设置:");
		l1.setBounds(130, 100, 200, 20);
		fieldPanel.add(l1);
		
		JLabel l3 = new JLabel("1、必备字段检测（将必备字段的完整URL给出）");
		l3.setBounds(200, 100, 400, 20);
		fieldPanel.add(l3);
		mustHave1.setBounds(200,120,260,20);
		fieldPanel.add(mustHave1);
		
		JLabel l4 = new JLabel("2、字段属性值表达约束，分别填写谓词URI和约束规则");
		l4.setBounds(200, 140, 400, 20);
		fieldPanel.add(l4);
		mustConstructrue.setBounds(200,160,260,20);
		mustConstructrue1.setBounds(500,160,260,20);
		fieldPanel.add(mustConstructrue);
		fieldPanel.add(mustConstructrue1);
		
		JLabel l5 = new JLabel("3、字段间函数关系检测，如(deathDate > birthDate)");
		l5.setBounds(200, 180, 400, 20);
		fieldPanel.add(l5);
		mustRelation.setBounds(200,200,200,20);
		mustRelation1.setBounds(550,200,200,20);
		mustRelation2.setBounds(425,200,100,20);
		fieldPanel.add(mustRelation);
		fieldPanel.add(mustRelation1);
		fieldPanel.add(mustRelation2);
		
		JLabel l6 = new JLabel("4、属性值合理性检测，如(Foaf:age取值在[1,150]之内)");
		l6.setBounds(200, 220, 400, 20);
		fieldPanel.add(l6);
		mustRange.setBounds(200,240,260,20);
		mustRange1.setBounds(500,240,60,20);
		mustRange2.setBounds(600,240,60,20);
		fieldPanel.add(mustRange);
		fieldPanel.add(mustRange1);
		fieldPanel.add(mustRange2);
		
		start.setBounds(300, 260, 100, 30);
		fieldPanel.add(start);
		
		result1.setBounds(200,300,500,290);
		fieldPanel.add(result1);
		JLabel l2 = new JLabel("评估结果为:");
		l2.setBounds(130, 300, 200, 20);
		fieldPanel.add(l2);		
		download.setBounds(300, 600, 120, 30);
		fieldPanel.add(download);
		
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
			 if (mustHave1.getText().contains("http://")) {
				 a=new mustHave().main(address.getText().replace("\\", "//"));
				 result1.setText(a);
			};
			String b=new String();
			if (mustConstructrue.getText().contains("http://")&& mustConstructrue1.getText()!=null) {
				 b=new expressionConstraints().main(address.getText().replace("\\", "//"));
				 result1.setText(a+b);
			}
			
			String c=new String();
			if (mustRange.getText().contains("http://")&& mustRange1.getText()!=null&&mustRange2.getText()!=null) {
				 c=new mustRange().main(address.getText().replace("\\", "//"));
				 result1.setText(a+b+c);
			}
		};
	});
		
		download.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
    allresult=upLoad.result1.getText()+"\r\n"+grammerEveluation.result1.getText()+"\r\n"+result1;
    System.out.println(allresult);
				
			};
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new logicEveluation();
}
}
