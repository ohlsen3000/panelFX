package panelfx.poker.domain.model
class RankProportion {

	int rank
	double proportion



	private static RankProportion createFor(int rank, double proportion){
		return new RankProportion(rank: rank, proportion : proportion)
	}

	static RankProportion fromJson(def json){
		RankProportion rp = createFor(json.rank.toInteger(), json.proportion.toDouble())

		return rp
	}
}
