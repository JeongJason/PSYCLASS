package LibrarySwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class OpenNewWindow extends JFrame implements ActionListener {
	String id = "root";
	String pw = "1234";
	String url = "jdbc:mysql://localhost:3306/library_test";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 1번째 자료검색 라벨, 텍스트필드, 버튼
	JLabel search1;
	JTextField text1;
	JButton click1;

	// 2번째 자료검색 라벨, 텍스트필드, 버튼
	JLabel search2;
	JTextField text2;
	JButton click2;

	// 3번째 자료검색 라벨, 텍스트필드, 버튼
	JLabel search3;
	JTextField text3;
	JButton click3;

	// 4번째 자료검색 라벨, 텍스트필드, 버튼
	JLabel search4;
	JTextField text4;
	JButton click4;

	// 리스너에 들어갈 프레임
	JFrame Frm_Select;
	JFrame Frm_Select1;
	JTable resultTable;
	DefaultTableModel tableModel;

	OpenNewWindow(){
		JPanel s_panel = new JPanel();
		s_panel.setLayout(null);
		search1 = new JLabel("도서명");
		search1.setBounds(30,30,50,27);
		text1 = new JTextField();
		text1.setBounds(30,70,200,40);
		click1= new JButton("검색");
		click1.setBounds(30,120, 100, 40);
		
		click2= new JButton("대여");
		click2.setBounds(30,170, 100, 40);
		
		click3= new JButton("반납");
		click3.setBounds(30,220, 100, 40);
		
		click4= new JButton("대여목록");
		click4.setBounds(30,270, 100, 40);
		
		tableModel = new DefaultTableModel(
			new Object[][]{},
			new String[]{"도서명", "저자", "출판사", "출판일"}
		);
		resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);
		scrollPane.setBounds(350,30,550,500);;
		
		s_panel.add(scrollPane);
		s_panel.add(click1);
		s_panel.add(text1);
		s_panel.add(search1);
		s_panel.add(click2);
		s_panel.add(click3);
		s_panel.add(click4);
		
		click1.addActionListener(this);
		click2.addActionListener(this);
		click3.addActionListener(this);
		click4.addActionListener(this);
		
		add(s_panel);
		setBounds(450,200,1000,650);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loding Success...");
			conn=DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == click1) {
			Frm_Select = new JFrame("도서조회");
			Frm_Select.setBounds(685, 300, 400, 400);
			JPanel panel = new JPanel();
			// Table구조만들기
			String[] column = { "b_name", "actor", "publisher", "publisher_date" };
			Object[][] data = {};
			DefaultTableModel model = new DefaultTableModel(data, column);

			// tbl_memo로부터 데이터 가져오기
			try {
				pstmt = conn.prepareStatement("select * from book");
				rs = pstmt.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Object[] rowData = { rs.getInt("b_name"), rs.getString("actor"), rs.getString("publisher"),
								rs.getString("publisher_date") };
						model.addRow(rowData);
						System.out.print(rs.getString("b_name") + " ");
						System.out.print(rs.getString("actor") + " ");
						System.out.print(rs.getString("publisher") + " ");
						System.out.print(rs.getString("publisher_date") + "\n");
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					rs.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					pstmt.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			// Component생성
			JTable table = new JTable(model);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setBounds(10, 10, 350, 330);

			// Table 열의 크기지정
			table.getColumnModel().getColumn(0).setMaxWidth(25);
//			table.getColumnModel().getColumn(1).setMaxWidth();
			table.getColumnModel().getColumn(2).setMaxWidth(150);

			// Component를 Panel에 추가&Layout
			panel.add(scroll);
			panel.setLayout(null);

			// Frame에 Panel추가
			Frm_Select.getContentPane().add(panel);

			Frm_Select.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Frm_Select.setVisible(true);
		} else if (e.getSource() == click2) {

			Frm_Select = new JFrame("도서조회");
			Frm_Select.setBounds(685, 300, 400, 400);

			Frm_Select.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Frm_Select.setVisible(true);
		} else if (e.getSource() == click3) {
			Frm_Select = new JFrame("도서조회");
			Frm_Select.setBounds(685, 300, 400, 400);

			Frm_Select.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Frm_Select.setVisible(true);
		} else if (e.getSource() == click4) {
			Frm_Select = new JFrame("도서조회");
			Frm_Select.setBounds(685, 300, 400, 400);

			Frm_Select.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Frm_Select.setVisible(true);
		}

	}
}
