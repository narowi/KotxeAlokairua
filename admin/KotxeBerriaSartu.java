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

public class KotxeBerriaSartu {

	private JFrame frmKotxeBerriaSartu;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KotxeBerriaSartu window = new KotxeBerriaSartu();
					window.frmKotxeBerriaSartu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KotxeBerriaSartu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKotxeBerriaSartu = new JFrame();
		frmKotxeBerriaSartu.setTitle("Kotxe berria sartu");
		frmKotxeBerriaSartu.setBounds(100, 100, 412, 363);
		frmKotxeBerriaSartu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmKotxeBerriaSartu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(176, 25, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 60, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 95, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(176, 130, 116, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(176, 165, 116, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(176, 200, 116, 22);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(176, 235, 116, 22);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Matrikula");
		lblNewLabel.setBounds(26, 28, 117, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marka");
		lblNewLabel_1.setBounds(26, 63, 117, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prezioa");
		lblNewLabel_2.setBounds(26, 98, 117, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Ate kopurua");
		lblNewLabel_4.setBounds(26, 133, 117, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Aire egokitua");
		lblNewLabel_5.setBounds(26, 168, 117, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Depositu tamaina");
		lblNewLabel_6.setBounds(26, 203, 117, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Karburante mota");
		lblNewLabel_7.setBounds(26, 238, 117, 16);
		panel.add(lblNewLabel_7);
		
		JButton btnKotxeaGehitu = new JButton("Kotxea gehitu");
		btnKotxeaGehitu.setAction(action);
		btnKotxeaGehitu.setBounds(243, 270, 128, 25);
		panel.add(btnKotxeaGehitu);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Kotxea gehitu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().kotxeBerria(textField.getText(), textField_1.getText(), Float.parseFloat(textField_2.getText()), Integer.parseInt(textField_4.getText()), textField_5.getText(), Float.parseFloat(textField_6.getText()), textField_7.getText());
		    frmKotxeBerriaSartu.dispose();
		}
	}
}
