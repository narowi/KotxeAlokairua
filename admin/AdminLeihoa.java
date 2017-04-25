package admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class AdminLeihoa {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLeihoa window = new AdminLeihoa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLeihoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Bezero berria sartu");
		btnNewButton.setAction(action);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new BezeroBerria().main(null);
//			}
//		});
		btnNewButton.setBounds(36, 50, 226, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bezeroaren egoera aldatu");
		btnNewButton_1.setBounds(292, 50, 214, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Kotxe berria sartu");
		btnNewButton_2.setBounds(36, 110, 226, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Kotxe bati baja eman");
		btnNewButton_3.setBounds(292, 110, 214, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Kaburante gutxi dutenak ikusi");
		btnNewButton_4.setBounds(36, 170, 226, 25);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Kotxea gasolindegira eraman");
		btnNewButton_5.setBounds(292, 170, 214, 25);
		panel.add(btnNewButton_5);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Bezero berria sartu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new BezeroBerria().main(null);
		}
	}
}
