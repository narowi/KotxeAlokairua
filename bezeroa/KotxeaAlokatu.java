package bezeroa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import kodea.MySQL;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class KotxeaAlokatu {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();
	private String kodea;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeaAlokatu window = new KotxeaAlokatu(args);
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
	public KotxeaAlokatu(String args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 367, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(126, 13, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 56, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMatrikula = new JLabel("Matrikula");
		lblMatrikula.setBounds(31, 16, 56, 16);
		panel.add(lblMatrikula);
		
		JLabel lblEgunak = new JLabel("Egunak");
		lblEgunak.setBounds(31, 59, 56, 16);
		panel.add(lblEgunak);
		
		JButton btnAlokatu = new JButton("Alokatu");
		btnAlokatu.setAction(action);
		btnAlokatu.setBounds(221, 101, 97, 25);
		panel.add(btnAlokatu);
		
		kodea=args;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Alokatu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().kotxeaAlokatu(kodea, textField.getText(), Integer.parseInt(textField_1.getText()));
		}
	}
}
