package panelfx.poker.domain.model


class ProportionalPayoutStructure  {


	String name
	List<RankProportion> rankProportions



	Amount getPayoutFor(int rank){

		if (!rankProportions){
			return null
		}

		return rankProportions.find { it->
			it.rank == rank
		}
	}

	static ProportionalPayoutStructure fromJson(def json){
		ProportionalPayoutStructure pps = new ProportionalPayoutStructure(name : json.name)

		List<RankProportion> rpList = []

		json.rankProperties.each {
			RankProportion rankProp = RankProportion.fromJson(it)
			rpList << rankProp
		}
		pps.rankProportions = rpList

		return pps
	}
}
