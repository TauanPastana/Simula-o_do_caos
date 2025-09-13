import java.util.ArrayList;
import java.util.List;

public class Banheiro implements Observavel {

    
    
    private int id;
    private EstadoPorta ocupacao;
    
    private static int quantidade;
    private static int quantidade_abertos;
    private static int quantidade_fechados;
    private List<Probabilidades> observadores;
    
    public Banheiro(){
        this.id = quantidade+1;
        this.ocupacao = EstadoPorta.ABERTO;
        quantidade++;
        quantidade_abertos++;
        this.observadores = new ArrayList<>();
    }
    
    @Override
    public void registrarObservador(Probabilidades observador) {
        observadores.add(observador);
    }
    
    @Override
    public void notificarObservadores(String evento, Object dados) {
        for (Probabilidades observador : observadores) {
            switch (evento) {
                case "USO_BANHEIRO":
                observador.registrarUsoBemSucedido(this.id);
                break;
                case "ESTADO_PORTA":
                observador.registrarEstadoPorta((EstadoPorta) dados);
                break;
                // outros casos conforme necessário
            }   
        }
    }
    
    public void usarBanheiro(Pessoa pessoa){
        this.ocupacao = EstadoPorta.FECHADO;
        notificarObservadores("USO_BANHEIRO", null);
    }
    
    public void sairBanheiro(int chance){
        if (chance > 60){
            this.ocupacao = EstadoPorta.ABERTO;
            notificarObservadores("ESTADO_PORTA", EstadoPorta.ABERTO);
        } else{
            this.ocupacao = EstadoPorta.FECHADO;
            quantidade_abertos--;
            quantidade_fechados++;
            notificarObservadores("ESTADO_PORTA", EstadoPorta.FECHADO);
        }
    }
    
    public static int getQuantidade() {
        return quantidade;
    }

    public static void setQuantidade(int quantidade) {
        Banheiro.quantidade = quantidade;
    }

    public static int getQuantidade_abertos() {
        return quantidade_abertos;
    }

    public static void setQuantidade_abertos(int quantidade_abertos) {
        Banheiro.quantidade_abertos = quantidade_abertos;
    }

    public static int getQuantidade_fechados() {
        return quantidade_fechados;
    }

    public static void setQuantidade_fechados(int quantidade_fechados) {
        Banheiro.quantidade_fechados = quantidade_fechados;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoPorta getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(EstadoPorta ocupacao) {
        this.ocupacao = ocupacao;
    }

    public List<Probabilidades> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<Probabilidades> observadores) {
        this.observadores = observadores;
    }

    
}

        







