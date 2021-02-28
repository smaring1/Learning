package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class P extends NonTerminal {

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof P) {
    	    ret = true;
    	}
    	return ret;
    }

    public int hashCode() {
		return EnumGrammarSymbol.P.ordinal();
    }

    public String toString() {
		return "P";
    }
}
