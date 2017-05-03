package bezeroa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kodea.MySQL;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class KrediturikGabe {

	private JFrame frame;
	private JTextField textField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private String kodea;

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KrediturikGabe window = new KrediturikGabe(args);
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
	public KrediturikGabe(String args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kreditua:");
		lblNewLabel.setBounds(31, 34, 56, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 31, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnKredituaGehitu = new JButton("Kreditua gehitu");
		btnKredituaGehitu.setAction(action);
		btnKredituaGehitu.setBounds(252, 30, 127, 25);
		panel.add(btnKredituaGehitu);
		
		JButton btnSistematikIrten = new JButton("Sistematik irten");
		btnSistematikIrten.setAction(action_1);
		btnSistematikIrten.setBounds(252, 120, 127, 25);
		panel.add(btnSistematikIrten);
		
		kodea=args;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Kreditua gehitu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().bezeroKredituaGehitu(kodea, Float.parseFloat(textField.getText()));
			frame.dispose();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Sistematik irten");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().bezeroEgoeraAldatu(kodea);//por ahroa lo damos de baja no hay metodo para sacarlo de sistema
			frame.dispose();
		}
	}
}
