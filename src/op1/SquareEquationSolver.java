package op1;

import java.util.ArrayList;

public class SquareEquationSolver {

    private double a, b, c;

    public SquareEquationSolver(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public ArrayList<Double> solve() throws Exception {
        if (a == 0)
            throw new Exception("Equation has no roots: a == 0");
        if (4 * a * c > b * b)
            throw new Exception("Equation has no real roots: 4 * a * c > b * b");

        ArrayList<Double> roots = new ArrayList<>();

        double discriminant = Math.sqrt(b * b - 4 * a * c);
        if (discriminant == 0) {
            roots.add(-0.5 * b / a);
        }
        else {
            roots.add(-0.5 * (b - discriminant) / a);
            roots.add(-0.5 * (b + discriminant) / a);
        }

        return roots;
    }

}
