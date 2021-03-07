package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Q9 extends PilotState {

    public Q9() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Q9) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
        return "Q9";
    }

    public int hashCode() {
        return EnumGrammarSymbol.Q9.ordinal();
    }
}
