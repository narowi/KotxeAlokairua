package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import kodea.MySQL;

public class KotxeaGasolindegiraEraman {

	private JFrame frmKotxeaGasolindegiraEraman;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeaGasolindegiraEraman window = new KotxeaGasolindegiraEraman();
					window.frmKotxeaGasolindegiraEraman.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KotxeaGasolindegiraEraman() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKotxeaGasolindegiraEraman = new JFrame();
		frmKotxeaGasolindegiraEraman.setTitle("Kotxea gasolindegira eraman");
		frmKotxeaGasolindegiraEraman.setBounds(100, 100, 384, 174);
		frmKotxeaGasolindegiraEraman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmKotxeaGasolindegiraEraman.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 35, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMatrikula = new JLabel("Matrikula");
		lblMatrikula.setBounds(42, 38, 56, 16);
		panel.add(lblMatrikula);
		
		JButton btnBajaEman = new JButton("Gasolindegira eraman");
		btnBajaEman.setAction(action);
		btnBajaEman.setBounds(152, 80, 180, 25);
		panel.add(btnBajaEman);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Gasolindegira eraman");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().kotxeaGasolindegiraEraman(textField.getText());
			frmKotxeaGasolindegiraEraman.dispose();
		}
	}

}
