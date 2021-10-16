package cn;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.script.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*��������E_calculator*/
public class E_calculator {
	JButton st;	 // st�����������ڼĴ���
	/* ����i_1��i_5Ϊ״̬���� */
	int i_1 = 1;
	int i_2 = 1; 	// ����2���ڼ�¼���ż��Ĵ���
	int i_3 = 1; 	// ����3���ڱ�ʶ str1 �Ƿ���Ա��� 0
	int i_4 = 1; 	// ����4���ڱ�ʶ str2 �Ƿ���Ա��� 0
	int i_5 = 1;	 // ����5���ڿ���С����ɷ�¼��
	String str1 = "0";	 // ������1��Ϊ�˳���İ�ȫ����ֵ����Ϊ0
	String str2 = "0"; 	// ������2
	String signal = "+";	 // �����
	String result = ""; 	// ������
	Vector vt = new Vector(20, 20);
// ����һ�� JFrame ���󲢳�ʼ��
	JFrame frame = new JFrame("���׼�����"); 
// JTextField������ʾ�����ͼ��������ı���
JTextField TextField = new JTextField(result, 30); 
	JButton clear_Button = new JButton("�� ��"); 	// �����ť
	/* ���ּ�0��9 */
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	// �������ť���Ӽ��˳��Լ�С�����
	JButton button_jia = new JButton("+");
	JButton button_jian = new JButton("��");
	JButton button_cheng = new JButton("*");
	JButton button_chu = new JButton("/");
	JButton button_dy = new JButton("=");
	JButton button_Dian = new JButton(".");
//����E_calculator()�����б�д���ּ�����Ӧ�߼�
	public E_calculator() {
		button0.setMnemonic(KeyEvent.VK_0);
		TextField.setHorizontalAlignment(JTextField.RIGHT);
		JPanel panel = new JPanel();// ����һ�� Jpanel ���󲢳�ʼ��
// ���ø������Ĳ���Ϊ�������У��߾�Ϊ10����
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setSize(500, 800);
		panel.setBackground(Color.gray); 	// ���ñ�����ɫΪ��ɫ
		/* �����ڼ���İ�ť��ӵ������� */
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(button_cheng);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button_chu);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button_jian);
		panel.add(button0);
		panel.add(button_Dian);
		panel.add(button_dy);
		panel.add(button_jia);
// ����panel����ı߾�Ϊ16
		panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));						JPanel panel2 = new JPanel();	// ����ͬ���ķ�ʽ���õڶ���JPanel
		panel2.add(TextField, BorderLayout.WEST);
		panel2.add(clear_Button, BorderLayout.EAST);
		frame.setLocation(400, 200);		// ���������ڳ�������Ļ�ϵ�λ��
		frame.setResizable(true);		// ���ô�����Ե���С
		frame.getContentPane().setLayout(new BorderLayout());
		// �����п��Է��� JPanel���������ǽ����panel�����panel2���細��
		frame.getContentPane().add(panel2, BorderLayout.NORTH);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		/* Listener���б�д�������ּ�����Ӧ�߼�*/
		class Listener implements ActionListener {
			public void actionPerformed(ActionEvent test) {
				String ss = ((JButton) test.getSource()).getText();
				st = (JButton) test.getSource();
				vt.add(st);
				if (i_1 == 1) {
					if (i_3 == 1) {
						str1 = "";
						i_5 = 1;
					}
					str1 = str1 + ss;
					i_3 = i_3 + 1;
					TextField.setText(str1);
				} else if (i_1 == 2) {
					if (i_4 == 1) {
						str2 = "";
						i_5 = 1;
					}
					str2 = str2 + ss;
					i_4 = i_4 + 1;
					TextField.setText(str2);
				}
			}
		}

		/* Listener_signal���б�д��������ż�����Ӧ�߼� */
		class Listener_signal implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String ss2 = ((JButton) e.getSource()).getText();
				st = (JButton) e.getSource();
				vt.add(st);
				if (i_2 == 1) {
					i_1 = 2;
					i_5 = 1;
					signal = ss2;
					i_2 = i_2 + 1;
				} else {
					int a = vt.size();
					JButton c = (JButton) vt.get(a - 2);
					if (!(c.getText().equals("+")) && !(c.getText().equals("��")) 						&& !(c.getText().equals("*"))&& !(c.getText().equals("/"))) {
						cal();
						str1 = result;
						i_1 = 2;
						i_5 = 1;
						i_4 = 1;
						signal = ss2;
					}
					i_2 = i_2 + 1;
				}
			}
		}

		/*Listener_clear���б�д�����������Ӧ�߼�*/
		class Listener_clear implements ActionListener {
			public void actionPerformed(ActionEvent test) {
				st = (JButton) test.getSource();
				vt.add(st);
				i_5 = 1;
				i_2 = 1;
				i_1 = 1;
				i_3 = 1;
				i_4 = 1;
				str1 = "0";
				str2 = "0";
				signal = "";
				result = "";
				TextField.setText(result);
				vt.clear();
			}
		}

		/*Listener_dy���б�д���ǵ��ںż�����Ӧ�߼�*/
		class Listener_dy implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				st = (JButton) e.getSource();
				vt.add(st);
				cal();
				i_1 = 1;
				i_2 = 1;
				i_3 = 1;
				i_4 = 1;
				str1 = result;
			}
		}

		/*Listener_xiaos���б�д����С���������Ӧ�߼�*/
		class Listener_xiaos implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				st = (JButton) e.getSource();
				vt.add(st);
				if (i_5 == 1) {
					String ss2 = ((JButton) e.getSource()).getText();
					if (i_1 == 1) {
						if (i_3 == 1) {
							str1 = "";
							i_5 = 1;
						}
						str1 = str1 + ss2;
						i_3 = i_3 + 1;
						TextField.setText(str1);
					} else if (i_1 == 2) {
						if (i_4 == 1) {
							str2 = "";
							i_5 = 1;
						}
						str2 = str2 + ss2;
						i_4 = i_4 + 1;
						TextField.setText(str2);
					}
				}
				i_5 = i_5 + 1;
			}
		}
		// �������ڼ�
		Listener_dy jt_dy = new Listener_dy();
		// �������ּ�
		Listener jt = new Listener();
		// �������ż�
		Listener_signal jt_signal = new Listener_signal();
		// ���������
		Listener_clear jt_c = new Listener_clear();
		// ����С�����
		Listener_xiaos jt_xs = new Listener_xiaos();
		button7.addActionListener(jt);
		button8.addActionListener(jt);
		button9.addActionListener(jt);
		button_chu.addActionListener(jt_signal);
		button4.addActionListener(jt);
		button5.addActionListener(jt);
		button6.addActionListener(jt);
		button_cheng.addActionListener(jt_signal);
		button1.addActionListener(jt);
		button2.addActionListener(jt);
		button3.addActionListener(jt);
		button_jian.addActionListener(jt_signal);
		button0.addActionListener(jt);
		button_Dian.addActionListener(jt_xs);
		button_dy.addActionListener(jt_dy);
		button_jia.addActionListener(jt_signal);
		clear_Button.addActionListener(jt_c);
		// ����ر��¼�����Ӧ����
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	// cal()�����б�д�˼����߼���ʵ�֡�
	public void cal() {
		double a2,b2;	//������������a2,b2
		String c = signal;
		double result2 = 0;		//��ʼ��
		if (c.equals("")) {
			TextField.setText("Please input operator");
		} else {
			if (str1.equals("."))
				str1 = "0.0";
			if (str2.equals("."))
				str2 = "0.0";
			a2 = Double.valueOf(str1).doubleValue();
			b2 = Double.valueOf(str2).doubleValue();
			if (c.equals("+")) {
				result2 = a2 + b2;
			}
			if (c.equals("��")) {
				result2 = a2 - b2;
			}
			if (c.equals("*")) {
				BigDecimal m1 = new BigDecimal(Double.toString(a2));
				BigDecimal m2 = new BigDecimal(Double.toString(b2));
   				 //�˷�����,ֻ�赼�������import  java.math.BigDecimal��
				result2 = m1.multiply(m2).doubleValue();	
			}
			if (c.equals("/")) {
				if (b2 == 0) {
					result2 = 0;
				} else {
					result2 = a2 / b2;
				}
			}
			result = ((new Double(result2)).toString());
			TextField.setText(result);
		}
	}
	public static void main(String[] args) {
		E_calculator CT = new E_calculator();
	}
}
