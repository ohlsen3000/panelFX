package panelfx;


public enum Sound {


	WAS_JETZT("Was jetzt?", "wasjetzt"),
	EINMAL_WAS("1 mal was", "was"),
	ANSTEHT("Ich sag dir", "ansteht"),
	KONZEPT("Konzept", "konzept"),
	ZUR_SEITE("Zur Seite", "butch"),
	NEIN_MANN("Nein Mann", "neinmann"),
	STANDUP("Stand up", "standup"),
	CUBAGE("Cubage", "qbitch"),
	BATTLE1("Battle 1", "eurobattle1"),
	BATTLE3("Battle 3", "eurobattle3"),
	DOORBELL("Klingel 1. OG", "klingel"),
	ALARM("Alarm", "alarm"),
	PUSH_IT("Push it", "pushit"),
	OEOEOEEY("Öööey", "oey"),
	LAUSCHANGRIFF("Tosch Attack", "lauschangriff"),
	FOG("The Fog", "fog"),
	BAEM("Bäm", "baehm"),
	ERBAERMLICH("Erbärmlich", "erbaermlich"),
	HORHOR("HorHorHor", "kevin"),
	NEIN_ULTZ("Neein", "nein"),
	HILFE("Hilfe", "hilfe"),
	COOL("Cool", "cool"),
	KNARZ("Knarz", "knarz_equalized"),
	SORRY("Sorry", "sorry"),
	SCHAFSKAESE("Schafskäse", "schafskaese"),
	NEIN_FRALLER("Neeein", "nein_fmr"),
	AAAAAAH("Aaaaaaah", "stoehner_fmr"),
	FALSCH("Falsch", "falsch"),
	DANKOEOE("Danköö", "dankoe"),
	BULLSHIT("Bullshit", "bullshit"),
	KOTZEN("Kotzen", "kotzen"),
	HUST("Hust", "hust"),
	FRANK_MUELLER("Frank Müller", "fmueller"),
	ZUR_LIEFERUNG("Zur Lieferung", "lieferung"),
	STEELE2("Steele 2", "steele2"),
	BIEKER("Bieker", "bieker"),
	BALLAD("Ballad", "ballad"),
	JEOPARDY("Jeopardy", "jeopardy"),
	REMOTE("Remote", "remoot"),
	DELETE("Delete", "delate"),
	SNAPHOT("Snapshoot", "snapshoot"),
	KHAN("Khan", "khan"),
	ASSERT("Essort", "essort"),
	WIE_GEIL("Wie geil", "geil"),
	FAIL("Fail", "gesch_reiner"),
	FAIL_SATANIC("Fail Satanic", "gescheitert_satan"),
	QUIET("Quiet!", "quiet"),
	LAUGHING_DIYER("Höhöhö", "ddr"),
	GANZ_KLAR("Ganz klar", "ganzklar"),
	ALTOBELLI("Altobelli", "altobelli"),
	TACH("Tach", "tachzusammen"),
	LOKAL("Lokal", "lokal"),
	WAS_DENN("Was denn", "wasdenn"),
	BIDDE_QUESTIONING("BIDDE?", "bidde_fragend"),
	BIDDE_IN_TROUBLE("bidde?", "bidde_veraengstigt"),
	REVERT("Reewert", "reewert"),
	REWE("Rewe", "rewe"),
	WAS_DU_GLAUBST("Das ist das", "dasist"),
	EEHM("Eehm", "eehm"),
	DOMAIN("Domäne", "domaene"),
	SO_NICHT("So nicht!", "sonicht"),
	WEISST_DUS("Weißt Du's?", "weisstdus"),
	CONVERTER("Konverter", "konverter"),
	COFFEE("Kaffee", "kaffee"),
	ANNEE_NE("Annee-ne", "aneene")
	;
	private String label;
	private String filename;

	private Sound(final String label, final String filename){
		this.label = label;
		this.filename = filename;
	}

	public String getLabel() {
		return this.label;
	}

	public String getFilename() {
		return this.filename;
	}

}
