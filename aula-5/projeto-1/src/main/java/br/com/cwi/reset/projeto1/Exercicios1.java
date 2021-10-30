package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        int soma = 0;
        for (int i : numeros) {
            soma += i;
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        if(numeros.isEmpty()){
            return 0.0;
        }
        double media = somarLista(numeros) / numeros.size();
        return media;
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        int maiorNumero = 0;
        for (int i : numeros) {
            if(i > maiorNumero)
                maiorNumero = i;
        }
        return maiorNumero;
    }

    public String obterPalavraInvertida(String palavra) {
        String palavraInvertida = "";

        for (int i = palavra.length() - 1; i >= 0; i--){
            palavraInvertida += palavra.charAt(i);
        }
        return palavraInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        List<Integer> listaOrdenada = numeros;
        int primeiroNumero = 0;
        int segundoNumero = 0;
        for(int j = 0; j < numeros.size() - 1; j++){
            for(int i = 0; i < numeros.size() - 1 - j; i++){
                primeiroNumero = numeros.get(i);
                segundoNumero = numeros.get(i + 1);
                if(primeiroNumero > segundoNumero){
                    listaOrdenada.set(i, segundoNumero);
                    listaOrdenada.set(i + 1, primeiroNumero);
                }
            }
        }
        return listaOrdenada;
    }
}

