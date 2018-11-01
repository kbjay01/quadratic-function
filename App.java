public class App {
    public static void main(String[] args){
        Config Calculations = new Config();
        Calculations.intro();
        Calculations.variableInput();
        Calculations.showVariables();
        Calculations.convertVariables();

        if(Calculations.convError == true){
            Calculations.partOne();
        }
        Calculations.counting();
    }
}
