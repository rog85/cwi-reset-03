package br.com.cwi.reset.rogeriotrusz;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;

        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        //teste 1.1.1
        try {
            atorService.criarAtor(atorRequest);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

        //teste 1.1.2
        /*List<AtorEmAtividade> atoresEmAtividade = null;
        try {
            atoresEmAtividade = atorService.listarAtoresEmAtividade();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }*/

        //teste 1.1.3
        /*Ator ator = null;
        try {
            ator = atorService.consultarAtor(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ator.getNome());*/

        //teste 1.1.4
        /*List<Ator> todosAtores = null;
        try {
             todosAtores = atorService.consultarAtores();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/



        DiretorService diretorService = new DiretorService(fakeDatabase);
        //teste 2.1.1

        String nomeDiretor = "Rogerio Trusz";
        LocalDate dataNasciDiretor = LocalDate.of(1985, 12, 1);
        Integer anoAtividadeDiretor = 2000;

        DiretorRequest diretorRequest = new DiretorRequest(nomeDiretor, dataNasciDiretor, anoAtividadeDiretor);
        try {
            diretorService.cadastrarDiretor(diretorRequest);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //teste 2.1.2
        //List<Diretor> lista = null;
         /*try {
            lista = diretorService.listarDiretores();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        for (Diretor d : lista) {
            System.out.println(d.getNome());
        }*/

        //teste 2.1.3
        Diretor diretor = null;
        try {
            diretor = diretorService.consultarDiretor(1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(diretor.getNome());

    }
}