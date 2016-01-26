package HomeWorkhb;
///////////////////////월요일까지숙제

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

class MemberManagement extends Frame {
	static HashMap Member = new HashMap();
	static Label lid, lpwd, lPwdcf, lEmail, lSSn;
	static TextField tfId, tfPwd, tfPwdcf, tfEmail, tfSsn;
	static Button login, join, cancel, confirm, drawout, print, exit, totalPrint;
	static TextArea MemberInfoList;
	static int memberNo = 0;
	static ArrayList Member_Info[] = new ArrayList[100];

	// 로그인 레이아웃
	MemberManagement() {
		super();// Frame(String title)을 호출한다.

		lid = new Label("ID : ", Label.RIGHT);// Label의 text정렬을 오른쪽으로.
		lpwd = new Label("Password : ", Label.RIGHT);
		Panel info = new Panel();
		Panel Button = new Panel();
		info.setBounds(0, 30, 450, 60);
		Button.setBounds(0, 90, 450, 40);
		// 약 10개의 글자를 입력할 수 있는 TextField생성.
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');// 입력한 값 대신 '*'이 보이게 한다.
		tfPwdcf = new TextField(10);
		tfPwdcf.setEchoChar('*');
		login = new Button("login");
		join = new Button("joinus");

		join.setSize(60, 30);
		login.setSize(60, 30);
		// OK버튼과 TextField에 이벤트처리를위한 Listener를 추가해준다.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());
		tfPwd.addActionListener(new MemberHandler());
		tfPwdcf.addActionListener(new MemberHandler());
		login.addActionListener(new MemberHandler());
		join.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager를 FlowLayout으로

		info.add(lid);// 생성한 Component들을 Frame에 포함시킨다.
		info.add(tfId);
		info.add(lpwd);
		info.add(tfPwd);
		// info.add(tfPwdcf);
		Button.add(join);
		Button.add(login);
		tfPwdcf.setVisible(false);
		add(info, "North");
		add(Button, "Center");
		setBounds(400, 200, 450, 100);
		setResizable(false);
		setVisible(true);// Frame이 화면에 보이게 한다.

	}

	// 회원가입 레이아웃
	MemberManagement(String j) {
		super();// Frame(String title)을 호출한다.
		setTitle("JoinUs");
		lid = new Label("ID : ");// Label의 text정렬을 오른쪽으로.
		lpwd = new Label("PW : ");
		lPwdcf = new Label("pwCheck : ");
		lEmail = new Label("Email : ");
		cancel = new Button("cancel");
		confirm = new Button("join");
		Panel info = new Panel();

		// 약 10개의 글자를 입력할 수 있는 TextField생성.
		tfId = new TextField(20);
		tfPwd = new TextField(20);
		tfPwd.setEchoChar('*');// 입력한 값 대신 '*'이 보이게 한다.
		tfPwdcf = new TextField(20);
		tfPwdcf.setEchoChar('*');
		tfEmail = new TextField(20);
		lid.setBounds(10, 10, 100, 40);
		tfId.setBounds(120, 10, 200, 40);

		lid.setBounds(20, 100, 30, 30);
		tfId.setBounds(60, 100, 200, 30);
		lpwd.setBounds(15, 150, 30, 30);
		tfPwd.setBounds(60, 150, 200, 30);
		lPwdcf.setBounds(15, 200, 40, 30);
		tfPwdcf.setBounds(60, 200, 200, 30);
		lEmail.setBounds(15, 250, 30, 30);
		tfEmail.setBounds(60, 250, 200, 30);
		cancel.setBounds(40, 400, 100, 30);
		confirm.setBounds(145, 400, 100, 30);

		// OK버튼과 TextField에 이벤트처리를위한 Listener를 추가해준다.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());
		tfPwd.addActionListener(new MemberHandler());
		tfPwdcf.addActionListener(new MemberHandler());
		cancel.addActionListener(new MemberHandler());
		confirm.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager를 FlowLayout으로

		info.add(lid);// 생성한 Component들을 Frame에 포함시킨다.
		info.add(tfId);
		info.add(lpwd);
		info.add(tfPwd);
		info.add(lPwdcf);
		info.add(tfPwdcf);
		info.add(lEmail);
		info.add(tfEmail);
		info.add(cancel);
		info.add(confirm);
		// tfPwdcf.setVisible(false);
		info.setBounds(400, 200, 200, 350);

		add(info);

		setBounds(460, 150, 200, 350);
		setResizable(false);
		setVisible(true);// Frame이 화면에 보이게 한다.

	}

	/// 관리자 로그인시 회원정보 출력 레이아웃
	MemberManagement(String admin, String pw) {
		super();// Frame(String title)을 호출한다.
		setTitle("회원정보");

		lid = new Label(" 출력할 ID : ", Label.RIGHT);// Label의 text정렬을 오른쪽으로.

		Panel info = new Panel();
		Panel Memlist = new Panel();
		info.setBounds(0, 90, 450, 40);
		Memlist.setBounds(0, 150, 450, 100);
		// 약 10개의 글자를 입력할 수 있는 TextField생성.
		tfId = new TextField(20);

		exit = new Button("종료");
		print = new Button("출력");
		totalPrint = new Button("전체출력");
		exit.setSize(60, 30);
		print.setSize(60, 30);
		totalPrint.setSize(60, 30);
		// OK버튼과 TextField에 이벤트처리를위한 Listener를 추가해준다.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());
		exit.addActionListener(new MemberHandler());
		print.addActionListener(new MemberHandler());
		totalPrint.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager를 FlowLayout으로

		info.add(lid);// 생성한 Component들을 Frame에 포함시킨다.
		info.add(tfId);
		info.add(print);
		info.add(totalPrint);
		info.add(exit);

		add(info);

		setSize(800, 150);
		setVisible(true);// Frame이 화면에 보이게 한다.
	}

	//////////////////////
	/* login method() */
	//////////////////////
	static void login() {
		// TODO Auto-generated method stub
		String id = tfId.getText();
		String password = tfPwd.getText();// tfId에 입력되어있는 text를 얻어온다.

		if (!id.equals("admin")) {

			JOptionPane.showMessageDialog(null, "입력하신 id가 유효하지 않습니다. 다시 입력해주세요.");
			// id를 다시 입력할 수 있도록 ,focus를 tfId로 옮긴다.

			tfId.requestFocus();
			tfId.selectAll();// tfId에 입력된 text가 선택되게 한다.
		} else if (!password.equals("1111")) {

			JOptionPane.showMessageDialog(null, "입력하신 비밀번호가 틀렸습니다. 다시 입력해주시길 바랍니다.");

			// id를 다시 입력 할 수 있도록 focus를 tfId로 옮긴다.

			tfPwd.requestFocus();
			tfPwd.selectAll();
			// } else if (id.equals("admin") && password.equals("1234")) {
			// MemberManagement m_admin = new MemberManagement(id, password);

		} else {
			MemberManagement m_admin = new MemberManagement(id, password);
			// JOptionPane.showMessageDialog(null, id + "님, 성공적으로 로그인 되었습니다.");

		}
	}// login

	//////////////////////
	/* join method() */
	//////////////////////
	static void join() {
		System.out.println(tfPwd.getText());
		if (tfId.getText() == null || tfPwd.getText() == null || tfPwdcf.getText() == null || tfEmail.getText() == null) {
			JOptionPane.showMessageDialog(null, "빈칸을 다 입력해주세요.");
//		} else if (Member.get(0) == tfId.getText()) {
//			JOptionPane.showMessageDialog(null, "이미 존재하는 ID입니다.");
//		} else if (tfPwd.getText() == tfEmail.getText()) {
//			JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
//
//		} else {
//
//			Member_Info[memberNo] = new ArrayList();
//			Member_Info[memberNo].add(tfId.getText());
//			Member_Info[memberNo].add(tfPwd.getText());
//			Member_Info[memberNo].add(tfEmail.getText());
//
//			Member.put(tfId.getText(), memberNo);
//			System.out.println(Member);
//			System.out.println(Member_Info);
//			memberNo++;
//
//			JOptionPane.showMessageDialog(null, tfId.getText() + "님 회원가입되었습니다.");
		//	MemberManagement("1").setVisible(false);
		}
	}


	public static void main(String[] args) {
		MemberManagement mm = new MemberManagement();
		mm.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}// main

	// 메뉴를 클릭했을 대 메뉴별 처리코드
	class MemberHandler implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			// getActionCommand() : 액션을 발생시킨 명령을 문자열로 반환
			switch (command) {
			case "login":
				login();
				break;
			case "joinus":
				MemberManagement m_join = new MemberManagement("  join  ");

				break;

			case "cancel":
				setVisible(false);
				break;
			case "join":
				join();

				// setVisible(false);
				break;
			case "출력":
				JOptionPane.showMessageDialog(null, "출력되었습니다.");
				break;
			case "전체출력":
				JOptionPane.showMessageDialog(null, "전체출력");
				break;
			case "종료":
				setVisible(false);
				break;

			}

		}

	}// class MyHandler
}