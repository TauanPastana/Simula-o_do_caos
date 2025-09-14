

import Padroes_Projetos.Observador;
import Padroes_Projetos.Observavel;
import java.util.ArrayList;
import java.util.List;

public class Probabilidades implements Observador {
    // Dados de uso dos banheiros
    private int totalPessoasSimuladas;
    private int tentativasUso;
    private int usosBemSucedidos;
    
    // Dados de estado das portas
    private int vezesPortaAberta;
    private int vezesPortaFechada;
    
    // Distribuição por banheiro
   
    
    // Eventos caóticos
    private int eventosTodosBanheirosOcupados;
    private int eventosPeloMenosUmAberto;
    private int eventosNenhumDisponivel;
    
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
    
    // Métodos para calcular probabilidades
    public double calcularProbabilidadeUsoBemSucedido() {
        if (tentativasUso == 0) return 0;
        return (double) usosBemSucedidos / tentativasUso * 100;
    }
    
 
    
    public double calcularProbabilidadePortaAberta() {
        int totalEstados = vezesPortaAberta + vezesPortaFechada;
        if (totalEstados == 0) return 0;
        return (double) vezesPortaAberta / totalEstados * 100;
    }
    
    public double calcularProbabilidadePortaFechada() {
        int totalEstados = vezesPortaAberta + vezesPortaFechada;
        if (totalEstados == 0) return 0;
        return (double) vezesPortaFechada / totalEstados * 100;
    }
    


    
    public double calcularProbabilidadeTodosOcupados() {
        if (tentativasUso == 0) return 0;
        return (double) eventosTodosBanheirosOcupados / tentativasUso * 100;
    }
    
    public double calcularProbabilidadePeloMenosUmAberto() {
        if (tentativasUso == 0) return 0;
        return (double) eventosPeloMenosUmAberto / tentativasUso * 100;
    }
    
    public double calcularProbabilidadeNenhumDisponivel() {
        if (tentativasUso == 0) return 0;
        return (double) eventosNenhumDisponivel / tentativasUso * 100;
    }
    
    // Método para exibir relatório completo
    public void exibirRelatorio() {
        System.out.println("\n========== RELATÓRIO DE PROBABILIDADES ==========");
        System.out.println("Total de pessoas simuladas: " + totalPessoasSimuladas);
        System.out.println("Total de tentativas de uso: " + tentativasUso);
        System.out.println("Usos bem-sucedidos: " + getUsosBemSucedidos() + " (" + 
                          String.format("%.2f", calcularProbabilidadeUsoBemSucedido()) + "%)");
 
        System.out.println("Portas deixadas abertas: " + vezesPortaAberta + " (" + 
                          String.format("%.2f", calcularProbabilidadePortaAberta()) + "%)");
        System.out.println("Portas deixadas fechadas: " + vezesPortaFechada + " (" + 
                          String.format("%.2f", calcularProbabilidadePortaFechada()) + "%)");
        
        System.out.println("\nEventos caóticos:");
        System.out.println("Todos os banheiros ocupados: " + eventosTodosBanheirosOcupados + " (" + 
                          String.format("%.2f", calcularProbabilidadeTodosOcupados()) + "%)");
        System.out.println("Pelo menos um banheiro aberto: " + eventosPeloMenosUmAberto + " (" + 
                          String.format("%.2f", calcularProbabilidadePeloMenosUmAberto()) + "%)");
        System.out.println("Nenhum banheiro disponível: " + eventosNenhumDisponivel + " (" + 
                          String.format("%.2f", calcularProbabilidadeNenhumDisponivel()) + "%)");
        System.out.println("================================================\n");
    }
    
    // Getters e Setters
    public void setTotalPessoasSimuladas(int total) {
        this.totalPessoasSimuladas = total;
    }

    public int getTentativasUso() {
        return tentativasUso;
    }

    public void setTentativasUso(int tentativasUso) {
        this.tentativasUso = tentativasUso;
    }

    public int getUsosBemSucedidos() {
        return usosBemSucedidos;
    }

    public void setUsosBemSucedidos(int usosBemSucedidos) {
        this.usosBemSucedidos = usosBemSucedidos;
    }


    public int getVezesPortaAberta() {
        return vezesPortaAberta;
    }

    public void setVezesPortaAberta(int vezesPortaAberta) {
        this.vezesPortaAberta = vezesPortaAberta;
    }

    public int getVezesPortaFechada() {
        return vezesPortaFechada;
    }

    public void setVezesPortaFechada(int vezesPortaFechada) {
        this.vezesPortaFechada = vezesPortaFechada;
    }


    public int getEventosTodosBanheirosOcupados() {
        return eventosTodosBanheirosOcupados;
    }

    public void setEventosTodosBanheirosOcupados(int eventosTodosBanheirosOcupados) {
        this.eventosTodosBanheirosOcupados = eventosTodosBanheirosOcupados;
    }

    public int getEventosPeloMenosUmAberto() {
        return eventosPeloMenosUmAberto;
    }

    public void setEventosPeloMenosUmAberto(int eventosPeloMenosUmAberto) {
        this.eventosPeloMenosUmAberto = eventosPeloMenosUmAberto;
    }

    public int getEventosNenhumDisponivel() {
        return eventosNenhumDisponivel;
    }

    public void setEventosNenhumDisponivel(int eventosNenhumDisponivel) {
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
        tentativasUso++;
        switch (evento) {
            case "USO" -> usosBemSucedidos++;
            case "PORTA_ABERTA" -> vezesPortaAberta++;
            case "PORTA_FECHADA" -> vezesPortaFechada++;
            case "USO_BEM_SUCEDIDO" -> this.usosBemSucedidos++;
        }
    }

}


