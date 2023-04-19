import java.util.Scanner;

public class Main {

    static System_numeric system_numeric = new System_numeric();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            String line_for_pars = scan.nextLine();
            calc(line_for_pars);
        }
    }

    public static String calc(String input) {
        String result = "";

        Parser parser = new Parser( Main.system_numeric );
        String[] numbs_and_operator = parser.line_prepare( input );

        if (! numbs_and_operator[0].equals("") ) {
            Calculator calculator = new Calculator();
            String res = calculator.calc( numbs_and_operator[0], numbs_and_operator[1], Main.system_numeric );
            System.out.println( res );
            result = res;
        }

        return result;
    }
}