package hasierakoUi;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.LayoutStyle.ComponentPlacement;

import Gonbidatua.GonbidatuLehioa;
import kodea.Kotxe;

public class Hasiera {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private static int aukera=0;
	private final Action action_3 = new SwingAction_3();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hasiera window = new Hasiera();
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
	public Hasiera() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		
		JRadioButton rdbtnLogeatu = new JRadioButton("Logeatu");
		rdbtnLogeatu.setAction(action_1);
		buttonGroup.add(rdbtnLogeatu);
		
		JRadioButton rdbtnErabiltzaileBezalaSartu = new JRadioButton("Gonbidatua");
		rdbtnErabiltzaileBezalaSartu.setAction(action_2);
		buttonGroup.add(rdbtnErabiltzaileBezalaSartu);
		
		JButton btnSartu_1 = new JButton("Sartu");
		btnSartu_1.setAction(action_3);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnLogeatu)
						.addComponent(rdbtnErabiltzaileBezalaSartu))
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(214, Short.MAX_VALUE)
					.addComponent(btnSartu_1)
					.addGap(25))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(60)
					.addComponent(rdbtnLogeatu)
					.addGap(35)
					.addComponent(rdbtnErabiltzaileBezalaSartu)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(btnSartu_1)
					.addGap(21))
		);
		panel_1.setLayout(gl_panel_1);
	}


	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			aukera=1;
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Gonbidatua");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			aukera=2;
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Sartu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(aukera==1){
				new Login().main(null);
			}
			else if(aukera==2){
				new GonbidatuLehioa().main(null);
			}
		}
	}
}
