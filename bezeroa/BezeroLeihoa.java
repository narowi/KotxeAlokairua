package bezeroa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kodea.MySQL;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import hasierakoUi.*;
public class BezeroLeihoa {

	private JFrame frmBezeroarenLeihoa;
	private final Action action = new SwingAction();
	private String kodea;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroLeihoa window = new BezeroLeihoa(args);
					window.frmBezeroarenLeihoa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BezeroLeihoa(String args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String pKodea) {
		frmBezeroarenLeihoa = new JFrame();
		frmBezeroarenLeihoa.setTitle("Bezeroaren leihoa");
		frmBezeroarenLeihoa.setBounds(100, 100, 348, 300);
		frmBezeroarenLeihoa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBezeroarenLeihoa.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnDatuPertsonalakSartualdatu = new JButton("Datu pertsonalak sartu/aldatu");
		btnDatuPertsonalakSartualdatu.setAction(action);
		btnDatuPertsonalakSartualdatu.setBounds(45, 35, 209, 25);
		panel.add(btnDatuPertsonalakSartualdatu);
		
		JButton btnKredituaGehitu = new JButton("Kreditua gehitu");
		btnKredituaGehitu.setAction(action_1);
		btnKredituaGehitu.setBounds(45, 73, 209, 25);
		panel.add(btnKredituaGehitu);
		
		JButton btnKotxeGasolindegiraEraman = new JButton("Kotxe gasolindegira eraman");
		btnKotxeGasolindegiraEraman.setBounds(45, 111, 209, 25);
		panel.add(btnKotxeGasolindegiraEraman);
		
		JButton btnKotxeBatAlokatu = new JButton("Kotxe bat alokatu");
		btnKotxeBatAlokatu.setAction(action_2);
		btnKotxeBatAlokatu.setBounds(45, 149, 209, 25);
		panel.add(btnKotxeBatAlokatu);
		
		JButton btnKotxeaItzuli = new JButton("Kotxea itzuli");
		btnKotxeaItzuli.setBounds(45, 186, 209, 25);
		panel.add(btnKotxeaItzuli);
		
		JButton btnItzuli = new JButton("Itzuli");
		btnItzuli.setAction(action_3);
		btnItzuli.setBounds(221, 224, 97, 25);
		panel.add(btnItzuli);
		
		this.kodea=pKodea;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Datu pertsonalak sartu/aldatu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new ErroreMezua("    gelaxka guztiak bete").main("    gelaxka guztiak bete");
			new DatuPertsonalakSartu_Aldatu(kodea).main(kodea);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Kreditua gehitu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new KredituaGehitu(kodea).main(kodea);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Kotxe bat alokatu");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new KotxeaAlokatu(kodea).main(kodea);
			MySQL.getMySQL().kotxeakImprimatu();
			
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Itzuli");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			new Hasiera().main(null);
		}
	}
}
