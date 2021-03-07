package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Flecha extends Terminal {

    public Flecha(int col, int lin) {
	super(col, lin);
    }

    public Flecha() {
	super(-1,-1);
    }
    
    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Flecha) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	String res = super.toString();
	return new String("::= "+ res);
    }


    public int hashCode() {
	return EnumGrammarSymbol.Flecha.ordinal();
    }
}
