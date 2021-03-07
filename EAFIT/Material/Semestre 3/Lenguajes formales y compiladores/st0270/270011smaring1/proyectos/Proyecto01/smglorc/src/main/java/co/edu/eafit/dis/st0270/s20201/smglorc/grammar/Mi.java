package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Mi extends Terminal {

    public Mi(int col, int lin) {
	super(col, lin);
    }

    public Mi() {
	super(-1,-1);
    }
    
    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Mi) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	String res = super.toString();
	return new String("Mi "+ res);
    }


    public int hashCode() {
	return EnumGrammarSymbol.Mi.ordinal();
    }
}
