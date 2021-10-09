public class Pessoa {
    private String nome;
    private int idade;
    private Genero genero;

    public Pessoa(String nome, int idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public void Apresentacao(){
        System.out.println("--PESSOA--");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Gênero: " + genero.getDescricao());
        System.out.println("-----");
    }

    public String getNome() {
        return nome;
    }
}
