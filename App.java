public class App {
    public static void main(String[] args){
        Config Calculations = new Config();
        Calculations.Intro();
        Calculations.VariableInput();
        Calculations.ShowVariables();
        Calculations.ConvertVariables();

        if(Calculations.conv_error == true){
            Calculations.PartOne();
        }
        Calculations.Counting();
    }
}
