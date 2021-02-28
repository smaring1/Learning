package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Q13 extends PilotState {

    public Q13() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Q13) {
    	    ret = true;
    	}
    	return ret;
    }


    public String toString() {
        return "Q13";
    }

    public int hashCode() {
        return EnumGrammarSymbol.Q13.ordinal();
    }
}
