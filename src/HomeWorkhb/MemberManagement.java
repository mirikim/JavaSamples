package HomeWorkhb;
///////////////////////월요일까지숙제

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

class MemberManagement extends Frame {
	static HashMap Member = new HashMap();
	static Label lid, lpwd, lPwdcf, lEmail, lSSn;
	static TextField tfId, tfPwd, tfPwdcf, tfEmail, tfSsn;
	static Button login, join, cancel, confirm, drawout, print;
	static TextArea MemberInfo;

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

		setSize(450, 100);
		setVisible(true);// Frame이 화면에 보이게 한다.

	}

	// 회원가입 레이아웃
	MemberManagement(String j) {
		super();// Frame(String title)을 호출한다.
		setTitle("JoinUs");
		lid = new Label("ID : ", Label.RIGHT);// Label의 text정렬을 오른쪽으로.
		lpwd = new Label("Password : ", Label.RIGHT);
		lPwdcf = new Label("PwCheck : ", Label.RIGHT);
		lEmail = new Label("Email : ", Label.RIGHT);
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
		tfEmail = new TextField(20);
		cancel = new Button("cancel");
		confirm = new Button("join");

		cancel.setSize(60, 30);
		confirm.setSize(60, 30);
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
		Button.add(cancel);
		Button.add(confirm);
		// tfPwdcf.setVisible(false);
		add(info, "North");
		add(Button, "Center");

		setSize(800, 100);
		setVisible(true);// Frame이 화면에 보이게 한다.

	}

	/// 관리자 로그인시 회원정보 출력 레이아웃
	MemberManagement(String admin, String pw) {
		super();// Frame(String title)을 호출한다.
		setTitle("회원정보");
		
		lid = new Label(" 출력할 ID : ", Label.RIGHT);// Label의 text정렬을 오른쪽으로.

		Panel info = new Panel();
		Panel Button = new Panel();
		info.setBounds(0, 30, 450, 60);
		Button.setBounds(0, 90, 450, 40);
		// 약 10개의 글자를 입력할 수 있는 TextField생성.
		tfId = new TextField(10);

		cancel = new Button("cancel");
		confirm = new Button("join");
		cancel.setSize(60, 30);
		confirm.setSize(60, 30);
		// OK버튼과 TextField에 이벤트처리를위한 Listener를 추가해준다.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());

		cancel.addActionListener(new MemberHandler());
		confirm.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager를 FlowLayout으로

		info.add(lid);// 생성한 Component들을 Frame에 포함시킨다.
		info.add(tfId);

		Button.add(cancel);
		Button.add(confirm);
		// tfPwdcf.setVisible(false);
		add(info, "North");
		add(Button, "Center");

		setSize(800, 100);
		setVisible(true);// Frame이 화면에 보이게 한다.
	}

	//////////////////////
	/* login method() */
	//////////////////////
	static void login() {
		// TODO Auto-generated method stub
		String id = tfId.getText();
		String password = tfPwd.getText();// tfId에 입력되어있는 text를 얻어온다.

		if (!id.equals("javachobo")) {

			JOptionPane.showMessageDialog(null, "입력하신 id가 유효하지 않습니다. 다시 입력해주세요.");
			// id를 다시 입력할 수 있도록 ,focus를 tfId로 옮긴다.

			tfId.requestFocus();
			tfId.selectAll();// tfId에 입력된 text가 선택되게 한다.
		} else if (!password.equals("asdf")) {

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

	}

	public static void main(String[] args) {
		MemberManagement mm = new MemberManagement();

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
				join();
				break;

			case "cancel":
				setVisible(false);
				break;
			case "join":
				setVisible(false);

			}

		}

	}// class MyHandler
}