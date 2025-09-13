
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Pessoa {
    private Comportamento tipo;
    private int id;
    private static int quantidade;

    public Banheiro EscolherBanheiro(ArrayList<Banheiro> lista_banheiros, Utilidades instancia){
        Random random = instancia.getRandom();
        List<Banheiro> banheirosAbertos = lista_banheiros.stream()
            .filter(b -> b.getOcupacao() == EstadoPorta.ABERTO)
            .collect(Collectors.toList());

        if (banheirosAbertos.isEmpty()) {
            return null;
        }

        return banheirosAbertos.get(random.nextInt(banheirosAbertos.size()));
        
        
    }

    public int gerarChance(Utilidades instancia) {
        int chanceBase = this.tipo.getChanceBase();
        // Adiciona uma variação de ±10% para não ser sempre o mesmo valor
        int variacao = instancia.getRandom().nextInt(21) - 10; // -10 a +10
        int chanceFinal = chanceBase + variacao;
        
        // Garante que a chance fique entre 0% e 100%
        return Math.max(0, Math.min(100, chanceFinal));
    }

    
    
    @Override
    public String toString() {
        return "\n==========================" +
            "\n   Dados da Pessoa" +
            "\n==========================" +
            "\nTipo       : " + tipo +
            "\nID         : " + id +
            "\nQuantidade : " + quantidade +
            "\n==========================\n";
    }



    public static int getQuantidade() {
        return quantidade;
    }

    public static void setQuantidade() {
        Pessoa.quantidade++;
    }
    public Comportamento getTipo() {
        return tipo;
    }

    public void setTipo(Comportamento tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = Pessoa.quantidade+1;
    }

    
}
