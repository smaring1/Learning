package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Q15 extends PilotState {

    public Q15() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Q15) {
    	    ret = true;
    	}
    	return ret;
    }


    public String toString() {
        return "Q15";
    }

    public int hashCode() {
        return EnumGrammarSymbol.Q15.ordinal();
    }
}
