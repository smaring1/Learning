package co.edu.eafit.dis.st0270.s20201.smglorc.abs;

import  co.edu.eafit.dis.st0270.s20201.smglorc.visitor.Visitor;

public class CfglreAbs extends AbsTree {
   private AbsTree left = null;
   private AbsTree right = null;

   public CfglreAbs() {
      this.left = this.right = null;
   }

   public CfglreAbs(AbsTree left, AbsTree right) {
      this.left = left;
      this.right = right;
   }

   public AbsTree getLeft() {
      return this.left;
   }

   public AbsTree getRight() {
      return this.right;
   }

   public void accept(Visitor visitor) {
      visitor.visit(this);
   }
}
