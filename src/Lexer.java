public class Lexer {

    private char peek;
    private char[] programafonte;
    private int i;

    public int getI() {
        return i;
    }

    public Lexer(char[] programa) {
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
                token = "<ID, " + lexema.toString() + ">";
            }

            return token;
        }
        token = String.valueOf(peek);
        return token;
    }
}
//como resolver palavra reservada?
    //poderia ter uma lista com palavras reservadas
    //switch
    //dentro do identificador apos while por meio de função
    //<INT>

//tabela de simbolos
    //inserir o identificador(ID) na tabela<ID,1>
    //consulta se ja existe

//operadores