
import java.util.ArrayList;
import java.util.Collections;

public class Simulador {

    
    private final ArrayList<Banheiro> banheiros;
    private final ArrayList<Pessoa> pessoas;
    private static Utilidades instancia;
    private static int rodadas;
    private Probabilidades coletorProbabilidades;
    
    public Simulador(){
        this.banheiros = new ArrayList<>();
        this.pessoas = new ArrayList<>();
        instancia = Utilidades.getInstance();
        this.coletorProbabilidades = new Probabilidades();
    }
    
    public void Inicar(){
        Collections.shuffle(pessoas);
        Collections.shuffle(banheiros);
        
        // Registrar observador em todos os banheiros
        for (Banheiro banheiro : banheiros) {
            banheiro.registrarObservador(coletorProbabilidades);
        }
        
        coletorProbabilidades.setTotalPessoasSimuladas(pessoas.size());
        
        System.out.println(Log.quantidadePessoasEducadasENaoEducadas());
        System.out.println(Log.estadoBanheiros(banheiros));
        
        for (Pessoa pessoa : pessoas) {
            coletorProbabilidades.registrarTentativaUso();
            
            Banheiro banheiro = pessoa.EscolherBanheiro(banheiros, instancia);
            if(banheiro == null) {
                coletorProbabilidades.registrarDesistencia();
                coletorProbabilidades.registrarEventoTodosOcupados();
                coletorProbabilidades.registrarEventoNenhumDisponivel();
                break;
            }
            
            coletorProbabilidades.registrarEventoPeloMenosUmAberto();
            banheiro.usarBanheiro(pessoa);
            banheiro.sairBanheiro(pessoa.gerarChance(instancia));
        }
        
        System.out.println(Log.estadoBanheiros(banheiros));
        
        // Exibir relatório de probabilidades
        coletorProbabilidades.exibirRelatorio();
    }

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
            if (getInstancia().getRandom().nextInt(10) < 6) {
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




    





}
