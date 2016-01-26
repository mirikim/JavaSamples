package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SeatFrame extends JPanel {
	static JPanel seatJPanel[][] = new JPanel[5][15];
	static JLabel label[][] = new JLabel[5][15];//
	CustomDialog customeDialog;

	public SeatFrame() {
		setLayout(null);

		//////////// * column *////////////(5��15���� �¼��� ����)

		String Rowlabel[] = { "A", "B", "C", "D", "F" };
		for (int i = 0; i < seatJPanel.length; i++) {
			for (int j = 0; j < 15; j++) {
				seatJPanel[i][j] = new JPanel();
				seatJPanel[i][j].setLayout(null);
				seatJPanel[i][j].setBounds(j * 65, 10, 60, 60);
				seatJPanel[i][j].setBackground(Color.lightGray);

				label[i][j] = new JLabel(Rowlabel[i] + (j + 1));
				label[i][j].setBounds(20, 20, 25, 20);
				label[i][j].setFocusable(false);
				label[i][j].setForeground(Color.black);

				seatJPanel[i][j].add(label[i][j]);
				seatJPanel[i][j].addMouseListener(new SeatClickAction());
				seatJPanel[i][j].setOpaque(true);
				seatJPanel[i][j].setVisible(true);
				seatJPanel[i][j].setFocusable(true);

			}

		}

		//////////// * rowPane *////////////
		JLayeredPane rowPane[] = new JLayeredPane[seatJPanel.length];
		for (int i = 0; i < rowPane.length; i++) {
			rowPane[i] = new JLayeredPane();
			rowPane[i].setBounds(10, 40 + 100 * i, 990, 100);
			rowPane[i].setLayout(null);
			// rowPane[j].setBackground(Color.blue);
			rowPane[i].setOpaque(true);
			rowPane[i].setFocusable(true);
			// row�� (seat)�߰�
			for (int j = 0; j < 15; j++) {
				rowPane[i].add(seatJPanel[i][j]);
			}
		}
		// TotalSeat(���� ���� Frame�� row�� �߰�)
		for (int j = 0; j < rowPane.length; j++) {
			add(rowPane[j]);
		}
		setVisible(true);
		// setOpaque(false);
		// ������ ����ó��(false)<-���߿� �¼� �̹��������� �ʿ�
		setFocusable(true);

	}

	public static void main(String[] args) {
		JFrame TotalSeat = new JFrame();
		TotalSeat.setTitle("�������¼�");
		TotalSeat.add(new SeatFrame());// SeatFrame�޼��带 TotalSeat���߰�
		TotalSeat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TotalSeat.setBounds(100, 100, 1000, 600);
		TotalSeat.setVisible(true);
		

	}

	// �¼� Ŭ���� �̺�Ʈ������
	class SeatClickAction implements MouseListener {
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// Ŭ�������� �׽�Ʈ��
			// JOptionPane.showConfirmDialog(SeatFrame.this, "�׽�Ʈ");
			Frame confrimFrame = new Frame();
			confrimFrame.setSize(200, 200);
			Panel confrimPanel = new Panel();
			Label testest = new Label("Test");
			confrimPanel.add(testest);
			confrimFrame.add(confrimPanel);

			// JOptionPane.showOptionDialog(SeatFrame.this, confrimFrame,
			// "test", 1, 1, null, null, null);

			customeDialog.createAndShowGUI();

		}
	}
}





////////////CustomDialog ���� ////////////////////
class CustomDialog extends JPanel {
	JFrame frame;

	public CustomDialog(JFrame frame) {
		super(new BorderLayout());
		this.frame = frame;
		// Create the components.
		JPanel frequentPanel = createSimpleDialogBox();
		add(createSimpleDialogBox());
	}

	private JPanel createSimpleDialogBox() {

		JPanel contextPane = new JPanel();
		JButton Button_confirm = new JButton("����");
		JButton Button_cancel = new JButton("���");
		Label nullLabel = new Label("");
		Label seatLabel = new Label("�¼� : ");
		Label inTime = new Label("�Խǽð� : ");
		Label outTime = new Label("��ǿ����ð� :");
		Label warn = new Label("*��� ������ ��ǿ����ð� 1�ð� ������ ����");

		Button_confirm.setSize(100, 30);
		Button_cancel.setSize(100, 30);

		Button_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "  �¼��� �����Ǿ����ϴ�.", null, JOptionPane.PLAIN_MESSAGE);
			}
		});
		Button_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		nullLabel.setBounds(0, 10, 200, 30);
		seatLabel.setBounds(0, 40, 50, 30);
		inTime.setBounds(0, 70, 50, 30);
		outTime.setBounds(0, 100, 50, 30);
		warn.setBounds(0, 130, 100, 20);
		contextPane.add(nullLabel);
		contextPane.add(seatLabel);
		contextPane.add(inTime);
		contextPane.add(outTime);
		contextPane.add(warn);
		contextPane.add(Button_cancel);
		contextPane.add(Button_confirm);
		contextPane.setBounds(0, 100, 200, 300);
		contextPane.setOpaque(false);
		return contextPane;
		// add(contextPane);
	}

	static void createAndShowGUI() {
		JFrame frame_seat = new JFrame("�¼�����");
		frame_seat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CustomDialog newContentPane = new CustomDialog(frame_seat);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame_seat.setContentPane(newContentPane);

		frame_seat.pack();
		frame_seat.setBounds(10, 10, 300, 500);
		frame_seat.setVisible(true);
	}

	public static void main(String[] args) {
		createAndShowGUI();
		
	}

}