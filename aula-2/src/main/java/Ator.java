public class Ator {
    private String nome;
    private int idade;
    private int nroOscarsGanhos;
    private Genero genero;

    public Ator(String nome, int idade, int nroOscarsGanhos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.nroOscarsGanhos = nroOscarsGanhos;
        this.genero = genero;
    }

    public void Apresentacao(){
        System.out.println("-----");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Gênero: " + genero.getDescricao());
        System.out.println("-----");
    }
}
