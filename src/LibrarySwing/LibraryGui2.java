
package LibrarySwing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LibraryGui2 extends JFrame implements ActionListener {
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground = new ImageIcon(LibraryGuiMain.class.getResource("../img/LibraryBackground.jpg")).getImage();
	
	JButton search;
	
	LibraryGui2(){
		// 패널 만들기(그래픽 이미지를 오버라이딩을 통해서 구현하여 panel에 추가)
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(introBackground, 0, 0, null);
			}
		};
		panel.setLayout(null);
		
		// 라벨 추가
		JLabel subject = new JLabel(" 7조 우리들의 독서 이야기");
		subject.setBounds(30,20,200,20);
		panel.add(subject);
		
		// 버튼 추가
		search = new JButton("도서 검색");
		search.setBounds(30,50,150,20);
		search.setBackground(Color.LIGHT_GRAY);
		panel.add(search);
		
		// 이벤트 추가
		search.addActionListener(this);
		
		
		add(panel);
		
		setSize(LibraryGuiMain.SCREEN_WIDTH, LibraryGuiMain.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("Library-Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	//이벤트 내용: 책 검색이라는 버튼을 클릭하면 도서 찾기 창이 뜨는 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			
			OpenNewWindow nwindow= new OpenNewWindow();
		}
		
	}
	

	
}