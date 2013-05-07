package panelfx.poker.domain.repository;

import java.util.List;

import panelfx.poker.domain.model.ProportionalPayoutStructure;

public interface ProportionalPayoutStructureRepository {

	List<ProportionalPayoutStructure> findAll();
}
