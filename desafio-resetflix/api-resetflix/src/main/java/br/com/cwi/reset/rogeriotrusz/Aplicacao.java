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

    }
}