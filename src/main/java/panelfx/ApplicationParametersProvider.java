package panelfx;

import javafx.application.Application.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

//@ApplicationScoped
public class ApplicationParametersProvider {
	private Parameters parameters;

	public ApplicationParametersProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	void setParameters(Parameters p) {
		this.parameters = p;
	}
	@Produces
	public  Parameters getParameters() {
		return parameters;
	}
}
