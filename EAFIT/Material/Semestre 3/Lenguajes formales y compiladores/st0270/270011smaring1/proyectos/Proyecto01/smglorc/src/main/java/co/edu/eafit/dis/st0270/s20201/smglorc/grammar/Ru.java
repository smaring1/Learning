package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Ru extends NonTerminal {

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Ru) {
    	    ret = true;
    	}
    	return ret;
    }

    public int hashCode() {
		return EnumGrammarSymbol.Ru.ordinal();
    }

    public String toString() {
		return "Ru";
    }
}
