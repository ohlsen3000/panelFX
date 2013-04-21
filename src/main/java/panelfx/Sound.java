package panelfx;

public enum Sound {

	AAAAAAH("Aaaaaaah", "stoehner_fmr"), //
	ABSTECHEN("Stech ihn ab", "abstechen"), //
	ALARM("Alarm", "alarm"), //
	ALTOBELLI("Altobelli", "altobelli"), //
	ANNEE_NE("Annee-ne", "aneene"), //
	ANSTEHT("Ich sag dir", "ansteht"), //
	ASSERT("Essort", "essort"), //
	BAEM("Bäm", "baehm"), //
	BALLAD("Ballad", "ballad"), //
	BATTLE1("Battle 1", "eurobattle1"), //
	BATTLE3("Battle 3", "eurobattle3"), //
	BIDDE_IN_TROUBLE("bidde?", "bidde_veraengstigt"), //
	BIDDE_QUESTIONING("BIDDE?", "bidde_fragend"), //
	BIEKER("Bieker", "bieker"), //
	BULLSHIT("Bullshit", "bullshit"), //
	COFFEE("Kaffee", "kaffee"), //
	CONVERTER("Konverter", "konverter"), //
	COOL("Cool", "cool"), //
	CUBAGE("Cubage", "qbitch"), //
	DANKOEOE("Danköö", "dankoe"), //
	DELETE("Delete", "delate"), //
	DOMAIN("Domäne", "domaene"), //
	DOORBELL("Klingel 1. OG", "klingel"), //
	DU_BEISST("Du beisst", "du_beisst"), //
	EEHM("Eehm", "eehm"), //
	EINMAL_WAS("1 mal was", "was"), //
	ERBAERMLICH("Erbärmlich", "erbaermlich"), //
	ER_SIE("Er / Sie", "er_sie"), //
	FAHRRADKETTE("Hätte, hätte", "fahrradkette"),//
	FAIL("Fail", "gesch_reiner"), //
	FAIL_SATANIC("Fail Satanic", "gescheitert_satan"), //
	FALSCH("Falsch", "falsch"), //
	FEIERGEMEINDE("Feiergemeinde", "feiergemeinde"), //
	FOG("The Fog", "fog"), //
	FRANK_MUELLER("Frank Müller", "fmueller"), //
	FREAKING_IDIOTS("Freaking idiots", "freaking_idiots"),//
	GANZ_KLAR("Ganz klar", "ganzklar"), //
	GUDE_LAUNE("Gude Laune", "gude_laune"), //
	HILFE("Hilfe", "hilfe"), //
	HORHOR("HorHorHor", "kevin"), //
	HUST("Hust", "hust"), //
	JA_NATUERLICH("Ja, natürlich", "ja_natuerlich"), //
	JEOPARDY("Jeopardy", "jeopardy"), //
	KHAN("Khan", "khan"), //
	KNARZ("Knarz", "knarz_equalized"), //
	KONZEPT("Konzept", "konzept"), //
	KOTZEN("Kotzen", "kotzen"), //
	LASS_SEIN("Lass es sein", "lass_es_sein"), //
	LAUGHING_DIYER("Höhöhö", "ddr"), //
	LAUSCHANGRIFF("Listener", "lauschangriff"), //
	LOKAL("Lokal", "lokal"), //
	NEIN_FRALLER("Neeein", "nein_fmr"), //
	NEIN_MANN("Nein Mann", "neinmann"), //
	NEIN_ULTZ("Neein", "nein"), //
	NICHT_GESCHOBEN("Nicht geschoben", "nicht_geschoben"), //
	NJAEH("Njääh", "guidolf_njaeh"), //
	OEOEOEEY("Öööey", "oey"), //
	PURCHE("Purche", "purche"), //
	PUSH_IT("Push it", "pushit"), //
	QUEEN_TEN("Q T", "queen_ten"), //
	QUIET("Quiet!", "quiet"), //
	REAL("Real", "for_real"), //
	REMOTE("Remote", "remoot"), //
	REVERT("Reewert", "reewert"), //
	REWE("Rewe", "rewe"), //
	RICHTIG_GEPOKERT("Richtig gepokert", "richtig_gepokert"), //
	SCHAFSKAESE("Schafskäse", "schafskaese"), //
	SCHEISE("Scheise", "scheise"),//
	SCHEISS_LAUNE("Scheiß Laune", "laune"), //
	SCHLAEGEREI("Schlaegerei", "schlaegerei"), //
	SLAPSTICK("Slapstick", "hui"), //
	SNAPHOT("Snapshoot", "snapshoot"), //
	SO_NICHT("So nicht!", "sonicht"), //
	SO_SICK("So sick!", "so_sick"), //
	SORRY("Sorry", "sorry"), //
	SPIEL_LERNEN("Spiel lernen", "erst_noch_lernen"), //
	STANDUP("Stand up", "standup"), //
	STEELE2("Steele 2", "steele2"), //
	TACH("Tach", "tachzusammen"), //
	WAS_DENN("Was denn", "wasdenn"), // //
	WAS_DU_GLAUBST_JOTHER("Das ist das", "dasist"), //
	WAS_DU_GLAUBST_MAROHDE("Was Du glaubst", "was_du_glaubst"), //
	WAS_JETZT("Was jetzt?", "wasjetzt"), //
	WEIBSVOLK("Weibsvolk", "weibsvolk"), //
	WEISST_DUS("Weißt Du's?", "weisstdus"), //
	WIDERPORST("Widerporst", "widerporst"), //
	WIE_GEIL("Wie geil", "geil"), //
	ZUR_LIEFERUNG("Zur Lieferung", "lieferung"), //
	ZUR_SEITE("Zur Seite", "butch"), //
	ZWEIHUNDERT_PULS("200 Puls", "200puls"), //
	BILDSCHIRM("Bildschirm", "bildschirm") //
	;

	private String label;
	private String filename;

	private Sound(final String label, final String filename) {
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
