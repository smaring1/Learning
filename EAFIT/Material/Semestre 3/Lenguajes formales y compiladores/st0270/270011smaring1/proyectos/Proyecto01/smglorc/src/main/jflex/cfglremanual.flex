package co.edu.eafit.dis.st0270.s20201.smglorc.lexer;
import co.edu.eafit.dis.st0270.s20201.smglorc.grammar.*;

%%
%class CfglreLexer
%unicode
%public
%line
%column
%function getNextToken
%type Terminal

LineTerminator = \n|\r|\r\n
whiteSpace = {LineTerminator}|[ \t]+
Flecha = (::=)
Mi = [a-z]
Ma = [A-Z]
%%

{Flecha}            { return new Flecha(yycolumn + 1, yyline + 1); }
{Mi}                { return new Mi(yycolumn + 1, yyline + 1); }
{Ma}                { return new Ma(yycolumn + 1, yyline + 1); }
"|"                 { return new Palo(yycolumn + 1, yyline + 1); }
","                 { return new Coma(yycolumn + 1, yyline + 1); }
{whiteSpace}        {  }
<<EOF>>             { return new Eof(); }
.                   { throw new Error("Illegal character <" +
                                       yytext() + "> at line: " +
                                       (yyline + 1) + " column: " +
                                       yycolumn);
                    }
