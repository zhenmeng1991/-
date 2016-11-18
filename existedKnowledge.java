package ARTICLE;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class existedKnowledge {

	/**
	 * @param args
	 */
	static JFrame frame = new JFrame("关联书目数据质量评估原型系统");
	static Container c = frame.getContentPane();	
	
	public existedKnowledge () {
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
		
		JLabel title1=new JLabel("1 国家图书馆关联字段查询");
		title1.setBounds(50, 20, 400, 20);
		title1.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title1);
		
		JLabel l1 = new JLabel("国家:");
		l1.setBounds(50, 50, 200, 20);
		fieldPanel.add(l1);
		
		final JTextField country1 = new JTextField();
		country1.setBounds(90,50,100,20);
		fieldPanel.add(country1);
		
		JButton search1 = new JButton("查询");
		search1.setBounds(300,50,70,20);
		fieldPanel.add(search1);
		
		final JTextField linkedfield = new JTextField();
		linkedfield.setBounds(50,80,500,80);
		fieldPanel.add(linkedfield);
		
		JLabel title2=new JLabel("2 常见书目字段描述查询");
		title2.setBounds(50, 170, 400, 20);
		title2.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title2);
		
		JLabel l2 = new JLabel("国家:");
		l2.setBounds(50, 200, 200, 20);
		fieldPanel.add(l2);
		
		final JTextField country2 = new JTextField();
		country2.setBounds(90,200,50,20);
		fieldPanel.add(country2);
		
		JLabel l3 = new JLabel("字段:");
		l3.setBounds(150, 200, 200, 20);
		fieldPanel.add(l3);
		
		final JTextField field1 = new JTextField();
		field1.setBounds(190,200,100,20);
		fieldPanel.add(field1);
		
		JButton search2 = new JButton("查询");
		search2.setBounds(300,200,70,20);
		fieldPanel.add(search2);
		
		final JTextField descripedfield = new JTextField();
		descripedfield.setBounds(50,230,500,80);
		fieldPanel.add(descripedfield);
		
		JLabel title3=new JLabel("3 常见字段关联资源查询");
		title3.setBounds(50, 320, 400, 20);
		title3.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title3);
		
		JLabel l4 = new JLabel("国家:");
		l4.setBounds(50, 350, 200, 20);
		fieldPanel.add(l4);
		
		final JTextField country3 = new JTextField();
		country3.setBounds(90,350,50,20);
		fieldPanel.add(country3);
		
		JLabel l5 = new JLabel("字段:");
		l5.setBounds(150, 350, 200, 20);
		fieldPanel.add(l5);
		
		final JTextField field2 = new JTextField();
		field2.setBounds(190,350,100,20);
		fieldPanel.add(field2);
		
		JButton search3 = new JButton("查询");
		search3.setBounds(300,350,70,20);
		fieldPanel.add(search3);
		
		final JTextField linkedresource = new JTextField();
		linkedresource.setBounds(50,380,500,80);
		fieldPanel.add(linkedresource);
		
		JLabel title4=new JLabel("4 评估结果查询查询");
		title4.setBounds(50, 470, 400, 20);
		title4.setFont(new  java.awt.Font("Dialog",   1,   15));
		fieldPanel.add(title4);
		
		JLabel l6 = new JLabel("关键词:");
		l6.setBounds(50, 500, 200, 20);
		fieldPanel.add(l6);
		
		final JTextField keywords = new JTextField();
		keywords.setBounds(100,500,100,20);
		fieldPanel.add(keywords);
		
		JButton search4 = new JButton("查询");
		search4.setBounds(300,500,70,20);
		fieldPanel.add(search4);
		
		JTextField evaluationresults = new JTextField();
		evaluationresults.setBounds(50,530,500,80);
		fieldPanel.add(evaluationresults);	
		
		c.add(fieldPanel,"Center");
		//底部按钮

		search1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!(country1.getText()==null)) {
					if (country1.getText().equals("英国")) {
						linkedfield.setText("英国书目数据集关联字段主要有:"+"   责任者项；主题项；语言项；出版地；版本载体项");
					}
					if (country1.getText().equals("德国")) {
						linkedfield.setText("德国书目数据集关联字段主要有:"+"   主题项；语言项");
					}
					
				}
				
			}
		});
		
		search2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (country2.getText()!=null&& field1.getText()!=null) {
					if (country2.getText().equals("英国")) {
						if (field1.getText().equals("责任者项")) {
							descripedfield.setText("英国  书目数据中  责任者项  的描述谓词为  dct:contributor；dct:creator");
						}
						if (field1.getText().equals("主题项")) {
							descripedfield.setText("英国  书目数据中  主题项  的描述谓词为  dct:subject");
						}
						if (field1.getText().equals("语言项")) {
							descripedfield.setText("英国  书目数据中  语言项  的描述谓词为  dct:language");
						}
						if (field1.getText().equals("出版地")) {
							descripedfield.setText("英国  书目数据中  出版地  的描述谓词为  dct:spatial");
						}
					}
				}
				
			}
		});
		
		search3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (country3.getText()!=null&& field2.getText()!=null) {
					if (country3.getText().equals("英国")) {
						if (field2.getText().equals("责任者项")) {
							linkedresource.setText("英国  书目数据中  责任者项  的关联资源为  ISNI；BNB；VIAF  数据集");
						}
						if (field2.getText().equals("主题项")) {
							linkedresource.setText("英国  书目数据中  主题项  的关联资源为  LCSH；DDC  数据集");
						}
						if (field2.getText().equals("语言项")) {
							linkedresource.setText("英国  书目数据中  语言项  的关联资源为  Lexvo  数据集");
						}
						if (field2.getText().equals("出版地")) {
							linkedresource.setText("英国  书目数据中  出版地  的关联资源为  Geo  数据集");
						}
					}
				}
				
			}
		});
		
		search4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (keywords.getText()!=null) {
					
				}
				
			}
		});
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new existedKnowledge(); 
	}

}
