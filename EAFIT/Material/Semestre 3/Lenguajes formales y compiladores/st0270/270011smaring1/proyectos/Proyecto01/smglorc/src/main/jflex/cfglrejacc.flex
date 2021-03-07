package co.edu.eafit.dis.st0270.s20201.smglorc;
import co.edu.eafit.dis.st0270.s20201.smglorc.JaccTookens;
import java.io.IOException;
%%
%class JaccLexer
%standalone
%unicode
%public
%line
%column
%implements JaccTookens
%{
    private int token;

    public int getToken() {
        return token;
    }

    public int getSemantic() {
        return token;
    }

    public int nextToken() {
        try {
            token = yylex();
        }
        catch(IOException ioe) {
            System.err.println("Error en análisis léxico" + ioe);
            System.exit(1);
        }
        return token;
    }
%}

FLECHA = (::=)
MI = [a-z]
MA = [A-Z]
LineTerminator = \n|\r|\r\n
whiteSpace = {LineTerminator}|[ \t]+

%%

{FLECHA}            { return (token = FLECHA); }
{MI}                { return (token = MI); }
{MA}                { return (token = MA); }
"|"                 { return (token = PALO); }
","                 { return (token = COMA); }
{whiteSpace}        {  }
<<EOF>>             { return (token = ENDINPUT); }
.                   { return (token = error); }