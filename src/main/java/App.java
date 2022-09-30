import javax.swing.JFrame;

import com.hotel.views.MenuPrincipal;

public class App {

	public static void main(String[] args) {
		MenuPrincipal app = new MenuPrincipal();
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
