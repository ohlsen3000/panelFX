package panelfx;

public enum Sound {

	AAAAAAH("Aaaaaaah", "stoehner_fmr"), ALARM("Alarm", "alarm"), ALTOBELLI(
			"Altobelli", "altobelli"), ANNEE_NE("Annee-ne", "aneene"), ANSTEHT(
			"Ich sag dir", "ansteht"), ASSERT("Essort", "essort"), BAEM("Bäm",
			"baehm"), BALLAD("Ballad", "ballad"), BATTLE1("Battle 1",
			"eurobattle1"), BATTLE3("Battle 3", "eurobattle3"), BIDDE_IN_TROUBLE(
			"bidde?", "bidde_veraengstigt"), BIDDE_QUESTIONING("BIDDE?",
			"bidde_fragend"), BIEKER("Bieker", "bieker"), BULLSHIT("Bullshit",
			"bullshit"), COFFEE("Kaffee", "kaffee"), CONVERTER("Konverter",
			"konverter"), COOL("Cool", "cool"), CUBAGE("Cubage", "qbitch"), DANKOEOE(
			"Danköö", "dankoe"), DELETE("Delete", "delate"), DOMAIN("Domäne",
			"domaene"), DOORBELL("Klingel 1. OG", "klingel"), EEHM("Eehm",
			"eehm"), EINMAL_WAS("1 mal was", "was"), ERBAERMLICH("Erbärmlich",
			"erbaermlich"), FAIL("Fail", "gesch_reiner"), FAIL_SATANIC(
			"Fail Satanic", "gescheitert_satan"), FALSCH("Falsch", "falsch"), FOG(
			"The Fog", "fog"), FRANK_MUELLER("Frank Müller", "fmueller"), GANZ_KLAR(
			"Ganz klar", "ganzklar"), HILFE("Hilfe", "hilfe"), HORHOR(
			"HorHorHor", "kevin"), HUST("Hust", "hust"), JEOPARDY("Jeopardy",
			"jeopardy"), KHAN("Khan", "khan"), KNARZ("Knarz", "knarz_equalized"), KONZEPT(
			"Konzept", "konzept"), KOTZEN("Kotzen", "kotzen"), LAUGHING_DIYER(
			"Höhöhö", "ddr"), LAUSCHANGRIFF("Listener", "lauschangriff"), LOKAL(
			"Lokal", "lokal"), NEIN_FRALLER("Neeein", "nein_fmr"), NEIN_MANN(
			"Nein Mann", "neinmann"), NEIN_ULTZ("Neein", "nein"), NJAEH(
			"Njääh", "guidolf_njaeh"), OEOEOEEY("Öööey", "oey"), PUSH_IT(
			"Push it", "pushit"), QUIET("Quiet!", "quiet"), REMOTE("Remote",
			"remoot"), REVERT("Reewert", "reewert"), REWE("Rewe", "rewe"), SCHAFSKAESE(
			"Schafskäse", "schafskaese"), SLAPSTICK("Slapstick", "hui"), SNAPHOT(
			"Snapshoot", "snapshoot"), SO_NICHT("So nicht!", "sonicht"), SORRY(
			"Sorry", "sorry"), SPIEL_LERNEN("Spiel lernen", "erst_noch_lernen"), STANDUP(
			"Stand up", "standup"), STEELE2("Steele 2", "steele2"), TACH(
			"Tach", "tachzusammen"), WAS_DENN("Was denn", "wasdenn"), WAS_DU_GLAUBST(
			"Das ist das", "dasist"), WAS_JETZT("Was jetzt?", "wasjetzt"), WEISST_DUS(
			"Weißt Du's?", "weisstdus"), WIE_GEIL("Wie geil", "geil"), ZUR_LIEFERUNG(
			"Zur Lieferung", "lieferung"), ZUR_SEITE("Zur Seite", "butch"), ABSTECHEN(
			"Stech ihn ab", "abstechen"), SCHEISS_LAUNE("Scheiss Laune",
			"laune"),
			GUDE_LAUNE("Gude Laune", "gude_laune"),
			SCHLAEGEREI("Schlaegerei", "schlaegerei"),
			FEIERGEMEINDE("Feiergemeinde", "feiergemeinde"),
			ZWEIHUNDERT_PULS("200 Puls", "200puls"),
			BILDSCHIRM("Bildschirm", "bildschirm"),
			SCHEISE("Scheise", "scheise");

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
