package admin;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class KarburanteGutxi {

	private JFrame frmKatalogoaBilaketarenArabera;
	JTextArea textArea;
	private JButton btnListo;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(ArrayList<String> args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KarburanteGutxi window = new KarburanteGutxi(args);
					window.frmKatalogoaBilaketarenArabera.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KarburanteGutxi(ArrayList<String> args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> args) {
		frmKatalogoaBilaketarenArabera = new JFrame();
		frmKatalogoaBilaketarenArabera.setTitle("Katalogoa bilaketaren arabera");
		frmKatalogoaBilaketarenArabera.setBounds(100, 100, 505, 432);
		frmKatalogoaBilaketarenArabera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmKatalogoaBilaketarenArabera.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(12, 13, 463, 314);
		panel.add(textArea);
		
		btnListo = new JButton("Listo");
		btnListo.setAction(action);
		btnListo.setBounds(345, 347, 97, 25);
		panel.add(btnListo);
		idatzi(args);
		
	}
	public void idatzi(ArrayList<String> lista){
		Iterator<String> itr=lista.iterator();
		while(itr.hasNext()){
			
			this.textArea.append(itr.next());
			this.textArea.append("\n");
		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Listo");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			frmKatalogoaBilaketarenArabera.dispose();
		}
	}
}
