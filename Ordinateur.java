public final class Ordinateur {

    //Champs final
    private final String marque;
    private final String processeur;
    private final int ramGo;
    private final int stockageGo;
    private final boolean ssd;
    private final String carteGraphique;
    private final double prixEuros;

    //COnstructeur privé
    private Ordinateur(Builder builder) {
        this.marque = builder.marque;
        this.processeur = builder.processeur;
        this.ramGo = builder.ramGo;
        this.stockageGo = builder.stockageGo;
        this.ssd = builder.ssd;
        this.carteGraphique = builder.carteGraphique;
        this.prixEuros = builder.prixEuros;
    }

    //Getters et toString
    public String getMarque() {
        return marque;
    }
    public String getProcesseur() {
        return processeur;
    }
    public int getRamGo() {
        return ramGo;
    }
    public int getStockageGo() {
        return stockageGo;
    }
    public boolean getSsd() {
        return ssd;
    }
    public String getCarteGraphique() {
        return carteGraphique;
    }
    public double getPrixEuros() {
        return prixEuros;
    }

    @Override
    public String toString() {
        return marque + processeur + ramGo + stockageGo + ssd + carteGraphique + prixEuros;
    }

    //Classe imbriquée statique


}
