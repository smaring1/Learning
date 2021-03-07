package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Eof extends Terminal {

    public Eof(int col, int lin) {
	super(col, lin);
    }

    public Eof() {
	super(-1,-1);
    }
    
    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof Eof) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	String res = super.toString();
	return new String("Eof "+ res);
    }


    public int hashCode() {
	return EnumGrammarSymbol.Eof.ordinal();
    }
}
