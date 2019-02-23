public class Lexer {

    private char peek;
    private char[] programafonte;
    private int i;

    private TabelaSimbolos tabelaSimbolos;

    public int getI() {
        return i;
    }

    public Lexer(char[] programa) {
        tabelaSimbolos = new TabelaSimbolos();

        programafonte = programa;
        init();
    }

    private void init() {
        i = 0;
        nextChar();
    }

    private void nextChar() {
        if (i < programafonte.length) {
            peek = programafonte[i];
            i++;
        } else {
            peek = programafonte[programafonte.length - 1];
        }
    }

    public String scan() {
        String token = "";
        while (peek == ' ' || peek == '\t') {//ignora espaço
            nextChar();
        }

        //Numero
        if (Character.isDigit(peek)) {
            int v = 0;//vai armezenar o valor do numero
            do {
                v = 10 * v + Character.digit(peek, 10);
                nextChar();
            } while (Character.isDigit(peek));
            token = "<NUM, " + String.valueOf(v) + ">";
            return token;
        }

        //Identificador
        if (Character.isLetter(peek)) {
            PalavraReservada palavraReservada = new PalavraReservada();

            StringBuilder lexema = new StringBuilder();
            do {
                lexema.append(peek);
                nextChar();
            } while (Character.isLetterOrDigit(peek));

            if(palavraReservada.isPalavraReservada(lexema.toString())){
                token = "<"+lexema.toString()+", " + lexema.toString() + ">";
            }else {
                token = "<ID, " + tabelaSimbolos.getIdSimbolo(lexema.toString()) + ">";
            }

            return token;
        }
        token = String.valueOf(peek);
        return token;
    }
}