// Project CSI2120/CSI2520
// Winter 2026
// Robert Laganiere, uottawa.ca

// this is the (incomplete) Resident class
public class Resident {
	
	private int residentID;
	private String firstname;
	private String lastname;
	private String[] rol;
	private Program matchedProgram;
	private int matchedRank;
	private int nextProposalIndex;

	// constructs a Resident
    public Resident(int id, String fname, String lname) {
	
		residentID= id;
		firstname= fname;
		lastname= lname;
		matchedProgram = null;
		matchedRank = -1;
		nextProposalIndex = 0; // to iterate over all proposals
	}

    // the rol in order of preference
	public void setROL(String[] rol) {
		
		this.rol= rol;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Program getMatchedProgram() {
		return matchedProgram;
	}

	public boolean isMatched() {
		return matchedProgram != null;
	}

	public boolean hasMorePrograms() {
		return nextProposalIndex < rol.length;
	}

	public String getNextProgramID() {
		return rol[nextProposalIndex++];
	}

	public void match(Program p, int rank) {
		matchedProgram = p;
		matchedRank = rank;
	}

	public void unmatch() {
		matchedProgram = null;
		matchedRank = -1;
	}

	public int getID() {
		return residentID;
	}
	
	// string representation
	public String toString() {
      
       return "["+residentID+"]: "+firstname+" "+ lastname+" ("+rol.length+")";	  
	}
}