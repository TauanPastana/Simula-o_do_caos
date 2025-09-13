public interface Observavel {
    void registrarObservador(Probabilidades observador);
    void notificarObservadores(String evento, Object dados);

}
