// Project CSI2120/CSI2520
// Winter 2026
// Robert Laganiere, uottawa.ca

import java.util.ArrayList;

// this is the (incomplete) Program class
public class Program {
	
	private String programID;
	private String name;
	private int quota;
	private int[] rol;
	private ArrayList<Resident> matchedResidents;	// List of residents matched to program
	
	// constructs a Program
    public Program(String id, String n, int q) {
	
		programID= id;
		name= n;
		quota= q;
		matchedResidents = new ArrayList<>();
	}

    // the rol in order of preference
	public void setROL(int[] rol) {
		
		this.rol= rol;
	}

	public String getName() {
		return name;
	}

	public int getQuota() {
		return quota;
	}

	public int getFilledPositions() {
		return matchedResidents.size();
	}

	public String getProgramID() {
		return programID;
	}

	// Member
	public boolean member(int residentID) {
		for (int r : rol)
			if (r == residentID) return true;
		return false;
	}

	// Rank
	public int rank(int residentID) {
		for (int i = 0; i < rol.length; i++)
			if (rol[i] == residentID) return i;
		return -1;
	}

	// leastPreferred
	public Resident leastPreferred() {
		Resident worst = null;
		int worstRank = -1;

		for (Resident r : matchedResidents) {
			int rank = rank(r.getID());
			if (rank > worstRank) {
				worstRank = rank;
				worst = r;
			}
		}
		return worst;
	}

	// addResident
	public boolean addResident(Resident r) {
		int rRank = rank(r.getID());
		if (rRank == -1) return false;

		if (matchedResidents.size() < quota) {
			matchedResidents.add(r);
			r.match(this, rRank);
			return true;
		}

		Resident worst = leastPreferred();
		if (rank(worst.getID()) > rRank) {
			matchedResidents.remove(worst);
			worst.unmatch();
			matchedResidents.add(r);
			r.match(this, rRank);
			return true;
		}
		return false;
	}

	// string representation
	public String toString() {
      
       return "["+programID+"]: "+name+" {"+ quota+ "}" +" ("+rol.length+")";	  
	}
}