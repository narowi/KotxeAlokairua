package admin;

import java.awt.EventQueue;
import kodea.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class BezeroBerria {

	private JFrame frmBezeroBerria;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroBerria window = new BezeroBerria();
					window.frmBezeroBerria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BezeroBerria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBezeroBerria = new JFrame();
		frmBezeroBerria.setTitle("Bezero berria ");
		frmBezeroBerria.setBounds(100, 100, 460, 270);
		frmBezeroBerria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBezeroBerria.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(218, 55, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 99, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Erabiltzaile kodea");
		lblNewLabel.setBounds(65, 58, 122, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setBounds(65, 102, 56, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Erabiltzailea sartu");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(249, 167, 151, 25);
		panel.add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Erabiltzailea sartu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().bezeroBerria(textField.getText(),textField_1.getText());
			frmBezeroBerria.dispose();
		}
	}
}
