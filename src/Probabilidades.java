
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Probabilidades {
    // Dados de uso dos banheiros
    private int totalPessoasSimuladas;
    private int tentativasUso;
    private int usosBemSucedidos;
    private int desistencias;
    
    // Dados de estado das portas
    private int vezesPortaAberta;
    private int vezesPortaFechada;
    
    // Distribuição por banheiro
    private Map<Integer, Integer> usosPorBanheiro;
    
    // Eventos caóticos
    private int eventosTodosBanheirosOcupados;
    private int eventosPeloMenosUmAberto;
    private int eventosNenhumDisponivel;
    
    // Lista de observados
    private List<Observavel> observados;
    
    public Probabilidades() {
        this.usosPorBanheiro = new HashMap<>();
        this.observados = new ArrayList<>();
    }
    
    // Métodos para registrar eventos
    public void registrarTentativaUso() {
        tentativasUso++;
    }
    
    public void registrarUsoBemSucedido(int idBanheiro) {
        usosBemSucedidos++;
        usosPorBanheiro.put(idBanheiro, usosPorBanheiro.getOrDefault(idBanheiro, 0) + 1);
    }
    
    public void registrarDesistencia() {
        desistencias++;
    }
    
    public void registrarEstadoPorta(EstadoPorta estado) {
        if (estado == EstadoPorta.ABERTO) {
            vezesPortaAberta++;
        } else {
            vezesPortaFechada++;
        }
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
    
    public double calcularProbabilidadeDesistencia() {
        if (tentativasUso == 0) return 0;
        return (double) desistencias / tentativasUso * 100;
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
    
    public int getBanheiroMaisUsado() {
        return usosPorBanheiro.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
    
    public Map<Integer, Double> calcularProbabilidadePorBanheiro() {
        Map<Integer, Double> probabilidades = new HashMap<>();
        int totalUsos = usosPorBanheiro.values().stream().mapToInt(Integer::intValue).sum();
        
        if (totalUsos > 0) {
            for (Map.Entry<Integer, Integer> entry : usosPorBanheiro.entrySet()) {
                double probabilidade = (double) entry.getValue() / totalUsos * 100;
                probabilidades.put(entry.getKey(), probabilidade);
            }
        }
        
        return probabilidades;
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
        System.out.println("Usos bem-sucedidos: " + usosBemSucedidos + " (" + 
                          String.format("%.2f", calcularProbabilidadeUsoBemSucedido()) + "%)");
        System.out.println("Desistências: " + desistencias + " (" + 
                          String.format("%.2f", calcularProbabilidadeDesistencia()) + "%)");
        System.out.println("Portas deixadas abertas: " + vezesPortaAberta + " (" + 
                          String.format("%.2f", calcularProbabilidadePortaAberta()) + "%)");
        System.out.println("Portas deixadas fechadas: " + vezesPortaFechada + " (" + 
                          String.format("%.2f", calcularProbabilidadePortaFechada()) + "%)");
        
        System.out.println("\nDistribuição por banheiro:");
        Map<Integer, Double> probPorBanheiro = calcularProbabilidadePorBanheiro();
        for (Map.Entry<Integer, Double> entry : probPorBanheiro.entrySet()) {
            System.out.println("Banheiro " + entry.getKey() + ": " + 
                              String.format("%.2f", entry.getValue()) + "%");
        }
        
        System.out.println("\nBanheiro mais usado: " + getBanheiroMaisUsado());
        
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

    public int getDesistencias() {
        return desistencias;
    }

    public void setDesistencias(int desistencias) {
        this.desistencias = desistencias;
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

    public Map<Integer, Integer> getUsosPorBanheiro() {
        return usosPorBanheiro;
    }

    public void setUsosPorBanheiro(Map<Integer, Integer> usosPorBanheiro) {
        this.usosPorBanheiro = usosPorBanheiro;
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

}


