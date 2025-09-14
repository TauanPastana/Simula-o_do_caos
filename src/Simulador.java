

import Padroes_Projetos.Observavel;
import Padroes_Projetos.Utilidades;
import java.util.ArrayList;
import java.util.Collections;

public class Simulador implements Observavel{

    
      private final ArrayList<Banheiro> banheiros;
    private final ArrayList<Pessoa> pessoas;
    private static Utilidades instancia;
    private static int rodadas;
    private static Probabilidades coletorProbabilidades;
    private Zelador zelador;

    public Simulador(){
        this.banheiros = new ArrayList<>();
        this.pessoas = new ArrayList<>();
        instancia = Utilidades.getInstance();
        coletorProbabilidades = new Probabilidades();
        this.zelador = new Zelador();
    }
    
    public void Inicar() throws Simulacaoexception{
        CriarPessoas();
        CriarBanheiros();
        Collections.shuffle(pessoas);
        Collections.shuffle(banheiros);
        coletorProbabilidades.setTotalPessoasSimuladas(pessoas.size());
        int numeroAleatorio = getInstancia().getRandom().nextInt(1, pessoas.size()+1);
        if (banheiros.isEmpty()) {
        throw new Simulacaoexception("Nenhum banheiro foi criado antes da simulação!");
    }
    if (pessoas.isEmpty()) {
        throw new Simulacaoexception("Nenhuma pessoa foi criada antes da simulação!");
    }
        
        
        
        for (Pessoa pessoa : pessoas) {
            coletorProbabilidades.Notificar("TENTATIVA_USO");
            Banheiro banheiro = pessoa.EscolherBanheiro(banheiros, instancia);
            if(banheiro == null) {
                notificarObservadores("DESISTENCIA");
                continue;
            }
            if((int)coletorProbabilidades.getTentativasUso() == numeroAleatorio){
                getZelador().abrirTodosBanheiros(banheiros); 
                continue;
            }
                banheiro.usarBanheiro(pessoa);
                banheiro.sairBanheiro(pessoa.gerarChance(instancia));
            }
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
            
            if (getInstancia().getRandom().nextInt(10) < 6) {
                this.getPessoas().add(new Pessoa_educada());
            } else {
                this.getPessoas().add(new Pessoa_nao_educada());
            }
        }
    }

    

    
    @Override
    public void notificarObservadores(String evento) {
        coletorProbabilidades.Notificar(evento);
        
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

    public Zelador getZelador() {
        return zelador;
    }



    




    





}
