package LibraryManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class CustomDialogtest extends JPanel {
	JFrame frame;

	public CustomDialogtest(JFrame frame) {
		super(new BorderLayout());
		this.frame = frame;
		// Create the components.
		JPanel frequentPanel = createSimpleDialogBox();
		add(createSimpleDialogBox());
	}

	private JPanel createSimpleDialogBox() {

		JPanel contextPane = new JPanel();
		JButton Button_confirm = new JButton("배정");
		JButton Button_cancel = new JButton("취소");
		Label nullLabel = new Label("");
		Label seatLabel = new Label("좌석 : ");
		Label inTime = new Label("입실시간 : ");
		Label outTime = new Label("퇴실예정시간 :");
		Label warn = new Label("*퇴실 연장은 퇴실예정시간 1시간 전부터 가능");

		Button_confirm.setSize(100, 30);
		Button_cancel.setSize(100, 30);

		Button_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "  좌석이 배정되었습니다.", null, JOptionPane.PLAIN_MESSAGE);
			}
		});
		Button_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(frame, "취소");

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
		JFrame frame = new JFrame("좌석정보");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CustomDialogtest newContentPane = new CustomDialogtest(frame);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setBounds(10, 10, 300, 500);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		createAndShowGUI();

	}

}
