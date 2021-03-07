package co.edu.eafit.dis.st0270.s20201.smglorc.visitor;

import co.edu.eafit.dis.st0270.s20201.smglorc.abs.CfglreAbs;
import co.edu.eafit.dis.st0270.s20201.smglorc.abs.ProgAbs;

public class ShowVisitor implements Visitor {

   private StringBuffer sb = null;
   private char charLeft = '(';
   private char charRight = ')';

   public ShowVisitor() {
   }

   public ShowVisitor(char charLeft, char charRight) {
      this.charLeft = charLeft;
      this.charRight = charRight;
   }

   public StringBuffer getSB() {
      return sb;
   }

   public void visit(ProgAbs p) {
      p.getSub().accept(this);
   }

   public void visit(CfglreAbs da) {

      if (da == null) {
         sb = new StringBuffer();
      }
      else {
         StringBuffer sbLocal = new StringBuffer(""+charLeft);
         if (da.getLeft() != null) {
            da.getLeft().accept(this);
            sbLocal.append(getSB());

         }
         sbLocal.append(charRight);
         if (da.getRight() != null) {
            da.getRight().accept(this);
            sbLocal.append(getSB());
         }
         this.sb = sbLocal;
      }
   }
}
