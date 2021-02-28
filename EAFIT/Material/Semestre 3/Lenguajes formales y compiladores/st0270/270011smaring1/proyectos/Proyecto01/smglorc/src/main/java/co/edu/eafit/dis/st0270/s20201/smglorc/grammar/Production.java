package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public class Production {

    public static Production P1;
    public static Production P2;
	public static Production P3;
	public static Production P4;
	public static Production P5;
	public static Production P6;
	public static Production P7;
	public static Production P8;
	public static Production P9;
	public static Production P10;
	public static Production P11;

    static {
	GrammarSymbol[] rhsP1 = { new Ru(), new Eof() };
	P1 = new Production(new C(), rhsP1);
	GrammarSymbol[] rhsP2 = { new NT(), new Flecha(), new P(), new Coma(), new Ru() };
	P2 = new Production(new Ru(), rhsP2);
	GrammarSymbol[] rhsP3 = { new NT(), new Flecha(), new P()};
	P3 = new Production(new Ru(), rhsP3);
	GrammarSymbol[] rhsP4 = { };
	P4 = new Production(new Ru(), rhsP4);
	GrammarSymbol[] rhsP5 = { new RH(), new Palo(), new P() };
	P5 = new Production(new P(), rhsP5);
	GrammarSymbol[] rhsP6 = { new RH() };
	P6 = new Production(new P(), rhsP6);
	GrammarSymbol[] rhsP7 = { };
	P7 = new Production(new P(), rhsP7);
	GrammarSymbol[] rhsP8 = { new T(), new NT() };
	P8 = new Production(new RH(), rhsP8);
	GrammarSymbol[] rhsP9 = { new NT() };
	P9 = new Production(new RH(), rhsP9);
	GrammarSymbol[] rhsP10 = { new Mi() };
	P10 = new Production(new T(), rhsP10);
	GrammarSymbol[] rhsP11 = { new Ma() };
	P11 = new Production(new NT(), rhsP11);
	}

    private NonTerminal nt = null;
    private GrammarSymbol[] gss = null;

    public Production(NonTerminal nt, GrammarSymbol[] gss) {
	this.nt = nt;
	this.gss = gss;
    }

    public NonTerminal getLHS() {
	return nt;
    }

    public GrammarSymbol[] getRHS() {
	GrammarSymbol[] ret = new GrammarSymbol[gss.length];

	for (int i = gss.length - 1, j = 0; i >= 0; i--, j++) {
	    ret[j] = gss[i];
	}

	return ret;
    }
}
