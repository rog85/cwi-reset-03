public class Diretor extends Pessoa{

    private int qtdFilmesDirigidos;

    public Diretor(String nome, int idade, int qtdFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

}
