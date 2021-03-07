// Output created by jacc on Thu Jun 04 10:45:51 COT 2020

package co.edu.eafit.dis.st0270.s20201.smglorc;



class JaccParser implements JaccTookens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private Object[] yysv;
    private Object yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new Object[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 16:
                    switch (yytok) {
                        case MA:
                            yyn = 4;
                            continue;
                        case ENDINPUT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 17:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 32;
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 18:
                    switch (yytok) {
                        case FLECHA:
                            yyn = 5;
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 19:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 20:
                    switch (yytok) {
                        case error:
                        case MA:
                        case MI:
                            yyn = 35;
                            continue;
                    }
                    yyn = yyr11();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 21:
                    switch (yytok) {
                        case MA:
                            yyn = 4;
                            continue;
                        case MI:
                            yyn = 10;
                            continue;
                        case ENDINPUT:
                        case COMA:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 22:
                    switch (yytok) {
                        case ENDINPUT:
                        case PALO:
                        case COMA:
                            yyn = yyr9();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 23:
                    switch (yytok) {
                        case COMA:
                            yyn = 11;
                            continue;
                        case ENDINPUT:
                            yyn = yyr3();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 24:
                    switch (yytok) {
                        case PALO:
                            yyn = 12;
                            continue;
                        case ENDINPUT:
                        case COMA:
                            yyn = yyr6();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 25:
                    switch (yytok) {
                        case MA:
                            yyn = 4;
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 26:
                    switch (yytok) {
                        case MA:
                            yyn = yyr10();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 27:
                    switch (yytok) {
                        case MA:
                            yyn = 4;
                            continue;
                        case ENDINPUT:
                            yyn = yyr4();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getSemantic()
                                 );
                    yytok = (lexer.nextToken()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 28:
                    switch (yytok) {
                        case MA:
                            yyn = 4;
                            continue;
                        case MI:
                            yyn = 10;
                            continue;
                        case ENDINPUT:
                        case COMA:
                            yyn = yyr7();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 29:
                    switch (yytok) {
                        case ENDINPUT:
                        case PALO:
                        case COMA:
                            yyn = yyr8();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 30:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr2();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 31:
                    switch (yytok) {
                        case ENDINPUT:
                        case COMA:
                            yyn = yyr5();
                            continue;
                    }
                    yyn = 35;
                    continue;

                case 32:
                    return true;
                case 33:
                    yyerror("stack overflow");
                case 34:
                    return false;
                case 35:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        Object[] newyysv = new Object[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yyr1() { // G : Ru
        yysp -= 1;
        return 1;
    }

    private int yyr11() { // NT : MA
        yysp -= 1;
        switch (yyst[yysp-1]) {
            case 11: return 2;
            case 9: return 13;
            case 0: return 2;
            default: return 6;
        }
    }

    private int yyr5() { // P : RH PALO P
        yysp -= 3;
        return yypP();
    }

    private int yyr6() { // P : RH
        yysp -= 1;
        return yypP();
    }

    private int yyr7() { // P : /* empty */
        return yypP();
    }

    private int yypP() {
        switch (yyst[yysp-1]) {
            case 5: return 7;
            default: return 15;
        }
    }

    private int yyr8() { // RH : T NT
        yysp -= 2;
        return 8;
    }

    private int yyr9() { // RH : NT
        yysp -= 1;
        return 8;
    }

    private int yyr2() { // Ru : NT FLECHA P COMA Ru
        yysp -= 5;
        return yypRu();
    }

    private int yyr3() { // Ru : NT FLECHA P
        yysp -= 3;
        return yypRu();
    }

    private int yyr4() { // Ru : /* empty */
        return yypRu();
    }

    private int yypRu() {
        switch (yyst[yysp-1]) {
            case 0: return 3;
            default: return 14;
        }
    }

    private int yyr10() { // T : MI
        yysp -= 1;
        return 9;
    }

    protected String[] yyerrmsgs = {
    };

private JaccLexer lexer;
public JaccParser(JaccLexer lexer) {
  this.lexer = lexer;
}

private void yyerror(String msg) {
}

}
