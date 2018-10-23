import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;


public class MainFrame 
{
	public static void main(String args[]) 
	{
		JFrame f = new JFrame();
		f.setTitle("JustFact's Super Duper Digital NoteBook");
		JPanel p = new JPanel();
		JLabel l1 = new JLabel("File Name: ");
		JLabel l2 = new JLabel("-----Text area-----");
		l2.setPreferredSize(new Dimension(100, 10));
		l2.setHorizontalTextPosition(SwingConstants.CENTER);
		JTextField t1 = new JTextField();
		t1.setColumns(35);
		JTextArea a = new JTextArea(10,40);
		JScrollPane sp = new JScrollPane(a);
		JButton b1 = new JButton("Save");
		JButton b2 = new JButton("Append");
		JButton b3 = new JButton("Open");
		JButton b4 = new JButton("Clear");
		JButton b5 = new JButton("List");

		a.setText(" ");
		
		b1.addActionListener(new ActionListener() {			//SAVE BUTTON
			public void actionPerformed(ActionEvent arg0)
			{

				try {
					String s = t1.getText().toString();
				FileWriter fo = new FileWriter(s+".txt");
				String d = a.getText();
//				a.setText("*File Created on:"+datef.format(date)+"*\n"+d);
				a.write(fo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {			//APPEND BUTTON
			public void actionPerformed(ActionEvent arg0)
			{
				String test = a.getText();
				if(test.equals('\0')) {
					a.setText("===Denied!===\nText Area Empty");}
				else {
				try {	
					String s = t1.getText();
					 int len;
				      char[] chr = new char[4096];
				      final StringBuffer buffer = new StringBuffer();
				      final FileReader reader = new FileReader(s+".txt");
				      try {
				          while ((len = reader.read(chr)) > 0) {
				              buffer.append(chr, 0, len);
				             
				          }
				      } finally {
				          reader.close();
				      }
				      String txt = buffer.toString()+"\n"+test;
				      a.setText(txt);
//						a.write(fo);
				} catch (Exception e) {
					e.printStackTrace();
					a.setText("===Denied!===\nText Area Empty");
				}}
			}
		});
		
		b3.addActionListener(new ActionListener() {			//OPEN BUTTON
			public void actionPerformed(ActionEvent arg0)
			{
				try {	
					String s = t1.getText();
					 int len;
				      char[] chr = new char[4096];
				      final StringBuffer buffer = new StringBuffer();
				      final FileReader reader = new FileReader(s+".txt");
				      try {
				          while ((len = reader.read(chr)) > 0) {
				              buffer.append(chr, 0, len);
				          }
				      } finally {
				          reader.close();
				      }
				      a.setText(buffer.toString());
				} catch (Exception e) {
					String s = t1.getText();
					a.setText("File Not Found!\n\nSystem cannot find the File: "+s+".txt\nMake sure you typed the name correctly.");
				}
			}
		});
		
		b4.addActionListener(new ActionListener() {			//CLEAR BUTTON
			public void actionPerformed(ActionEvent arg0)
			{
				a.setText("");
			}
		});

		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File folder = new File("C:\\Users\\HP\\eclipse-workspace\\Digital NoteBook\\");
				File[] lof = folder.listFiles();
				String s = "";
				    for (int i = 0; i < lof.length; i++) {
				      if (lof[i].isFile()&&lof[i].getName().endsWith(".txt")) {
				        s = s+lof[i].getName()+" - "+lof[i].length()+" bytes\n";
				      }
				    }
				    a.setText("===List Of Files===\n(Type the file name to open it)\n"+s);
			}
		});
		
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(sp);
		p.add(b1);//1985
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.setSize(500,10);
		f.add(p);
		f.setBounds(100,100,500,300);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
