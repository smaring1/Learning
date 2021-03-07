package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class C extends NonTerminal {

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof C) {
    	    ret = true;
    	}
    	return ret;
    }

    public int hashCode() {
		return EnumGrammarSymbol.C.ordinal();
    }

    public String toString() {
		return "C";
    }
}
