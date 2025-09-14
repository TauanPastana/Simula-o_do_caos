import Enums.EstadoPorta;
import java.util.ArrayList;

public class Zelador {
    
    public void abrirTodosBanheiros(ArrayList<Banheiro> banheiros) {
        for (Banheiro b : banheiros) {
            b.setOcupacao(EstadoPorta.ABERTO);
        }
    }
}