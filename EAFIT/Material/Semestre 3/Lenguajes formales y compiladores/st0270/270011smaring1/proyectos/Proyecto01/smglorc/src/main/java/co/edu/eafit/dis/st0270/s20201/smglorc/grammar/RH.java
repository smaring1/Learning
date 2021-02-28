package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class RH extends NonTerminal {

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof RH) {
    	    ret = true;
    	}
    	return ret;
    }

    public int hashCode() {
		return EnumGrammarSymbol.RH.ordinal();
    }

    public String toString() {
		return "RH";
    }
}
