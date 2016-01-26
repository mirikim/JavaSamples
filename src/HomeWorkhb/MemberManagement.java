package HomeWorkhb;
///////////////////////�����ϱ�������

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

	// �α��� ���̾ƿ�
	MemberManagement() {
		super();// Frame(String title)�� ȣ���Ѵ�.

		lid = new Label("ID : ", Label.RIGHT);// Label�� text������ ����������.
		lpwd = new Label("Password : ", Label.RIGHT);
		Panel info = new Panel();
		Panel Button = new Panel();
		info.setBounds(0, 30, 450, 60);
		Button.setBounds(0, 90, 450, 40);
		// �� 10���� ���ڸ� �Է��� �� �ִ� TextField����.
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');// �Է��� �� ��� '*'�� ���̰� �Ѵ�.
		tfPwdcf = new TextField(10);
		tfPwdcf.setEchoChar('*');
		login = new Button("login");
		join = new Button("joinus");

		join.setSize(60, 30);
		login.setSize(60, 30);
		// OK��ư�� TextField�� �̺�Ʈó�������� Listener�� �߰����ش�.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());
		tfPwd.addActionListener(new MemberHandler());
		tfPwdcf.addActionListener(new MemberHandler());
		login.addActionListener(new MemberHandler());
		join.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager�� FlowLayout����

		info.add(lid);// ������ Component���� Frame�� ���Խ�Ų��.
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
		setVisible(true);// Frame�� ȭ�鿡 ���̰� �Ѵ�.

	}

	// ȸ������ ���̾ƿ�
	MemberManagement(String j) {
		super();// Frame(String title)�� ȣ���Ѵ�.
		setTitle("JoinUs");
		lid = new Label("ID : ", Label.RIGHT);// Label�� text������ ����������.
		lpwd = new Label("Password : ", Label.RIGHT);
		lPwdcf = new Label("PwCheck : ", Label.RIGHT);
		lEmail = new Label("Email : ", Label.RIGHT);
		Panel info = new Panel();
		Panel Button = new Panel();
		info.setBounds(0, 30, 450, 60);
		Button.setBounds(0, 90, 450, 40);
		// �� 10���� ���ڸ� �Է��� �� �ִ� TextField����.
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');// �Է��� �� ��� '*'�� ���̰� �Ѵ�.
		tfPwdcf = new TextField(10);
		tfPwdcf.setEchoChar('*');
		tfEmail = new TextField(20);
		cancel = new Button("cancel");
		confirm = new Button("join");

		cancel.setSize(60, 30);
		confirm.setSize(60, 30);
		// OK��ư�� TextField�� �̺�Ʈó�������� Listener�� �߰����ش�.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());
		tfPwd.addActionListener(new MemberHandler());
		tfPwdcf.addActionListener(new MemberHandler());
		cancel.addActionListener(new MemberHandler());
		confirm.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager�� FlowLayout����

		info.add(lid);// ������ Component���� Frame�� ���Խ�Ų��.
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
		setVisible(true);// Frame�� ȭ�鿡 ���̰� �Ѵ�.

	}

	/// ������ �α��ν� ȸ������ ��� ���̾ƿ�
	MemberManagement(String admin, String pw) {
		super();// Frame(String title)�� ȣ���Ѵ�.
		setTitle("ȸ������");
		
		lid = new Label(" ����� ID : ", Label.RIGHT);// Label�� text������ ����������.

		Panel info = new Panel();
		Panel Button = new Panel();
		info.setBounds(0, 30, 450, 60);
		Button.setBounds(0, 90, 450, 40);
		// �� 10���� ���ڸ� �Է��� �� �ִ� TextField����.
		tfId = new TextField(10);

		cancel = new Button("cancel");
		confirm = new Button("join");
		cancel.setSize(60, 30);
		confirm.setSize(60, 30);
		// OK��ư�� TextField�� �̺�Ʈó�������� Listener�� �߰����ش�.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());

		cancel.addActionListener(new MemberHandler());
		confirm.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager�� FlowLayout����

		info.add(lid);// ������ Component���� Frame�� ���Խ�Ų��.
		info.add(tfId);

		Button.add(cancel);
		Button.add(confirm);
		// tfPwdcf.setVisible(false);
		add(info, "North");
		add(Button, "Center");

		setSize(800, 100);
		setVisible(true);// Frame�� ȭ�鿡 ���̰� �Ѵ�.
	}

	//////////////////////
	/* login method() */
	//////////////////////
	static void login() {
		// TODO Auto-generated method stub
		String id = tfId.getText();
		String password = tfPwd.getText();// tfId�� �ԷµǾ��ִ� text�� ���´�.

		if (!id.equals("javachobo")) {

			JOptionPane.showMessageDialog(null, "�Է��Ͻ� id�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			// id�� �ٽ� �Է��� �� �ֵ��� ,focus�� tfId�� �ű��.

			tfId.requestFocus();
			tfId.selectAll();// tfId�� �Էµ� text�� ���õǰ� �Ѵ�.
		} else if (!password.equals("asdf")) {

			JOptionPane.showMessageDialog(null, "�Է��Ͻ� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ֽñ� �ٶ��ϴ�.");

			// id�� �ٽ� �Է� �� �� �ֵ��� focus�� tfId�� �ű��.

			tfPwd.requestFocus();
			tfPwd.selectAll();
			// } else if (id.equals("admin") && password.equals("1234")) {
			// MemberManagement m_admin = new MemberManagement(id, password);

		} else {
			MemberManagement m_admin = new MemberManagement(id, password);
			// JOptionPane.showMessageDialog(null, id + "��, ���������� �α��� �Ǿ����ϴ�.");

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

	// �޴��� Ŭ������ �� �޴��� ó���ڵ�
	class MemberHandler implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			// getActionCommand() : �׼��� �߻���Ų ����� ���ڿ��� ��ȯ
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