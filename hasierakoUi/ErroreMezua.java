package hasierakoUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ErroreMezua {

	private JFrame frame;
	private static String mezua;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErroreMezua window = new ErroreMezua(mezua);
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
	public ErroreMezua(String mezu) {
		mezua=mezu;
		initialize(mezua);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String mezua) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 105);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel(mezua);
		frame.getContentPane().add(label, BorderLayout.NORTH);
		
		JButton btnAdos = new JButton("Ados");
		btnAdos.setAction(action);
		btnAdos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnAdos, BorderLayout.EAST);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Ados");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	}
}
