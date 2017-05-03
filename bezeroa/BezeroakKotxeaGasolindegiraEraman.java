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

public class BezeroakKotxeaGasolindegiraEraman {

	private JFrame frmKotxeaGasolindegiraEraman;
	private JTextField textField;
	private final Action action = new SwingAction();
	private String kodea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroakKotxeaGasolindegiraEraman window = new BezeroakKotxeaGasolindegiraEraman(args);
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
	public BezeroakKotxeaGasolindegiraEraman(String args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String args) {
		frmKotxeaGasolindegiraEraman = new JFrame();
		frmKotxeaGasolindegiraEraman.setTitle("Kotxea gasolindegira eraman");
		frmKotxeaGasolindegiraEraman.setBounds(100, 100, 441, 138);
		frmKotxeaGasolindegiraEraman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmKotxeaGasolindegiraEraman.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 13, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Zenbat litro");
		lblNewLabel.setBounds(36, 16, 97, 16);
		panel.add(lblNewLabel);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.setAction(action);
		btnGehitu.setBounds(297, 42, 97, 25);
		panel.add(btnGehitu);
		
		kodea=args;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Gehitu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().bezeroKotxeaGasolindegira(kodea, Float.parseFloat(textField.getText()));
			frmKotxeaGasolindegiraEraman.dispose();
		}
	}
}
