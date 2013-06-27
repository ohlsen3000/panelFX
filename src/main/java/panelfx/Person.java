package panelfx;

/**
 * Created with IntelliJ IDEA.
 * User: Johannes Günther
 * Date: 27.06.13
 * Time: 08:14
 */
public enum Person {

    ULTZ("CL-CZC0186XJH"), JOTHER("CL-CZC1290JBF"), JUEDA("CL-CZC0186XJK"), SASCHER("CL-CZC0012C2D");

    private Person(String host){
        this.hostName = host;
    }

    private String hostName;

    public String getHostName() {
        return hostName;
    }
}
