package Gonbidatua;

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


public class GonbidatuLehioa {

	private JFrame frmGonbidatuLehioa;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GonbidatuLehioa window = new GonbidatuLehioa();
					window.frmGonbidatuLehioa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GonbidatuLehioa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGonbidatuLehioa = new JFrame();
		frmGonbidatuLehioa.setTitle("Gonbidatu Lehioa");
		frmGonbidatuLehioa.setBounds(100, 100, 450, 300);
		frmGonbidatuLehioa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmGonbidatuLehioa.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Bezeroaren egoera aldatu");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(292, 50, 214, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kotxe berria sartu");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(36, 110, 226, 25);
		panel.add(btnNewButton_1);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Katalogoa ikusi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new KatalogoaIkusi().main(null);
		}
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Kotxe berriak ikusi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new KotxeBerriakIkusi().main(null);
		}
	}

}
