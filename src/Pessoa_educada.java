public class Pessoa_educada extends Pessoa {
    private static int quantidade_educado;

    
    public Pessoa_educada(){
        this.setId();
        this.setTipo(Comportamento.EDUCADO);
        Pessoa.setQuantidade();
        quantidade_educado++;
    }
    public static int getQuantidade_educado() {
        return quantidade_educado;
    }
    
    }
        
    

    

    

