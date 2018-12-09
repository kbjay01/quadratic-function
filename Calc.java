import java.util.Scanner;
public class Calc {

    String aString, bString, cString, function, apex, range;
    double a, b, c, delta, x0, x1, x2, p, q;
    double roots[] = new double[3];

    void intro() {
        //Just an intro void, which kinda introduces the application

        System.out.println("Quadratic equation formula:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("If any of variables doesn't exist, set it to 0 \n");
    }

    void variableInput() {
        // Getting input from user (variables a,b,c)

        Scanner reader = new Scanner(System.in);
        System.out.print("a = ");
        aString = reader.next();

        System.out.print("b = ");
        bString = reader.next();

        System.out.print("c = ");
        cString = reader.next();
    }

    void showVariables() {
        /*
        Showing user his input and asking him: Is the input correct?
        If the input is correct, he inserts "y", if not "n".
        But if the user puts something different than "y" or "n" the app would kinda crash.So I decided to do a statement:
        If the user says something different than "y" which stands for yes the data is right. Then go back to
        inputting the correct data by VariableInput()
         */

        System.out.println("\nYour input:");
        System.out.println("a = " + aString);
        System.out.println("b = " + bString);
        System.out.println("c = " + cString + "\n");
        System.out.println("Is data correct? [Y/N]");
        Scanner reader = new Scanner(System.in);
        String check = reader.nextLine();
        check.toLowerCase();

        if (!"y".equals(check)) {
            showVariables();
        }
        if (aString == "0") {
            System.out.println(a);
            System.out.println("Graph of this function is straight");
        }
    }

    void convertVariables() {
        /*
        If the users says that the data that he inputted ic correct, then convertVariables() checks if
        those inputs are really numbers, or in other words: Can they be converted into a double variable.
        If the input cannot be converted into a double variable, it is impossible to make calculations.
        It falls back to PartOne() that just repeats the whole process.
        See PartOne() for details.
         */

        try {
            a = Double.parseDouble(aString);
            b = Double.parseDouble(bString);
            c = Double.parseDouble(cString);
        } catch (NumberFormatException e) {
            System.err.println("[!]Error. At least one of variables is not a number!\n");
            partOne();
        }
    }

    void partOne() {

        /*
        Created in order to do not let the calculations start with variables that are not numbers.
        The thing that this void does is it repeats whole start process from Intro() to ConvertVariables().
         */

        intro();
        variableInput();
        showVariables();
        convertVariables();
    }

    void counting() {
        /*
        Void that just calculate all of necessary variables. If a = 0, there is no sens to calculates apex, range etc.
        Because graph of the function is a straight
         */

        if (a == 0){
            function = bString + "x " + "+ " + cString;
            // There is no sens to calculate value of delta
            apex = "Graph is a straight - there is no apex";
            range = "Graph is a straight, y = " + cString;
            // There are no roots
            // There is no axis of symmetry because graph is a straight

        }

        else {
            delta = (Math.pow(b, 2) - 4 * a * c);
            p = -b / (2 * a);
            q = -delta / (4 * a);
            function = aString + "x^2" + " + " + bString + "x " + "+ " + cString;
            apex = "A(" + p + ", " + q + ")";
            range = "";
        }


        /*Here it just checks what "a" equals , then according to the result sets range
        variable to valid.
        */

        if (a < 0) {
            range = (Double.NEGATIVE_INFINITY + ", " + q);
        }
        else if (a > 0) {
            range = ("(" + q + ", " + Double.POSITIVE_INFINITY + ")");
        }

        /* Calculating the root/s in the way that is associated with value of Delta, and calculating the Axis of symmetry.
        But if A equals 0, then it was done previously
        */


        if (a!=0) {

            if (delta == 0) {
                x0 = -1 * (b / (2 * a));
            } else if (delta > 0) {
                x1 = ((-b - Math.sqrt(delta)) / (2 * a));
                x2 = ((-b + Math.sqrt(delta)) / (2 * a));
            }
        }

    }
    void printer(){
        // this void role is to print all of the result
        System.out.println("Your Function: " + function);
        System.out.println("Apex: " + apex);
        
        if (a!=0){
            System.out.println("Delta: " + delta);
            System.out.println("Domain of a function: R" + range);
            System.out.println("Axis of symmetry of parabola: x = " + p);

            if (delta<0){
                System.out.println("Roots: There are no roots");
            }

            else if (delta == 0){
                System.out.println("Roots: x0 = " + x0);
            }
            else if (0<delta){
                System.out.println("Roots: x1 = " + x1 + ", x2 = " + x2);
            }

            if (a < 0) {
                System.out.println("Highest magnitude: " + q + ", for x = " + p);
                System.out.println("Lowest magnitude: Does not exist");
                System.out.println("Monotonicity: ");
                System.out.println("Function increasing in range:  " + ("(" + Double.NEGATIVE_INFINITY + ", " + p  + ">"));
                System.out.println("Function decreasing in range:  " + ("<" + p + ", " + Double.POSITIVE_INFINITY + ")" ));
            }
            else if (a>0){
                System.out.println("Highest magnitude: Does not exist");
                System.out.println("Lowest magnitude: " + p + ", for x = " + q);
                System.out.println("Function increasing in range:  " + ("<" + p + ", " + Double.POSITIVE_INFINITY + ")" ));
                System.out.println("Function decreasing in range:  " + ("(" + Double.NEGATIVE_INFINITY + ", " + p  + ">"));
            }
        }
        else if (a == 0){
            System.out.println("Range: " + range);
            System.out.println("Roots: There are no roots");
            System.out.println("There is no axis of symmetry because graph is a straight");
        }
    }
}
