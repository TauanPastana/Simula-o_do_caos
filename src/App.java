public class App {
    public static void main(String[] args) throws Exception {
         try {
            Simulador simulador = new Simulador();
            simulador.Inicar();

           
            
        } catch (Simulacaoexception e) {
            System.err.println("Erro na simulação: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
        
        
    }
}
