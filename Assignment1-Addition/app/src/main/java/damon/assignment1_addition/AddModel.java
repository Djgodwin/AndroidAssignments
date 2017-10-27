package damon.assignment1_addition;

/**
 * Created by Damon on 1/26/2017.
 */

public class AddModel {
    private int num1;
    private int num2;
    private int sum;

    public void setNum1(String num1) {
        this.num1 = Integer.valueOf(num1);
    }

    public void setNum2(String num2) {
        this.num2 = Integer.valueOf(num2);
    }

    public void addNum() {
        this.sum = this.num1 + this.num2;
    }

    public int getSum() {
        return this.sum;
    }
}
