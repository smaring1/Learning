package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Q11 extends PilotState {

    public Q11() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Q11) {
    	    ret = true;
    	}
    	return ret;
    }


    public String toString() {
        return "Q11";
    }

    public int hashCode() {
        return EnumGrammarSymbol.Q11.ordinal();
    }
}
