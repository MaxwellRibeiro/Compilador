import java.util.Arrays;

public class PalavraReservada {

    public String[] PalavrasReservadas = {
            "INT",
            "STRING",
            "LONG"
    };

    public PalavraReservada(){}

    public PalavraReservada(String[] palavrasReservadas){
       this. PalavrasReservadas = palavrasReservadas;
    }

    public boolean isPalavraReservada(String palavra){
        return Arrays.stream(PalavrasReservadas).anyMatch(palavra::equals);
    }

}
