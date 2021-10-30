package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exercicios1Test {

    //***somar***
    @Test
    public void testSomaListaCincoNumerosInteirosPositivos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(1, 2, 3, 4, 5);
        Integer expected = 15;

        // Action
        Integer result = exercicios.somarLista(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaListaQuatroInteirosUmNegativo(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(1, 2, 3, 4, -5);
        Integer expected = 5;

        // Action
        Integer result = exercicios.somarLista(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaListaTresNegativos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(-5, -5, -5);
        Integer expected = -15;

        // Action
        Integer result = exercicios.somarLista(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaListaTodosElementosZero(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(0, 0, 0, 0, 0);
        Integer expected = 0;

        // Action
        Integer result = exercicios.somarLista(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSomaListaVazia(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList();
        Integer expected = 0;

        // Action
        Integer result = exercicios.somarLista(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }


    //***media***
    @Test
    public void testMediaListaCincoNumerosInteirosPositivos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(1, 2, 3, 4, 5);
        Double expected = 3.0;

        // Action
        Double result = exercicios.calcularMedia(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaListaQuatroInteirosUmNegativo(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(1, 2, 3, 4, -5);
        Double expected = 1.0;

        // Action
        Double result = exercicios.calcularMedia(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaListaTresNegativos(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(-5, -5, -5);
        Double expected = -5.0;

        // Action
        Double result = exercicios.calcularMedia(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaListaTodosElementosZero(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList(0, 0, 0, 0, 0);
        Double expected = 0.0;

        // Action
        Double result = exercicios.calcularMedia(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMediaListaVazia(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        List<Integer> inteirosPositivos = Arrays.asList();
        Double expected = 0.0;

        // Action
        Double result = exercicios.calcularMedia(inteirosPositivos);

        // Assert
        Assertions.assertEquals(expected, result);
    }


    //***Inverter***

    @Test
    public void testInventerPalavraAbacate(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        String palavra = "Abacate";
        String expected = "etacabA";

        // Action
        String result = exercicios.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInventerPalavraBanana(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        String palavra = "Banana";
        String expected = "ananaB";

        // Action
        String result = exercicios.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInventerPalavraPessego(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        String palavra = "Pessego";
        String expected = "ogesseP";

        // Action
        String result = exercicios.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testInventerPalavraMorango(){
        // Arrange
        Exercicios1 exercicios = new Exercicios1();
        String palavra = "Morango";
        String expected = "ognaroM";

        // Action
        String result = exercicios.obterPalavraInvertida(palavra);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
