import java.util.Scanner;
public class Config {

    String a_string, b_string, c_string;
    boolean conv_error = false;
    double a, b, c, delta, x0, x1, x2;
    double roots[] = new double[3];

    void Intro() {
        System.out.println("Quadratic equation formula:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("If any of variables doesn't exist, set it to 0 \n");
    }

    void VariableInput() {
        Scanner reader = new Scanner(System.in);

        System.out.print("a = ");
        a_string = reader.next();

        System.out.print("b = ");
        b_string = reader.next();

        System.out.print("c = ");
        c_string = reader.next();
    }

    void ShowVariables() {
        System.out.println("\nYour input:");
        System.out.println("a = " + a_string);
        System.out.println("b = " + b_string);
        System.out.println("c = " + c_string + "\n");
        System.out.println("Is data correct? [Y/N]");
        Scanner reader = new Scanner(System.in);
        String check = reader.nextLine();
        check.toLowerCase();

        if (check.equals("y")) {
            // Wtedy nic
        } else {
            ShowVariables();
        }
        if (a_string == "0") {
            System.out.println(a);
            System.out.println("This function is linear, not quadratic");
        }
    }

    void ConvertVariables() {

        try {
            a = Double.parseDouble(a_string);
            b = Double.parseDouble(b_string);
            c = Double.parseDouble(c_string);
        } catch (NumberFormatException e) {
            System.err.println("[!]Error. At least one of variables is not a number!");
            conv_error = true;
        }
    }

    void PartOne() {
        Intro();
        VariableInput();
        ShowVariables();
        ConvertVariables();
    }

    void Counting() {
        delta = (Math.pow(b, 2) - 4 * a * c);
        double p = -b / (2 * a);
        double q = -delta / (4 * a);
        String function = a_string + "x^2" + " + " + b_string + "x " + "+ " + c_string;
        String summit = "A(" + p + ", " + q + ")";
        String range = "";

        if (a < 0) {
            range = (Double.NEGATIVE_INFINITY + ", " + q);
        } else if (a > 0) {
            range = ("(" + q + ", " + Double.POSITIVE_INFINITY + ")");
        }

        System.out.println("Your Function: " + function);
        System.out.println("Delta: " + delta);
        System.out.println("Apex: " + summit);
        System.out.println("Domain of a function: R(" + range);

        if (delta == 0) {
            x0 = -1 * (b / (2 * a));
            roots[0] = x0;
            System.out.println("Roots: " + roots[0]);
        } else if (delta > 0) {
            roots[1] = x1 = ((-b - Math.sqrt(delta)) / (2 * a));
            roots[2] = x2 = ((-b + Math.sqrt(delta)) / (2 * a));
            System.out.println("Roots: " + roots[1] + ", " + roots[2]);
        } else if (delta < 0) {
            System.out.println("Roots: NULL");
        }
        System.out.println("Axis of symmetry of parabola: x = " + p);

        if (a < 0) {
            System.out.println("Highest magnitude: " + q + " for x = " + p);
            System.out.println("Lowest magnitude: NULL");
            System.out.println("Monotonicity: ");
            System.out.println("Function increasing in range:  " + ("(" + Double.NEGATIVE_INFINITY + ", " + p  + ">"));
            System.out.println("Function decreasing in range:  " + ("<" + p + ", " + Double.POSITIVE_INFINITY + ")" ));
        }
        else if (a>0){
            System.out.println("Highest magnitude: NULL");
            System.out.println("Lowest magnitude: " + p + " for x = " + q);
            System.out.println("Function increasing in range:  " + ("<" + p + ", " + Double.POSITIVE_INFINITY + ")" ));
            System.out.println("Function decreasing in range:  " + ("(" + Double.NEGATIVE_INFINITY + ", " + p  + ">"));
        }
    }
}