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
    public static class Builder {

        //Champs du builder
        private String marque;
        private String processeur;
        private int ramGo;
        private int stockageGo = 256;
        private boolean ssd = true;
        private String carteGraphique = "Integree";
        private double prixEuros = 0.0;

        public Builder(String marque, String processeur, int ram) {
            this.marque = marque;
            this.processeur = processeur;
            this.ramGo = ramGo;
        }

        //Méthodes de configuration : retourner this
        public Builder stockageGo(int stockageGo) {
            this.stockageGo = stockageGo;
            return this;
        }
        public Builder ssd(boolean ssd) {
            this.ssd = ssd;
            return this;
        }
        public Builder carteGraphique(String carteGraphique) {
            this.carteGraphique = carteGraphique;
            return this;
        }
        public Builder prixEuros(double prixEuros) {
            this.prixEuros = prixEuros;
            return this;
        }
    }
}
