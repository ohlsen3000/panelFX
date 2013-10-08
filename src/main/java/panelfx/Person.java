package panelfx;

public enum Person {

    ULTZ("CL-CZC0186XJH"), ULTZ_AT_HOME("Ulrich-Gratzs-MacBook-Pro.local") , JOTHER("CL-CZC1290JBF"), JUEDA("CL-CZC0186XJK"), SASCHER("CL-CZC0012C2D");

    private Person(String host){
        this.hostName = host;
    }

    private String hostName;

    public String getHostName() {
        return hostName;
    }
}
