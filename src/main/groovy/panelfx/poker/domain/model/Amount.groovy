package panelfx.poker.domain.model

public class Amount{

	double value = 0
	Currency currency = null


	public Amount(Map map){
		if (map.value){
			if (map.value instanceof Double){
				this.value = map.value
			}
			else {
				this.value = map.value.toDouble()
			}
		}
		if (map.currency){
			if (map.currency instanceof Currency){
				this.currency = map.currency
			}
			else {
				this.currency = Currency.valueOf(map.currency)
			}
		}
	}


	/**
	 *
	 */
	public Amount(){
	}

	public String toString(){
		return value.toString().plus(currency ? (' ' + currency) : '')
	}
}
