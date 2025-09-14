

public class Log {


    public static void ComportamentoPessoas() {
        System.out.println(
            "\n" +
            "╔══════════════════════════════════╗\n" +
            "║      QUANTIDADE DE PESSOAS      ║\n" +
            "╠══════════════════════════════════╣\n" +
            "║ Pessoas educadas      : " + Pessoa_educada.getQuantidade_educado() + "\n" +
            "║ Pessoas não educadas  : " + Pessoa_nao_educada.getQuantidade_nao_educado() + "\n" +
            "╚══════════════════════════════════╝\n"
        );    }

        public static void estadoBanheiros() {
            System.out.println(
                "\n" +
                "╔══════════════════════════════════╗\n" +
                "║      ESTADO DOS BANHEIROS        ║\n" +
                "╠══════════════════════════════════╣\n" +
                "║ Banheiros ocupados    : " + Banheiro.getQuantidade_fechados() + "\n" +
                "║ Banheiros disponíveis : " + Banheiro.getQuantidade_abertos() + "\n" +
                "╚══════════════════════════════════╝\n"
            );
        }

        public static void Zelador(){
            System.out.println(
                "\n" +
                "╔════════════════════════════════════════════════════╗\n" +
                "║               ZELADOR EM AÇÃO                      ║\n" +
                "╠════════════════════════════════════════════════════╣\n");    
            System.out.println("Zelador em ação, todas as portas foram reabertas!!");
            }

    

    






}
