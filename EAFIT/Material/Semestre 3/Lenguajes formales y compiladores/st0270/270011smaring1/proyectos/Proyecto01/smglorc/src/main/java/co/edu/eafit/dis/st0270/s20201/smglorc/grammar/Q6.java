package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Q6 extends PilotState {

    public Q6() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Q6) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
        return "Q6";
    }

    public int hashCode() {
        return EnumGrammarSymbol.Q6.ordinal();
    }
}
