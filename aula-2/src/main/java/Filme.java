public class Filme {

    private String nome;
    private String descricao;
    private int duracao;
    private int anoLancamento;
    private int avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int anoLancamento, int avaliacao, Diretor diretor) throws AvaliacaoForaDoPadraoException {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        if(avaliacao < 1 || avaliacao > 5){
            throw new AvaliacaoForaDoPadraoException();
        } else{
            this.avaliacao = avaliacao;
        }
        this.diretor = diretor;
    }

    public void reproduzirFilme(){
        System.out.println("-----");
        System.out.println("Reproduzindo filme: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracao + " minutos");
        System.out.println("Diretor: " + diretor.getNome());
        System.out.println("-----");
    }
}
