package panelfx.poker.domain.model

/**
 * Describes a poker game without change of the {@link PokerVariant} or {@link Limit} during the game.
 * A multi game type on the other hand is for instance 8-Game, HORSE or Dealer's Choice game.
 * @author Jother
 *
 */
class SingleGameType {

	String id

	PokerVariant variant

	Limit limit

	static SingleGameType fromJson(def json){
		SingleGameType sgt = new SingleGameType(id : json.id, variant: PokerVariant.valueOf(json.variant), limit: Limit.valueOf(json.limit))

		return sgt
	}
}
