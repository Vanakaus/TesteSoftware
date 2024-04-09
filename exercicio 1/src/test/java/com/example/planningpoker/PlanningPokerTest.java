package com.example.planningpoker;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;




@DisplayName("Testes para o PlanningPoker")
public class PlanningPokerTest {
    /**
     * 
     */

    PlanningPoker planningPoker = new PlanningPoker();

    List<Estimate> listaPadrao = Arrays.asList(
            new Estimate("estima8", 8),
            new Estimate("estima5", 5),
            new Estimate("estima4", 4),
            new Estimate("estima1", 1),
            new Estimate("estima9", 9),
            new Estimate("estima2", 2)
        );





    @Test
    @DisplayName("Teste com entrada NULL")
    public void testeNull() {        
        List<String> devs = planningPoker.identifyExtremes(null);
    
        assertThat(devs).isEqualTo(null);
    }
    
    

    @Test
    @DisplayName("Teste com lista vazia")
    public void testeListaVazia() {
        List<Estimate> listaVazia = Arrays.asList();
        List<String> devs = planningPoker.identifyExtremes(listaVazia);

        assertThat(devs).isEqualTo(null);
    }



    @Test
    @DisplayName("Teste com lista de um elemento")
    public void testeValorUnico() {
        List<Estimate> listaRepete = Arrays.asList(
            new Estimate("estima5", 5)
        );
        List<String> devs = planningPoker.identifyExtremes(listaRepete);

        assertThat(devs).isEqualTo(Arrays.asList("estima5", "estima5"));
    }


    
    @Test
    @DisplayName("Teste com lista de um elemento repetido")
    public void testeValorUnicoRepetido() {
        List<Estimate> listaRepete = Arrays.asList(
            new Estimate("estima5", 5),
            new Estimate("estima5", 5)
        );
        List<String> devs = planningPoker.identifyExtremes(listaRepete);

        assertThat(devs).isEqualTo(Arrays.asList("estima5", "estima5"));
    }



    @Test
    @DisplayName("Teste com lista sem caracteristicas diferentes")
    public void testeNormal() {        
        List<String> devs = planningPoker.identifyExtremes(listaPadrao);

        assertThat(devs).isEqualTo(Arrays.asList("estima1", "estima9"));
    }



    @Test
    @DisplayName("Teste com lista ordenada")
    public void testeListaOrdenada() {
        List<Estimate> listaOrdenada = listaPadrao.stream()
            .sorted((e1, e2) -> e1.getEstimate().compareTo(e2.getEstimate()))
            .toList();
        List<String> devs = planningPoker.identifyExtremes(listaOrdenada);

        assertThat(devs).isEqualTo(Arrays.asList("estima1", "estima9"));
    }



    @Test
    @DisplayName("Teste com lista ordenada decrescente")
    public void testeListaOrdenadaDesc() {
        List<Estimate> listaOrdenadaDesc = listaPadrao.stream()
            .sorted((e1, e2) -> e2.getEstimate().compareTo(e1.getEstimate()))
            .toList();
        List<String> devs = planningPoker.identifyExtremes(listaOrdenadaDesc);

        assertThat(devs).isEqualTo(Arrays.asList("estima1", "estima9"));
    }



    @Test
    @DisplayName("Teste com lista com valores extremos repetidos")
    public void testeValorRepetido() {
        List<Estimate> listaRepete = Arrays.asList(
            new Estimate("estima9.1", 9),
            new Estimate("estima5", 5),
            new Estimate("estima1.1", 1),
            new Estimate("estima1.2", 1),
            new Estimate("estima9.2", 9),
            new Estimate("estima2", 2)
        );
        List<String> devs = planningPoker.identifyExtremes(listaRepete);

        assertThat(devs).isEqualTo(Arrays.asList("estima1.1", "estima1.2", "estima9.1", "estima9.2"));
    }



    @Test
    @DisplayName("Teste com lista com valores negativos")
    public void testeListaValorNegativo() {
        List<Estimate> listaNegativa = Arrays.asList(
            new Estimate("estima5", 5),
            new Estimate("estima1", -1),
            new Estimate("estima9", -9),
            new Estimate("estima2", -2)
        );
        List<String> devs = planningPoker.identifyExtremes(listaNegativa);

        assertThat(devs).isEqualTo(Arrays.asList("estima9", "estima5"));
    }
}
