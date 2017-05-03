package admin;

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

public class BezeroEgoeraAldatu {

	private JFrame frmBezeroarenEgoeraAldatu;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroEgoeraAldatu window = new BezeroEgoeraAldatu();
					window.frmBezeroarenEgoeraAldatu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BezeroEgoeraAldatu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBezeroarenEgoeraAldatu = new JFrame();
		frmBezeroarenEgoeraAldatu.setTitle("Bezeroaren egoera aldatu");
		frmBezeroarenEgoeraAldatu.setBounds(100, 100, 450, 151);
		frmBezeroarenEgoeraAldatu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBezeroarenEgoeraAldatu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBezerokodea = new JLabel("BezeroKodea:");
		lblBezerokodea.setBounds(88, 37, 85, 16);
		panel.add(lblBezerokodea);
		
		textField = new JTextField();
		textField.setBounds(196, 31, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.setAction(action);
		btnAldatu.setBounds(285, 66, 113, 25);
		panel.add(btnAldatu);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Egoera Aldatu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().bezeroEgoeraAldatu(textField.getText());
			frmBezeroarenEgoeraAldatu.dispose();
		}
	}
}
