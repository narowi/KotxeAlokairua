package hasierakoUi;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import admin.AdminLeihoa;
import bezeroa.BezeroLeihoa;
import kodea.MySQL;

import javax.swing.JLabel;

public class Login {

	private JFrame frame;
	private final Action action = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 410, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnSartu = new JButton("Sartu");
		btnSartu.setAction(action);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea");
		
		
		
		JLabel lblPasahitza = new JLabel("Pasahitza");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPasahitza)
						.addComponent(lblErabiltzailea))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1, 177, 177, 177)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSartu, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblErabiltzailea))
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
								.addComponent(lblPasahitza)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(34)
							.addComponent(btnSartu)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Sartu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String erabiltzaile = textField.getText();
			String pasahitza = textField_1.getText();
			if(erabiltzaile.equals("admin") && pasahitza.equals("admin")){
				new AdminLeihoa().main(null);
			}
			else if(MySQL.getMySQL().loginKonprobaketa(erabiltzaile,pasahitza)){
				new BezeroLeihoa(erabiltzaile).main(erabiltzaile);
			}
			else{
				String mezua="    Erabiltzaile edo pasahitz okerra, saiatu berriro.";
				new ErroreMezua(mezua).main(mezua);
			}
			frame.dispose();
		}
	}
}
