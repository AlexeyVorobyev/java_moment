package calc.operation;

public class RightDrifter{
    private short value;

    public RightDrifter(){
        this.value = 0;
    }

    public void drift(short d){
        this.value = (short) (d>>1);
    }

    public short getDrift(){
        return this.value;
    }
}