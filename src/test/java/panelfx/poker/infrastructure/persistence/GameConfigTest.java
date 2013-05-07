package panelfx.poker.infrastructure.persistence;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import panelfx.poker.ClasspathHelper;
import panelfx.poker.domain.model.SingleGameType;

public class GameConfigTest {

	@Test
	public void testJson() throws JsonParseException, JsonMappingException,
			IOException {

		final ObjectMapper mapper = new ObjectMapper();

		// read from file, convert it to user class
		final List<SingleGameType> games = mapper.readValue(
				ClasspathHelper.class
						.getResourceAsStream("singleGameType.json"),
				new TypeReference<List<SingleGameType>>() {
				});
		// display to console

		System.out.println(games);

		final StringWriter writer = new StringWriter();
		mapper.defaultPrettyPrintingWriter().writeValue(writer, games);

		System.out.println(writer.toString());

		// TODO assertions

	}
}
