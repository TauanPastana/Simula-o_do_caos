package Enums;
public enum Comportamento {
    EDUCADO(90),
    MAL_EDUCADO(20);

    private final int chanceBase;

    Comportamento(int chanceBase) {
        this.chanceBase = chanceBase;
    }

    public int getChanceBase() {
        return chanceBase;
    }
}
