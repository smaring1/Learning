package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class NT extends NonTerminal {

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof NT) {
    	    ret = true;
    	}
    	return ret;
    }

    public int hashCode() {
		return EnumGrammarSymbol.NT.ordinal();
    }

    public String toString() {
		return "NT";
    }
}
