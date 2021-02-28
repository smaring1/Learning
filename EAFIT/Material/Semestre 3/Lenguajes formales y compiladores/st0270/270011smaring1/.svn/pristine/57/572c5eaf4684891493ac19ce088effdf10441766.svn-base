package co.edu.eafit.dis.st0270.s20201.smglorc.parser;

import co.edu.eafit.dis.st0270.s20201.smglorc.abs.*;
import co.edu.eafit.dis.st0270.s20201.smglorc.grammar.*;
import co.edu.eafit.dis.st0270.s20201.smglorc.lexer.CfglreLexer;
import co.edu.eafit.dis.st0270.s20201.smglorc.parser.CfglreParser;
import co.edu.eafit.dis.st0270.s20201.smglorc.parser.CfglreParserException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;


public class CfglreParser {

    private CfglreLexer  gicl = null;
    private Terminal   cc  = null;
    private static Map<PilotState,Map<GrammarSymbol,PilotState>> pilotMap;
    private static Map<PilotState,Map<Terminal,Production>> reductionMap;

    static {
	// Q0
	pilotMap     = new HashMap<PilotState, Map<GrammarSymbol,PilotState>>();
	Map<GrammarSymbol,PilotState> nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new Ru(), new Q1());
	nextStateMap.put(new NT(), new Q2());
	nextStateMap.put(new Ma(), new Q3());
	pilotMap.put(new Q0(), nextStateMap);
	// Q1
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new Eof(), new Q4());
	pilotMap.put(new Q1(), nextStateMap);
	// Q2
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new Flecha(), new Q5());
	pilotMap.put(new Q2(), nextStateMap);
	// Q3
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q3(), nextStateMap);
	// Q4
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q4(), nextStateMap);
	// Q5
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new P(), new Q6());
	nextStateMap.put(new RH(), new Q7());
	nextStateMap.put(new T(), new Q8());
	nextStateMap.put(new NT(), new Q9());
	nextStateMap.put(new Mi(), new Q10());
	nextStateMap.put(new Ma(), new Q11());
	pilotMap.put(new Q5(), nextStateMap);
	// Q6
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new Coma(), new Q12());
	pilotMap.put(new Q6(), nextStateMap);
	// Q7
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new Palo(), new Q13());
	pilotMap.put(new Q7(), nextStateMap);
	// Q8
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new NT(), new Q14());
	nextStateMap.put(new Ma(), new Q11());
	pilotMap.put(new Q8(), nextStateMap);
	// Q9
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q9(), nextStateMap);
	// Q10
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q10(), nextStateMap);
	// Q11
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q11(), nextStateMap);
	// Q12
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new Ru(), new Q15());
	nextStateMap.put(new NT(), new Q2());
	nextStateMap.put(new Ma(), new Q3());
	pilotMap.put(new Q12(), nextStateMap);
	// Q13
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new P(), new Q16());
	nextStateMap.put(new RH(), new Q7());
	nextStateMap.put(new T(), new Q8());
	nextStateMap.put(new NT(), new Q9());
	nextStateMap.put(new Mi(), new Q10());
	nextStateMap.put(new Ma(), new Q11());
	pilotMap.put(new Q13(), nextStateMap);
	// Q14
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q14(), nextStateMap);
	// Q15
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q15(), nextStateMap);
	// Q16
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new Q16(), nextStateMap);
	
	// Implementing the reduction map
	reductionMap = new HashMap<PilotState, Map<Terminal,Production>>();
	// Q0
	Map<Terminal,Production> nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Eof(), Production.P4);
	reductionMap.put(new Q0(), nextProductionMap);
	// Q3
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Flecha(), Production.P11);
	reductionMap.put(new Q3(), nextProductionMap);
	// Q4
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Eof(), Production.P1);
	reductionMap.put(new Q4(), nextProductionMap);
	// Q5
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Coma(), Production.P7);
	nextProductionMap.put(new Eof(), Production.P7);
	reductionMap.put(new Q5(), nextProductionMap);
	// Q6
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Eof(), Production.P3);
	reductionMap.put(new Q6(), nextProductionMap);
	// Q7
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Coma(), Production.P6);
	nextProductionMap.put(new Eof(), Production.P6);
	reductionMap.put(new Q7(), nextProductionMap);
	// Q9
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Palo(), Production.P9);
	nextProductionMap.put(new Coma(), Production.P9);
	nextProductionMap.put(new Eof(), Production.P9);
	reductionMap.put(new Q9(), nextProductionMap);
	// Q10
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Ma(), Production.P10);
	reductionMap.put(new Q10(), nextProductionMap);
	// Q11
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Palo(), Production.P11);
	nextProductionMap.put(new Coma(), Production.P11);
	nextProductionMap.put(new Eof(), Production.P11);
	reductionMap.put(new Q11(), nextProductionMap);
	// Q12
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Eof(), Production.P4);
	reductionMap.put(new Q12(), nextProductionMap);
	// Q13
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Coma(), Production.P7);
	nextProductionMap.put(new Eof(), Production.P7);
	reductionMap.put(new Q13(), nextProductionMap);
	// Q14
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Palo(), Production.P8);
	nextProductionMap.put(new Coma(), Production.P8);
	nextProductionMap.put(new Eof(), Production.P8);
	reductionMap.put(new Q14(), nextProductionMap);
	// Q15
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Eof(), Production.P2);
	reductionMap.put(new Q15(), nextProductionMap);
	// Q16
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new Coma(), Production.P5);
	nextProductionMap.put(new Eof(), Production.P5);
	reductionMap.put(new Q16(), nextProductionMap);
    }

    public CfglreParser(CfglreLexer gicl) {
	this.gicl = gicl;
    }

    public CfglreAbs parser()
	throws CfglreParserException, IOException {

	Stack<GrammarSymbol> stack = new Stack<GrammarSymbol>();
	stack.push(new Q0());

	cc = gicl.getNextToken();

	GrammarSymbol gs = null;

	do {

	    gs = stack.peek();

	    if (gs instanceof PilotState) {
		// Busca primero si existe un movimiento de desplazamiento
		PilotState nps = null;
		try {

		    nps =  pilotMap.get(gs).get(cc);
		    if (nps != null) {
			stack.push(cc);
			stack.push(nps);
		    }
		    else {
			throw new NullPointerException();
		    }

		    cc = gicl.getNextToken();

		} catch (NullPointerException npe) {

		    // Busca un movimiento de reducción
		    Production p = reductionMap.get(gs).get(cc);

		    if (p == null) {
			throw new CfglreParserException("No reduce option, no shift option");
		    }

		    NonTerminal nt = p.getLHS();
		    GrammarSymbol[] gss = p.getRHS();

		    // Analiza si los elementos esperados en la pila coinciden
		    for (int i = 0; i < gss.length; i++) {

			GrammarSymbol top = stack.pop();
			if (!(top instanceof PilotState)) {
			    throw new CfglreParserException("No reduce state " + top + "stack: " + stack);
			}
			else {
			    top = stack.pop();
			    if (!top.equals(gss[i])) {
				throw new CfglreParserException("Stack symbol " + top + " different from " + gss[i]);
			    }
			}
		    }

		    gs = stack.peek();
		    if (gs instanceof PilotState) {

			nps =  pilotMap.get(gs).get(nt);
			if (nps != null) {
			    stack.push(nt);
			    stack.push(nps);
			}
		    }
		}
	    }
	    else {

		throw new CfglreParserException("Internal Exception");
	    }
	    gs = stack.peek();
	} while (!((gs instanceof PilotState) && gs.equals(new Q0()) && cc.equals(new Eof())));

	return null;
    }
}
