// Project CSI2120/CSI2520
// Winter 2026
// Robert Laganiere, uottawa.ca

// this is the (incomplete) Program class
public class Program {
	
	private String programID;
	private String name;
	private int quota;
	private int[] rol;
    private int[] matchedResidents;
    private int leastPreferredMember;
    private int numberOfResidents;
	
	// constructs a Program
    public Program(String id, String n, int q) {
		programID= id;
        name= n;
        quota= q;
        matchedResidents = new int[quota];
    }

    // the rol in order of preference
	public void setROL(int[] rol) {
		
		this.rol= rol;
	}
	
	// string representation
	public String toString() {
      
       return "["+programID+"]: "+name+" {"+ quota+ "}" +" ("+rol.length+")";	  
	}

    public boolean member(int memberID) {
        for(var mem : matchedResidents) {
            if (mem == memberID)
                    return true;
        }
        return false;
    }

    public int rank(int memberID) {
        for(int i = 0; i < rol.length; i++) {
            if(rol[i] == memberID)
                return i;
        }
        return -1;
    }

    public int leastPreferred() {
        return leastPreferredMember;
    }

    public void addResident(int residentID) {
        numberOfResidents++;
        if(numberOfResidents < quota) {
            matchedResidents[numberOfResidents]=residentID;
        } else if(rank(residentID) >= leastPreferred()) {
            
        }
        numberOfResidents--;
    }

    private void swapResidents(int incomming, int outgoing) {

    }
}