package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Q3 extends PilotState {

    public Q3() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Q3) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
        return "Q3";
    }

    public int hashCode() {
        return EnumGrammarSymbol.Q3.ordinal();
    }

    
}
