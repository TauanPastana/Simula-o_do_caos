import Enums.EstadoPorta;
import Padroes_Projetos.Observavel;

public class Banheiro implements Observavel {

    
    
    private int id;
    private EstadoPorta ocupacao;
    
    private static int quantidade;
    private static int quantidade_abertos;
    private static int quantidade_fechados;
    
    
    public Banheiro(){
        this.id = quantidade+1;
        this.ocupacao = EstadoPorta.ABERTO;
        quantidade++;
        quantidade_abertos++;
    }
    
    
    
    @Override
    public void notificarObservadores(String evento) {
        Simulador.getColetorProbabilidades().Notificar(evento);
    
}
    
    public void usarBanheiro(Pessoa pessoa){
        this.ocupacao = EstadoPorta.FECHADO;
        notificarObservadores("USO_BEM_SUCEDIDO");
    }
    
    public void sairBanheiro(int chance){
        if (chance > 60){
            this.ocupacao = EstadoPorta.ABERTO;
            notificarObservadores("PORTA_ABERTA");
        } else{
            this.ocupacao = EstadoPorta.FECHADO;
            quantidade_abertos--;
            quantidade_fechados++;
            notificarObservadores("PORTA_FECHADA");
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


    
}

        







