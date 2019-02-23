public class Simbolo {
    private int Id;
    private String Nome;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Simbolo() {
    }

    public Simbolo(int id, String nome) {
        Id = id;
        Nome = nome;
    }
}
