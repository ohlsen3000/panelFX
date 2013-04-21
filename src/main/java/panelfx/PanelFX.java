/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panelfx;

import java.text.MessageFormat;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.UnsatisfiedResolutionException;
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

	public <T> T getBeanByName(final Class<T> type, final String name) // eg.
																		// name=availableCountryDao
	{
		final BeanManager bm = this.weldContainer.getBeanManager();

		final Set<Bean<?>> foundBeans = bm.getBeans(name);
		if (foundBeans == null || foundBeans.isEmpty()) {
			throw new UnsatisfiedResolutionException(MessageFormat.format(
					"type: {0}; name:{1}", type.getName(), name));
		}
		final Bean bean = foundBeans.iterator().next();
		final CreationalContext ctx = bm.createCreationalContext(bean); // could
																		// be
																		// inlined
																		// below
		return type.cast(bm.getReference(bean, type, ctx));
	}

	public <T> T getBeanByType(final Class<T> type) {
		final BeanManager bm = this.weldContainer.getBeanManager();

		final Set<Bean<?>> foundBeans = bm.getBeans(type);
		if (foundBeans == null || foundBeans.isEmpty()) {
			throw new UnsatisfiedResolutionException(MessageFormat.format(
					"type: {0}", type.getName()));
		}
		final Bean bean = foundBeans.iterator().next();
		final CreationalContext ctx = bm.createCreationalContext(bean); // could
																		// be
																		// inlined
																		// below
		return type.cast(bm.getReference(bean, type, ctx));
	}

	@SuppressWarnings("serial")
	@Override
	public void start(final Stage primaryStage) {
		// Let's initialize CDI/Weld.
		this.weldContainer = new Weld().initialize();

		// this.controller = getBeanByType(PanelController.class);

		this.weldContainer.instance()
				.select(ApplicationParametersProvider.class).get()
				.setParameters(getParameters());
		/**
		 * Make the application parameters injectable with a standard CDI
		 * annotation Now that JavaFX thread is ready let's inform whoever cares
		 * using standard CDI notification mechanism: CDI events
		 */
		this.weldContainer.event()
				.select(Stage.class, new AnnotationLiteral<StartupScene>() {
				}).fire(primaryStage);

		this.controller = this.weldContainer.instance()
				.select(PanelController.class).get();

		System.out.println("Panel started successfully. Have fun!");

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
