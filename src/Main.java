import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[] programa = input.nextLine().toCharArray();

        Lexer lex = new Lexer(programa);

        String token = "";

        while (!token.equals(";")) {
            token = lex.scan();
            System.out.println(token);
        }
    }
}
