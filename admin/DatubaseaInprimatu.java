package admin;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.*;
import java.awt.*;

public class DatubaseaInprimatu {

	private JFrame frmDatuBaseaInprimatu;
	private DefaultListModel modeloa;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatubaseaInprimatu window = new DatubaseaInprimatu();
					window.frmDatuBaseaInprimatu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatubaseaInprimatu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatuBaseaInprimatu = new JFrame();
		frmDatuBaseaInprimatu.setTitle("Datu basea inprimatu");
		frmDatuBaseaInprimatu.setBounds(100, 100, 450, 300);
		frmDatuBaseaInprimatu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmDatuBaseaInprimatu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		modeloa=new DefaultListModel();
		JList list = new JList();
		list.setBounds(25, 236, 375, -210);
		panel.add(list);
	}
	public void sartu(String pLerroa){
		modeloa.addElement(pLerroa);
		list.setModel(modeloa);
	}
}
