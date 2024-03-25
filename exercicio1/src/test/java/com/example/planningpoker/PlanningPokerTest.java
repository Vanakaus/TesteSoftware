package com.example.planningpoker;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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
    public void testeNormal() {        
        List<String> devs = planningPoker.identifyExtremes(listaPadrao);

        assertThat(devs).isEqualTo(Arrays.asList("estima1", "estima9"));
    }



    @Test
    public void testeListaOrdenada() {

        List<Estimate> listaOrdenada = listaPadrao.stream()
            .sorted((e1, e2) -> e1.getEstimate().compareTo(e2.getEstimate()))
            .toList();

        List<String> devs = planningPoker.identifyExtremes(listaOrdenada);

        assertThat(devs).isEqualTo(Arrays.asList("estima1", "estima9"));
    }



    @Test
    public void testeListaOrdenadaDesc() {
        List<Estimate> listaOrdenadaDesc = listaPadrao.stream()
            .sorted((e1, e2) -> e2.getEstimate().compareTo(e1.getEstimate()))
            .toList();

        List<String> devs = planningPoker.identifyExtremes(listaOrdenadaDesc);

        assertThat(devs).isEqualTo(Arrays.asList("estima1", "estima9"));
    }


    
    @Test
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
    public void testeValorUnico() {
        List<Estimate> listaRepete = Arrays.asList(
            new Estimate("estima5", 5)
        );

        List<String> devs = planningPoker.identifyExtremes(listaRepete);

        assertThat(devs).isEqualTo(Arrays.asList("estima5", "estima5"));
    }


    
    @Test
    public void testeValorUnicoRepetido() {
        List<Estimate> listaRepete = Arrays.asList(
            new Estimate("estima5", 5),
            new Estimate("estima5", 5)
        );

        List<String> devs = planningPoker.identifyExtremes(listaRepete);

        assertThat(devs).isEqualTo(Arrays.asList("estima5", "estima5"));
    }


    
    @Test
    public void testeListaVazia() {
        List<Estimate> listaVazia = Arrays.asList();

        List<String> devs = planningPoker.identifyExtremes(listaVazia);

        assertThat(devs).isEqualTo(null);
    }


    
    @Test
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
