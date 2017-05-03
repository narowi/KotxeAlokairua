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

public class KredituaGehitu {

	private JFrame frmKredituaGehitu;
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
					KredituaGehitu window = new KredituaGehitu(args);
					window.frmKredituaGehitu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KredituaGehitu(String args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String args) {
		frmKredituaGehitu = new JFrame();
		frmKredituaGehitu.setTitle("Kreditua gehitu");
		frmKredituaGehitu.setBounds(100, 100, 345, 138);
		frmKredituaGehitu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmKredituaGehitu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(110, 13, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblKreditua = new JLabel("Kreditua");
		lblKreditua.setBounds(27, 16, 56, 16);
		panel.add(lblKreditua);
		
		JButton btnGehitu = new JButton("Gehitu");
		btnGehitu.setAction(action);
		btnGehitu.setBounds(218, 48, 97, 25);
		panel.add(btnGehitu);
		
		kodea=args;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Gehitu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().bezeroKredituaGehitu(kodea, Float.parseFloat(textField.getText()));
			frmKredituaGehitu.dispose();
		}
	}
}
