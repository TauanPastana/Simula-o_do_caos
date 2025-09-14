
import java.util.ArrayList;
public class Log {


    public static String quantidadePessoasEducadasENaoEducadas() {
        return "\n==========================" +
            "\n   Quantidade de pessoas" +
            "\n==========================" +
            "\n Pessoas educadas       : " + Pessoa_educada.getQuantidade_educado() +
            "\n Pessoas não educadas   : " + Pessoa_nao_educada.getQuantidade_nao_educado() +
            "\n==========================\n";
    }

    public static String estadoBanheiros(ArrayList<Banheiro> banheiros){
        return """
                ==========================
                   Estado dos Banheiros
                ==========================
                 Banheiros ocupados    : """ + Banheiro.getQuantidade_fechados() +
               "\n Banheiros disponíveis : " + Banheiro.getQuantidade_abertos() +
               "\n==========================\n";

    }






}
