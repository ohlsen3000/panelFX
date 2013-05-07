package panelfx.poker.infrastructure.persistence;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.hamcrest.CoreMatchers;
import org.hamcrest.number.IsCloseTo;
import org.junit.Assert;
import org.junit.Test;

import panelfx.poker.ClasspathHelper;
import panelfx.poker.domain.model.ProportionalPayoutStructure;
import panelfx.poker.domain.model.RankProportion;

public class ProportionalPayoutStructureConfigTest {

	@Test
	public void testJson() throws JsonParseException, JsonMappingException,
			IOException {

		final double tolerance = 1E-14;

		final ObjectMapper mapper = new ObjectMapper();

		// read from file, convert it to ProportionalPayoutStructure class
		final List<ProportionalPayoutStructure> structures = mapper
				.readValue(
						ClasspathHelper.class
								.getResourceAsStream("proportionalPayoutStructure.json"),
						new TypeReference<List<ProportionalPayoutStructure>>() {
						});

		for (final ProportionalPayoutStructure struct : structures) {

			double sum = 0;
			for (final RankProportion prop : struct.getRankProportions()) {
				sum += prop.getProportion();
			}

			Assert.assertThat(sum,
					CoreMatchers.is(IsCloseTo.closeTo(1d, tolerance)));
		}

		// display to console
		System.out.println(structures);

		final StringWriter writer = new StringWriter();
		mapper.defaultPrettyPrintingWriter().writeValue(writer, structures);

		System.out.println(writer.toString());

		// TODO assertions

	}
}
