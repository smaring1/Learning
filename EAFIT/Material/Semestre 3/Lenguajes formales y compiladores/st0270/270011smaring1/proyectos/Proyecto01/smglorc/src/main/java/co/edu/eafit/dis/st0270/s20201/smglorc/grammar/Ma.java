package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Ma extends Terminal {

    public Ma(int col, int lin) {
	super(col, lin);
    }

    public Ma() {
	super(-1,-1);
    }
    
    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Ma) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	String res = super.toString();
	return new String("Ma "+ res);
    }


    public int hashCode() {
	return EnumGrammarSymbol.Ma.ordinal();
    }
}
