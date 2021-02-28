package co.edu.eafit.dis.st0270.s20201.smglorc;

import gnu.getopt.Getopt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import co.edu.eafit.dis.st0270.s20201.smglorc.lexer.CfglreLexer;
import co.edu.eafit.dis.st0270.s20201.smglorc.parser.CfglreParser;

public class Main {
   
   public static void usage() {
      System.err.println("Usage: java co.edu.eafit.dis.st0270.s20201.smglorc.Main [-j] [-m] [<filename>] ...");
      System.exit(1);
   }
   
   public static void main(String args[]) {
      
      Getopt getOpt = new Getopt("Main", args, "jm");
      int c;
      int mflag = 0;
      int jflag = 0;
      String str = null;

      while ((c = getOpt.getopt()) != -1) {
         switch (c) {
            case 'm':
               mflag = 1;
               break;
            case 'j':
               jflag = 1;
               break;
            default:
               usage();
               break;
         }
      }

      int startFiles = getOpt.getOptind();
      
      if (str == null && startFiles == args.length) usage();
      
      CfglreParser gp = null;
      JaccParser jp = null;
      
      for (int i = startFiles; i < args.length; ++i) {
         if ((mflag == 1 && jflag == 1) || (jflag == 1)) {
            try {
               JaccLexer jl = new JaccLexer(new FileReader(args[i]));
               jp = new JaccParser(jl);
               jl.nextToken();
               if (jp.parse()) {
                  System.err.println(args[i] + " esta bien formado JaccParser");
               }
               else {
                  System.err.println(args[i] + " esta mal formado JaccParser");
               }
            }
            catch(Exception e) {
               System.err.println(e);
            }
         }
         if ((mflag == 1 && jflag == 1) || (mflag == 1)) {
            try {
               gp = new CfglreParser(new CfglreLexer(new FileReader(args[i])));
               gp.parser();
               System.err.println(args[i] + " esta bien formado ManualParser");
            }
            catch(Exception e) {
               System.err.println(args[i] + " esta mal formado ManualParser");
            }
         }
      }
      System.exit(0);
   }
}
