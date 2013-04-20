/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelfx;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * @author ugz
 */
public class PanelFX extends Application {


	PanelController controller;
	WeldContainer weldContainer;

	AlarmClock alarmClock;

	public Object getBeanByName(final String name, final Class<?> type) // eg. name=availableCountryDao
	{
		final BeanManager bm = this.weldContainer.getBeanManager();
		final Bean bean = bm.getBeans(name).iterator().next();
		final CreationalContext ctx = bm.createCreationalContext(bean); // could be inlined below
		final Object o = bm.getReference(bean, type, ctx); // could be inlined with return
		return o;
	}

	@SuppressWarnings("serial")
	@Override
	public void start(final Stage primaryStage) {
		// Let's initialize CDI/Weld.
		this.weldContainer = new Weld().initialize();
		// Make  the application parameters  injectable with a standard CDI annotation
		//		weldContainer.instance().select(ApplicationParametersProvider.class).get().setParameters(getParameters());
		// Now that JavaFX thread is ready let's inform whoever cares using standard CDI notification mechanism:
		// CDI events
		this.weldContainer.event().select(Stage.class, new AnnotationLiteral<StartupScene>() {}).fire(primaryStage);

		//
		//		final Set<Bean<?>> beans =
		//				this.weldContainer.getBeanManager().getBeans(PlayingSounds.class, new AnnotationLiteral<Any>(){});
		//
		//		final Bean<?> pS = beans.iterator().next();
		//
		//		final CreationalContext ctx = this.weldContainer.getBeanManager().createCreationalContext(pS); // could be inlined below
		final PlayingSounds playingSounds = (PlayingSounds) getBeanByName("playingSounds", PlayingSounds.class);
		this.controller = new PanelController(primaryStage, playingSounds);
		this.controller.show();

		this.alarmClock = new AlarmClock(playingSounds);
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
