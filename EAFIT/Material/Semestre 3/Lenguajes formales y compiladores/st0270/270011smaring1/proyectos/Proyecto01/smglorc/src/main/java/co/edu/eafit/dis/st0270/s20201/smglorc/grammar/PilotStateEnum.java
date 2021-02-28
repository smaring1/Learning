package co.edu.eafit.dis.st0270.s20201.smglorc.grammar;

public enum PilotStateEnum {

    Q0(true),
    Q1(),
    Q2(),
    Q3(),
    Q4(),
    Q5(true),
    Q6(),
    Q7(),
    Q8(true),
    Q9(),
    Q10(),
    Q11(),
    Q12(true),
    Q13(true),
    Q14(),
    Q15(),
    Q16();

    private boolean reduction = false;

    PilotStateEnum(boolean reduction) {
	this.reduction = reduction;
    }

    PilotStateEnum() {
    }

    public boolean isAReductionState() {
	return reduction;
    }
}