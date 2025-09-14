

import Padroes_Projetos.Observador;
import Padroes_Projetos.Observavel;
import java.util.ArrayList;
import java.util.List;

public class Probabilidades implements Observador {
    // Dados de uso dos banheiros
    private float totalPessoasSimuladas;
    private float tentativasUso;
    private float usosBemSucedidos;
    private float desistencia;
    
    // Dados de estado das portas
    private float vezesPortaAberta;
    private float vezesPortaFechada;
    
  
    private float eventosTodosBanheirosOcupados;
    private float eventosPeloMenosUmAberto;
    private float eventosNenhumDisponivel;
    
    // Lista de observados
    private List<Observavel> observados;
    
    public Probabilidades() {
        this.observados = new ArrayList<>();
    }

    
    
    
    public void registrarTentativaUso() {
        tentativasUso++;
    }
    
    


    
    public void registrarEventoTodosOcupados() {
        eventosTodosBanheirosOcupados++;
    }
    
    public void registrarEventoPeloMenosUmAberto() {
        eventosPeloMenosUmAberto++;
    }
    
    public void registrarEventoNenhumDisponivel() {
        eventosNenhumDisponivel++;
    }
    
    

    public double calcularTaxaOcupacao() {
    if (tentativasUso == 0) return 0;
    return (usosBemSucedidos / tentativasUso) * 100;
}

public String avaliarCapacidadeSistema() {
    double taxaFalha = calcularTaxaFalha();
    if (taxaFalha > 30) return "Sistema SUPERLOTADO - Necessita mais banheiros";
    if (taxaFalha > 15) return "Sistema LOTADO - Considere aumentar banheiros";
    if (taxaFalha > 5) return "Sistema EQUILIBRADO";
    return "Sistema SUBUTILIZADO - Pode reduzir banheiros";
}

public String analisarComportamento() {
    double taxaAbertura = calcularProbabilidadePortaAberta();
    if (taxaAbertura > 70) return "Comportamento MAJORITARIAMENTE EDUCADO";
    if (taxaAbertura > 40) return "Comportamento MISTO";
    return "Comportamento MAJORITARIAMENTE EGOÍSTA";
}

public void analiseComparativa() {
    System.out.println("\n" +
        "╔══════════════════════════════════════════════════╗\n" +
        "║               ANÁLISE COMPARATIVA               ║\n" +
        "╚══════════════════════════════════════════════════╝");
    
    System.out.printf("Cada banheiro foi usado em média: %.1f vezes\n", 
                     usosBemSucedidos / totalPessoasSimuladas);
    
    double eficiencia = (usosBemSucedidos / tentativasUso) * 100;
    System.out.printf("Eficiência global do sistema: %.1f%%\n", eficiencia);
    
    System.out.printf("Taxa de sucesso: %.2f%%\n", calcularProbabilidadeUsoBemSucedido());
    System.out.printf("Taxa de falha: %.2f%%\n", calcularTaxaFalha());
    
    System.out.println("══════════════════════════════════════════════════\n");
}

public void exibirMetricasChave() {
    System.out.println("\n" +
        "╔══════════════════════════════════════════════════╗\n" +
        "║               MÉTRICAS-CHAVE                    ║\n" +
        "╚══════════════════════════════════════════════════╝");
    
    System.out.printf("Taxa de ocupação: %.2f%%\n", calcularTaxaOcupacao());
    System.out.printf("Taxa de falha: %.2f%%\n", calcularTaxaFalha());
    System.out.println("Avaliação de capacidade: " + avaliarCapacidadeSistema());
    System.out.println("Comportamento predominante: " + analisarComportamento());
    System.out.printf("Eficiência global: %.1f%%\n", 
                     (usosBemSucedidos / tentativasUso) * 100);
    
    System.out.println("══════════════════════════════════════════════════\n");
}

    public double calcularTaxaFalha() {
    if (tentativasUso == 0) return 0;
    return ((tentativasUso - usosBemSucedidos) / tentativasUso) * 100;
}
    public double calcularProbabilidadeUsoBemSucedido() {
        if (tentativasUso == 0) return 0;
        return (double) usosBemSucedidos / tentativasUso * 100;
    }
    
 
    
    public double calcularProbabilidadePortaAberta() {
        float totalEstados = vezesPortaAberta + vezesPortaFechada;
        if (totalEstados == 0) return 0;
        return (double) vezesPortaAberta / totalEstados * 100;
    }
    
    public double calcularProbabilidadePortaFechada() {
        float totalEstados = vezesPortaAberta + vezesPortaFechada;
        if (totalEstados == 0) return 0;
        return (double) vezesPortaFechada / totalEstados * 100;
    }
    


    

    

 

    public void exibirRelatorio() {
    System.out.println("\n" +
        "╔══════════════════════════════════════════════════╗\n" +
        "║               RELATÓRIO COMPLETO                 ║\n" +
        "╚══════════════════════════════════════════════════╝");
    
    
    System.out.println("\n DADOS GERAIS DA SIMULAÇÃO");
    System.out.println("Total de pessoas simuladas: " + totalPessoasSimuladas);
    System.out.println("Total de pessoas educadas: " + Pessoa_educada.getQuantidade_educado());
    System.out.println("Total de pessoas não educadas: " + Pessoa_nao_educada.getQuantidade_nao_educado());
    System.out.println("Total de banheios: " + Banheiro.getQuantidade());
    System.out.println("Total de tentativas de uso: " + tentativasUso);
    
   
    System.out.println("\n EFICIÊNCIA DO SISTEMA");
    System.out.printf("Taxa de ocupação: %.2f%%\n", calcularTaxaOcupacao());
    System.out.printf("Taxa de falha: %.2f%%\n", calcularTaxaFalha());
    System.out.printf("Eficiência global: %.1f%%\n", 
                     (usosBemSucedidos / tentativasUso) * 100);

    
    System.out.println("\n IMPACTO DO CAOS");
    System.out.printf("Pessoas que desistiram: %.0f (%.2f%%)\n",
                    desistencia, (desistencia / totalPessoasSimuladas) * 100);
    System.out.printf("Taxa de sucesso real: %.2f%%\n",
                    (usosBemSucedidos / totalPessoasSimuladas) * 100);

    
    
    System.out.println("\n COMPORTAMENTO DAS PORTAS");
    System.out.printf("Portas deixadas abertas: %.0f (%.2f%%)\n", 
                     vezesPortaAberta, calcularProbabilidadePortaAberta());
    System.out.printf("Portas deixadas fechadas: %.0f (%.2f%%)\n", 
                     vezesPortaFechada, calcularProbabilidadePortaFechada());
    System.out.println("Análise de comportamento: " + analisarComportamento());
    
    
    
    System.out.println("\n ANÁLISE COMPARATIVA");
    System.out.printf("Uso médio por banheiro: %.1f utilizações\n", 
                     usosBemSucedidos / totalPessoasSimuladas);
    
    
    System.out.println("\n AVALIAÇÃO DE CAPACIDADE");
    System.out.println("Status do sistema: " + avaliarCapacidadeSistema());
    
    
    System.out.println("\n══════════════════════════════════════════════════\n");
}
    
    // Getters e Setters
    public void setTotalPessoasSimuladas(float total) {
        this.totalPessoasSimuladas = total;
    }

    public float getTentativasUso() {
        return tentativasUso;
    }

    public void setTentativasUso(float tentativasUso) {
        this.tentativasUso = tentativasUso;
    }

    public float getUsosBemSucedidos() {
        return usosBemSucedidos;
    }

    public void setUsosBemSucedidos(float usosBemSucedidos) {
        this.usosBemSucedidos = usosBemSucedidos;
    }


    public float getVezesPortaAberta() {
        return vezesPortaAberta;
    }

    public void setVezesPortaAberta(float vezesPortaAberta) {
        this.vezesPortaAberta = vezesPortaAberta;
    }

    public float getVezesPortaFechada() {
        return vezesPortaFechada;
    }

    public void setVezesPortaFechada(float vezesPortaFechada) {
        this.vezesPortaFechada = vezesPortaFechada;
    }


    public float getEventosTodosBanheirosOcupados() {
        return eventosTodosBanheirosOcupados;
    }

    public void setEventosTodosBanheirosOcupados(float eventosTodosBanheirosOcupados) {
        this.eventosTodosBanheirosOcupados = eventosTodosBanheirosOcupados;
    }

    public float getEventosPeloMenosUmAberto() {
        return eventosPeloMenosUmAberto;
    }

    public void setEventosPeloMenosUmAberto(float eventosPeloMenosUmAberto) {
        this.eventosPeloMenosUmAberto = eventosPeloMenosUmAberto;
    }

    public float getEventosNenhumDisponivel() {
        return eventosNenhumDisponivel;
    }

    public void setEventosNenhumDisponivel(float eventosNenhumDisponivel) {
        this.eventosNenhumDisponivel = eventosNenhumDisponivel;
    }

    public List<Observavel> getObservados() {
        return observados;
    }

    public void setObservados(List<Observavel> observados) {
        this.observados = observados;
    }
    

    @Override
    public void Notificar(String evento) {
    switch (evento) {
        case "USO" -> usosBemSucedidos++;
        case "PORTA_ABERTA" -> vezesPortaAberta++;
        case "PORTA_FECHADA" -> vezesPortaFechada++;
        case "USO_BEM_SUCEDIDO" -> usosBemSucedidos++;
        case "DESISTENCIA" -> registrarDesistencia();
        case "TENTATIVA_USO" -> registrarTentativaUso();
        case "EVENTO_TODOS_OCUPADOS" -> eventosTodosBanheirosOcupados++;
        case "EVENTO_PELO_MENOS_UM_ABERTO" -> eventosPeloMenosUmAberto++;
        case "EVENTO_NENHUM_DISPONIVEL" -> eventosNenhumDisponivel++;
    }
}

    public float getDesistencia() {
        return desistencia;
    }

    public void registrarDesistencia(){
        this.desistencia++;
    }



}


