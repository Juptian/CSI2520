// Project CSI2120/CSI2520
// Winter 2026
// Robert Laganiere, uottawa.ca

// this is the (incomplete) Resident class
public class Resident {
	
	private int residentID;
	private String firstname;
	private String lastname;
	private String[] rol;
    private String matchedProgram;
    private int matchedRank;
	
	// constructs a Resident
    public Resident(int id, String fname, String lname) {
	
		residentID = id;
		firstname = fname;
		lastname = lname;
	}

    // the rol in order of preference
	public void setROL(String[] rol) {
		this.rol = rol;
	}
	public String[] getROL() {
        return rol;
    }
	// string representation
	public String toString() {
      
       return "["+residentID+"]: "+firstname+" "+ lastname+" ("+rol.length+")";	  
	}

    public String getMatchedProgram() {
        return matchedProgram;
    }

    public void setMatchedProgram(String matchedProgram) {
        this.matchedProgram = matchedProgram;
    }
    public int getMatchedRank() {
        return matchedRank;
    }
    public void setMatchedRank(int matchedRank) {
        this.matchedRank = matchedRank;
    }

    public String getName() {
        return "[" + residentID + "]: " + firstname + " " + lastname;
    }

    public String getOutputText() {
        var sb = new StringBuilder();
        sb.append(lastname + ",");
        sb.append(firstname + ",");
        sb.append(residentID + ",");
        sb.append(matchedProgram + ",");
    }
}