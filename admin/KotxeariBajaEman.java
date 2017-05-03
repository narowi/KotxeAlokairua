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

public class KotxeariBajaEman {

	private JFrame frmKotxeariBajaEman;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeariBajaEman window = new KotxeariBajaEman();
					window.frmKotxeariBajaEman.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KotxeariBajaEman() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKotxeariBajaEman = new JFrame();
		frmKotxeariBajaEman.setTitle("Kotxeari baja eman");
		frmKotxeariBajaEman.setBounds(100, 100, 384, 174);
		frmKotxeariBajaEman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmKotxeariBajaEman.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 35, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMatrikula = new JLabel("Matrikula");
		lblMatrikula.setBounds(42, 38, 56, 16);
		panel.add(lblMatrikula);
		
		JButton btnBajaEman = new JButton("Baja eman");
		btnBajaEman.setAction(action);
		btnBajaEman.setBounds(235, 80, 97, 25);
		panel.add(btnBajaEman);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Baja eman");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().kotxeBajaEman(textField.getText());
			frmKotxeariBajaEman.dispose();
		}
	}
}
