package panelfx;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Jother
 * Date: 27.06.13
 * Time: 08:07
 */
public class SimpleAccessDecisionManager {

    private String hostname = "";

    private Set<Person> fantasyNameAccess = EnumSet.of(Person.JOTHER, Person.ULTZ, Person.JUEDA, Person.SASCHER);

    public SimpleAccessDecisionManager() {
        try {
            this.hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Running on unknown host");
        }
    }

    public boolean hasFantasyNameAcceess(){
         for (Person person : this.fantasyNameAccess){
             if (person.getHostName().equals(this.hostname)){
                 return true;
             }
         }
       return false;
    }

    public boolean hasCriticalSoundAcceess(){
        for (Person person : this.fantasyNameAccess){
            if (person.getHostName().equals(this.hostname)){
                return true;
            }
        }
        return false;
    }
}
