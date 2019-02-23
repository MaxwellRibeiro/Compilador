import java.util.ArrayList;
import java.util.List;

public class TabelaSimbolos {

    private List<Simbolo> simbolos;

    public TabelaSimbolos() {
        simbolos = new ArrayList<>();
    }

    public int getIdSimbolo(String token){

        Simbolo simbolo = simbolos.stream()
                .filter((s) -> s.getNome().equals(token))
                .findFirst()
                .orElse(novoSimbolo(token));

        return simbolo.getId();
    }

    private int getNovoIdSimbolo(){
        return simbolos.size() + 1;
    }

    private Simbolo novoSimbolo(String token){
        Simbolo simbolo = new Simbolo(getNovoIdSimbolo(), token);
        simbolos.add(simbolo);
        return simbolo;
    }
}

