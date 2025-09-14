

import Padroes_Projetos.Utilidades;
import java.util.ArrayList;
import java.util.Collections;

public class Simulador {

    
    private final ArrayList<Banheiro> banheiros;
    private final ArrayList<Pessoa> pessoas;
    private static Utilidades instancia;
    private static int rodadas;
    private static Probabilidades coletorProbabilidades;
    
    public Simulador(){
        this.banheiros = new ArrayList<>();
        this.pessoas = new ArrayList<>();
        instancia = Utilidades.getInstance();
        coletorProbabilidades = new Probabilidades();
    }
    
    public void Inicar(){
        CriarPessoas();
        CriarBanheiros();
        Collections.shuffle(pessoas);
        Collections.shuffle(banheiros);
        coletorProbabilidades.setTotalPessoasSimuladas(pessoas.size());
        
        
        System.out.println(Log.quantidadePessoasEducadasENaoEducadas());
        System.out.println(Log.estadoBanheiros(banheiros));
        
        for (Pessoa pessoa : pessoas) {
            coletorProbabilidades.registrarTentativaUso();
            
            Banheiro banheiro = pessoa.EscolherBanheiro(banheiros, instancia);
            if(banheiro == null) {

                coletorProbabilidades.registrarEventoTodosOcupados();
                coletorProbabilidades.registrarEventoNenhumDisponivel();
                System.out.println("\nTodos os banheiros ficaram ocupados, simulação encerrada\n");
                break;
            }

            if (coletorProbabilidades.getTentativasUso() == pessoas.size()/2){
                System.out.println("Deseja ver o estado dos banheiros? (s/n): ");
                String resposta = instancia.getScanner().next();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println(Log.estadoBanheiros(banheiros));
                }}

                banheiro.usarBanheiro(pessoa);
                banheiro.sairBanheiro(pessoa.gerarChance(instancia));
            }

            
            
            System.out.println(Log.estadoBanheiros(banheiros));
            
            // Exibir relatório de probabilidades
            coletorProbabilidades.exibirRelatorio();
            
        }

        public void Menu(){
        while (true) {
            System.out.println("\n===== MENU SIMULADOR =====");
            System.out.println("1. Iniciar Simulação");
            System.out.println("2. Mostrar Relatório de Probabilidades");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = instancia.getScanner().nextInt();

            switch (opcao) {
            case 1 -> Inicar();
            case 2 -> coletorProbabilidades.exibirRelatorio();
            case 3 -> {
                System.out.println("Saindo...");
                return;
                }
            default -> System.out.println("Opção inválida.");
            }
        }  }
        
    

    public void CriarBanheiros(){
        System.out.println("Digite quantos banheiros deseja criar: ");
       
        int quantidade = getInstancia().getScanner().nextInt();
        for(int i = 0; i<quantidade;i++){
            this.getBanheiros().add(new Banheiro());
        }
    }
    public void CriarPessoas(){
        System.out.println("Digite quantos Pessoas deseja criar: ");
        int quantidade = getInstancia().getScanner().nextInt();
        for(int i = 0; i<quantidade;i++){
            // Aumenta a chance de criar Pessoa_educada (por exemplo, 70% educada, 30% não educada)
            if (getInstancia().getRandom().nextInt(10) < 7) {
                this.getPessoas().add(new Pessoa_educada());
            } else {
                this.getPessoas().add(new Pessoa_nao_educada());
            }
        }
    }

    
    public static int getRodadas() {
        return rodadas;
    }

    public ArrayList<Banheiro> getBanheiros() {
        return this.banheiros;
    }


    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public Utilidades getInstancia() {
        return instancia;
    }

    public static Probabilidades getColetorProbabilidades() {
        return coletorProbabilidades;
    }

    




    





}
