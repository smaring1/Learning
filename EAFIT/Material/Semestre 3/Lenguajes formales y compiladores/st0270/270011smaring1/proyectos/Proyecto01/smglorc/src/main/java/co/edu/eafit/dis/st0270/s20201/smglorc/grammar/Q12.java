package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Q12 extends PilotState {

    public Q12() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Q12) {
    	    ret = true;
    	}
    	return ret;
    }


    public String toString() {
        return "Q12";
    }

    public int hashCode() {
        return EnumGrammarSymbol.Q12.ordinal();
    }
}
