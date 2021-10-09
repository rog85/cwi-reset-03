public class Diretor {
    private String nome;
    private int idade;
    private int qtdFilmesDirigidos;
    private Genero genero;

    public Diretor(String nome, int idade, int qtdFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public void Apresentacao(){
        System.out.println("-----");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Gênero: " + genero.getDescricao());
        System.out.println("-----");
    }

    public String getNome() {
        return nome;
    }
}
