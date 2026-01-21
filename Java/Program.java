// Project CSI2120/CSI2520
// Winter 2026
// Robert Laganiere, uottawa.ca

// this is the (incomplete) Program class
public class Program {
	
	private final String programID;
	private final String name;
	private final int quota;
	private int[] rol;
    private final int[] matchedResidents;
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
        matchedResidents[++numberOfResidents] = residentID;
        var rank = rank(residentID);
        if(rank < 0 || rank < rank(leastPreferred()))
            leastPreferredMember = residentID;
    }

    public void swapResidents(int incoming, int outgoing) {
        //TODO:
        // Find index of outgoing resident
        // Put incoming resident in their spot
        // Get the outgoing resident
        // Remove their active program and set it back to none

        for(int i = 0; i < numberOfResidents; i++) {
            if (matchedResidents[i] == outgoing) {
                matchedResidents[i] = incoming;
                break;
            }
        }
        if(outgoing == leastPreferredMember) {
            leastPreferredMember = incoming;
            findNewLeastPreferred();
        }
    }

    private void findNewLeastPreferred() {
        var leastRank = rank(leastPreferredMember);
        for(int i = 0; i < numberOfResidents; i++) {
            var rank = rank(matchedResidents[i]);
            if(rank < 0) {
                leastPreferredMember = matchedResidents[i];
                return;
            } else if(rank > leastRank) {
                leastPreferredMember = matchedResidents[i];
            }
        }
    }

    public String getName() {
        return name;
    }
    public int[] getMatchedResidents() {
        return matchedResidents;
    }
}