
import Enums.Comportamento;

public class Pessoa_nao_educada extends Pessoa {
    private static int quantidade_nao_educado;

    public Pessoa_nao_educada(){
        this.setId();
        this.setTipo(Comportamento.MAL_EDUCADO);
        Pessoa.setQuantidade();
        quantidade_nao_educado++;
    }
    public static int getQuantidade_nao_educado() {
        return quantidade_nao_educado;
    }
    

    

    



}
