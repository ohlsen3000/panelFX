/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelfx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author ugz
 */
public class PanelFX extends Application {

	PanelController controller;

	PlayingSounds playingSounds;

	AlarmClock alarmClock;


	@Override
	public void start(final Stage primaryStage) {
		this.playingSounds = new PlayingSounds();

		this.controller = new PanelController(primaryStage, this.playingSounds);
		this.controller.show();

		this.alarmClock = new AlarmClock(this.playingSounds);
		this.alarmClock.run();


	}
	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args) {
		Application.launch(args);
	}
}
