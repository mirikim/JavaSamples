package HomeWorkhb;
///////////////////////�����ϱ�������

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
		setBounds(400, 200, 450, 100);
		setResizable(false);
		setVisible(true);// Frame�� ȭ�鿡 ���̰� �Ѵ�.

	}

	// ȸ������ ���̾ƿ�
	MemberManagement(String j) {
		super();// Frame(String title)�� ȣ���Ѵ�.
		setTitle("JoinUs");
		lid = new Label("ID : ");// Label�� text������ ����������.
		lpwd = new Label("PW : ");
		lPwdcf = new Label("pwCheck : ");
		lEmail = new Label("Email : ");
		cancel = new Button("cancel");
		confirm = new Button("join");
		Panel info = new Panel();

		// �� 10���� ���ڸ� �Է��� �� �ִ� TextField����.
		tfId = new TextField(20);
		tfPwd = new TextField(20);
		tfPwd.setEchoChar('*');// �Է��� �� ��� '*'�� ���̰� �Ѵ�.
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
		info.add(cancel);
		info.add(confirm);
		// tfPwdcf.setVisible(false);
		info.setBounds(400, 200, 200, 350);

		add(info);

		setBounds(460, 150, 200, 350);
		setResizable(false);
		setVisible(true);// Frame�� ȭ�鿡 ���̰� �Ѵ�.

	}

	/// ������ �α��ν� ȸ������ ��� ���̾ƿ�
	MemberManagement(String admin, String pw) {
		super();// Frame(String title)�� ȣ���Ѵ�.
		setTitle("ȸ������");

		lid = new Label(" ����� ID : ", Label.RIGHT);// Label�� text������ ����������.

		Panel info = new Panel();
		Panel Memlist = new Panel();
		info.setBounds(0, 90, 450, 40);
		Memlist.setBounds(0, 150, 450, 100);
		// �� 10���� ���ڸ� �Է��� �� �ִ� TextField����.
		tfId = new TextField(20);

		exit = new Button("����");
		print = new Button("���");
		totalPrint = new Button("��ü���");
		exit.setSize(60, 30);
		print.setSize(60, 30);
		totalPrint.setSize(60, 30);
		// OK��ư�� TextField�� �̺�Ʈó�������� Listener�� �߰����ش�.
		MemberHandler mhandler = new MemberHandler();
		tfId.addActionListener(new MemberHandler());
		exit.addActionListener(new MemberHandler());
		print.addActionListener(new MemberHandler());
		totalPrint.addActionListener(new MemberHandler());

		setLayout(new BorderLayout());// LayoutManager�� FlowLayout����

		info.add(lid);// ������ Component���� Frame�� ���Խ�Ų��.
		info.add(tfId);
		info.add(print);
		info.add(totalPrint);
		info.add(exit);

		add(info);

		setSize(800, 150);
		setVisible(true);// Frame�� ȭ�鿡 ���̰� �Ѵ�.
	}

	//////////////////////
	/* login method() */
	//////////////////////
	static void login() {
		// TODO Auto-generated method stub
		String id = tfId.getText();
		String password = tfPwd.getText();// tfId�� �ԷµǾ��ִ� text�� ���´�.

		if (!id.equals("admin")) {

			JOptionPane.showMessageDialog(null, "�Է��Ͻ� id�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			// id�� �ٽ� �Է��� �� �ֵ��� ,focus�� tfId�� �ű��.

			tfId.requestFocus();
			tfId.selectAll();// tfId�� �Էµ� text�� ���õǰ� �Ѵ�.
		} else if (!password.equals("1111")) {

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
		System.out.println(tfPwd.getText());
		if (tfId.getText() == null || tfPwd.getText() == null || tfPwdcf.getText() == null || tfEmail.getText() == null) {
			JOptionPane.showMessageDialog(null, "��ĭ�� �� �Է����ּ���.");
//		} else if (Member.get(0) == tfId.getText()) {
//			JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ID�Դϴ�.");
//		} else if (tfPwd.getText() == tfEmail.getText()) {
//			JOptionPane.showMessageDialog(null, "��й�ȣ�� Ȯ�����ּ���.");
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
//			JOptionPane.showMessageDialog(null, tfId.getText() + "�� ȸ�����ԵǾ����ϴ�.");
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

				break;

			case "cancel":
				setVisible(false);
				break;
			case "join":
				join();

				// setVisible(false);
				break;
			case "���":
				JOptionPane.showMessageDialog(null, "��µǾ����ϴ�.");
				break;
			case "��ü���":
				JOptionPane.showMessageDialog(null, "��ü���");
				break;
			case "����":
				setVisible(false);
				break;

			}

		}

	}// class MyHandler
}