public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Simulador simulador = new Simulador();
        simulador.CriarPessoas();
        simulador.CriarBanheiros();
        simulador.Inicar();
        
        
    }
}
