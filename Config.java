import java.util.Scanner;
public class Config {

    String a_string, b_string, c_string;
    boolean conv_error = false;
    double a, b, c, delta, x0, x1, x2;
    double roots[] = new double[3];

    void Intro() {
        //Just an intro void, which introduces the application

        System.out.println("Quadratic equation formula:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("If any of variables doesn't exist, set it to 0 \n");
    }

    void VariableInput() {
        // Getting input from user vars(a,b,c)

        Scanner reader = new Scanner(System.in);
        System.out.print("a = ");
        a_string = reader.next();

        System.out.print("b = ");
        b_string = reader.next();

        System.out.print("c = ");
        c_string = reader.next();
    }

    void ShowVariables() {
        /*
        Showing user his input and asking him: Is the input correct?
        If the input is correct, he inserts "y", if not "n".
        But if the user puts something different than "y" or "n" the app would kinda crash.So I decided to do a statement:
        If the user says something different than "y" which stands for yes the data is right. Then go back to
        inputting the correct data by VariableInput()
         */

        System.out.println("\nYour input:");
        System.out.println("a = " + a_string);
        System.out.println("b = " + b_string);
        System.out.println("c = " + c_string + "\n");
        System.out.println("Is data correct? [Y/N]");
        Scanner reader = new Scanner(System.in);
        String check = reader.nextLine();
        check.toLowerCase();

        if (!"y".equals(check)) {
            ShowVariables();
        }
        if (a_string == "0") {
            System.out.println(a);
            System.out.println("This function is linear, not quadratic");
        }
    }

    void ConvertVariables() {
        /*
        If the users says that the data that he inputted ic correct, then ConvertVariables() checks if
        those inputs are really numbers, or in other words: Can they be converted into a double variable/
        If the input cannot be converted into a double variable, then void sets conv_error as a true, what makes
        impossible to make calculations and falls back to PartOne() that just repeats the whole process.
        See PartOne() for details.
         */

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
        /*
        Created in order to do not let the calculations start with variables that are not numbers.
        The thing that this void does is it repeats whole start process from Intro() to ConvertVariables().
         */

        Intro();
        VariableInput();
        ShowVariables();
        ConvertVariables();
    }

    void Counting() {
        /*
        Firstly it calculates the Delta variable, P and Q variables that are standing for coordinates of a summit.
        Secondly it creates variable named Function that just stores the way how does the function looks like.
        At the end it sets range value as "" (nothing), it's kinda default value.
         */

        delta = (Math.pow(b, 2) - 4 * a * c);
        double p = -b / (2 * a);
        double q = -delta / (4 * a);
        String function = a_string + "x^2" + " + " + b_string + "x " + "+ " + c_string;
        String apex = "A(" + p + ", " + q + ")";
        String range = "";

        /*
        Here it just checks is "a" greater than 0 or is it not, then according to the result, sets range variable to valid.
        */

        if (a < 0) {
            range = (Double.NEGATIVE_INFINITY + ", " + q);
        } else if (a > 0) {
            range = ("(" + q + ", " + Double.POSITIVE_INFINITY + ")");
        }
        /*
        Printing out how does the function looks like, its Delta, Apex, and Domain of a function
         */

        System.out.println("Your Function: " + function);
        System.out.println("Delta: " + delta);
        System.out.println("Apex: " + apex);
        System.out.println("Domain of a function: R(" + range);

        /* Calculating the root/s in the way that is associated with value of Delta, and calculating the Axis of symmetry
        and printing it
        */

        if (delta == 0) {
            x0 = -1 * (b / (2 * a));
            System.out.println("Roots: " + x0);
        } else if (delta > 0) {
            x1 = ((-b - Math.sqrt(delta)) / (2 * a));
            x2 = ((-b + Math.sqrt(delta)) / (2 * a));
            System.out.println("Roots: " + x1 + ", " + x2);
        } else if (delta < 0) {
            System.out.println("Roots: NULL");
        }
        System.out.println("Axis of symmetry of parabola: x = " + p);

        /*
        Lastly calculating other things that are bellow, and printing them
         */
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
