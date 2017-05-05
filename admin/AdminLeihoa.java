package admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kodea.MySQL;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import hasierakoUi.*;
public class AdminLeihoa {

	private JFrame frmAdministratzaileLeihoa;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLeihoa window = new AdminLeihoa();
					window.frmAdministratzaileLeihoa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLeihoa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministratzaileLeihoa = new JFrame();
		frmAdministratzaileLeihoa.setTitle("Administratzaile leihoa");
		frmAdministratzaileLeihoa.setBounds(100, 100, 550, 375);
		frmAdministratzaileLeihoa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAdministratzaileLeihoa.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Bezero berria sartu");
		btnNewButton.setAction(action);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new BezeroBerria().main(null);
//			}
//		});
		btnNewButton.setBounds(36, 50, 226, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bezeroaren egoera aldatu");
		btnNewButton_1.setAction(action_3);
		btnNewButton_1.setBounds(292, 50, 214, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Kotxe berria sartu");
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.setBounds(36, 110, 226, 25);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Kotxe bati baja eman");
		btnNewButton_3.setAction(action_4);
		btnNewButton_3.setBounds(292, 110, 214, 25);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Kaburante gutxi dutenak ikusi");
		btnNewButton_4.setAction(action_1);
		btnNewButton_4.setBounds(36, 170, 226, 25);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Kotxea gasolindegira eraman");
		btnNewButton_5.setAction(action_5);
		btnNewButton_5.setBounds(292, 170, 214, 25);
		panel.add(btnNewButton_5);
		
		JButton btnIrten = new JButton("Irten");
		btnIrten.setAction(action_6);
		btnIrten.setBounds(409, 261, 97, 25);
		panel.add(btnIrten);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Bezero berria sartu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new BezeroBerria().main(null);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "karburante gutxi dutenak ikusi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			MySQL.getMySQL().karburanteGutxikoKotxeak();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Kotxe berria sartu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new KotxeBerriaSartu().main(null);
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Bezeroaren egoera aldatu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new BezeroEgoeraAldatu().main(null);
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Kotxe bati baja eman");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new KotxeariBajaEman().main(null);
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Kotxea gasolindegira eraman");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new KotxeaGasolindegiraEraman().main(null);
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Irten");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new Hasiera().main(null);
			frmAdministratzaileLeihoa.dispose();
		}
	}
}
