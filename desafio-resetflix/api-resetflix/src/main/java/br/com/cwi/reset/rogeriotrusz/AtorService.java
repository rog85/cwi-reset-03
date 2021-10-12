package br.com.cwi.reset.rogeriotrusz;

import java.time.LocalDate;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws CampoNaoInformadoException,
            NomeSobrenomeException, DataNascimentoException, InicioAtividadeException, NomeJaCadastradoException {

        Integer id = 0;
        String nome = atorRequest.getNome();
        LocalDate dataNascimento = atorRequest.getDataNascimento();
        StatusCarreira statusCarreira = atorRequest.getStatusCarreira();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();

        if(nome == null || nome.isEmpty()){
            throw new CampoNaoInformadoException("nome");
        } else if(!nome.matches("^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$")){
            throw new NomeSobrenomeException();
        } else if(nomeJaExiste(nome)){
            throw new NomeJaCadastradoException(nome);
        }

        if(dataNascimento == null){
            throw new CampoNaoInformadoException("dataNascimento");
        } else if(dataNascimento.isAfter(LocalDate.now())){
            throw new DataNascimentoException();
        }

        if(statusCarreira == null){
            throw new CampoNaoInformadoException("statusCarreira");
        }

        if(anoInicioAtividade == null){
            throw new CampoNaoInformadoException("anoInicioAtividade");
        } else if(anoInicioAtividade < dataNascimento.getYear()){
            throw new InicioAtividadeException();
        }

        id = proximoAtorId();
        Ator ator = new Ator(id, nome, dataNascimento, statusCarreira, anoInicioAtividade);
        fakeDatabase.persisteAtor(ator);
    }

    private Integer proximoAtorId(){
        return fakeDatabase.recuperaAtores().size() + 1;
    }

    private boolean nomeJaExiste(String nome){
        List<Ator> atores = fakeDatabase.recuperaAtores();
        for (Ator a : atores) {
            if(a.getNome().equals(nome))
                return true;
        }
        return false;
    }

}
