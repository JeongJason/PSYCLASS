
package LibrarySwing;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.tools.javac.Main;

class LibraryGui extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground = new ImageIcon(LibraryGuiMain.class.getResource("../img/LibraryBackground.jpg")).getImage();;
	
	
	LibraryGui(){
		//panal만들어주기
		JPanel panel = new JPanel();
		panel.setLayout(null);
		//패널 위에 라벨
		JLabel subject = new JLabel("우리들의 독서 이야기");
		subject.setBounds(30,20,100,20);
		//패널 위에 버튼
		JButton search = new JButton("책 검색");
		search.setBounds(30,50,100,20);
		
		
		
		panel.add(subject);
		panel.add(search);
		
		//백그라운드 이미지 생성
		
				
				 
		
		add(panel);
		setSize(LibraryGuiMain.SCREEN_WIDTH,LibraryGuiMain.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("Library-Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(LibraryGuiMain.SCREEN_WIDTH, LibraryGuiMain.SCREEN_HEIGHT); //화면배율과 같은 크기의 이미지를 생성해줌
		screenGraphic = screenImage.getGraphics(); //이미지 객체를 그래픽스 객체로 생성
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
}	