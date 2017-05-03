package bezeroa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import kodea.MySQL;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class DatuPertsonalakSartu_Aldatu {

	private JFrame frmDatuPertsonalakSartualdatu;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	private String kodea;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatuPertsonalakSartu_Aldatu window = new DatuPertsonalakSartu_Aldatu(args);
					window.frmDatuPertsonalakSartualdatu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatuPertsonalakSartu_Aldatu(String args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String pKodea) {
		frmDatuPertsonalakSartualdatu = new JFrame();
		frmDatuPertsonalakSartualdatu.setTitle("Datu pertsonalak sartu/aldatu");
		frmDatuPertsonalakSartualdatu.setBounds(100, 100, 382, 260);
		frmDatuPertsonalakSartualdatu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDatuPertsonalakSartualdatu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 26, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 61, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 96, 116, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Izena");
		lblNewLabel_1.setBounds(26, 29, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Abizena");
		lblNewLabel_2.setBounds(26, 64, 56, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Helbidea");
		lblNewLabel_3.setBounds(26, 99, 56, 16);
		panel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 131, 116, 22);
		panel.add(passwordField);
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		lblPasahitza.setBounds(26, 134, 56, 16);
		panel.add(lblPasahitza);
		
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.setAction(action);
		btnAldatu.setBounds(243, 163, 97, 25);
		panel.add(btnAldatu);
		
		this.kodea=pKodea;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Aldatu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().bezeroDatuakAldatu(kodea, passwordField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
			frmDatuPertsonalakSartualdatu.dispose();
		}
	}
}
