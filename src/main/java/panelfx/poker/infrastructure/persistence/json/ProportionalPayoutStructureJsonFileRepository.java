package panelfx.poker.infrastructure.persistence.json;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import panelfx.poker.ClasspathHelper;
import panelfx.poker.domain.model.ProportionalPayoutStructure;
import panelfx.poker.domain.repository.ProportionalPayoutStructureRepository;

public class ProportionalPayoutStructureJsonFileRepository implements
		ProportionalPayoutStructureRepository {

	ObjectMapper objectMapper = new ObjectMapper();
	String fileName = "proportionalPayoutStructure.json";

	@Override
	public List<ProportionalPayoutStructure> findAll() {
		List<ProportionalPayoutStructure> structures = null;
		try {
			structures = this.objectMapper.readValue(
					ClasspathHelper.class.getResourceAsStream(this.fileName),
					new TypeReference<List<ProportionalPayoutStructure>>() {
					});
		} catch (final IOException e) {
			// TODO Logging
		}

		return structures;
	}

}
