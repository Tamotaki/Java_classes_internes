public class Robot {
    //Champs
    private String nom;
    private boolean allume;
    private int energie;

    //Constructeur
    public Robot(String nom, int energie){
        this.nom=nom;

        if (energie < 0) {
            this.energie = 0;
        } else if (energie > 100) {
            this.energie = 100;
        } else {
            this.energie = energie;
        }
        this.allume = false;
    }

    //Méthodes allumer et eteindre
    public void allumer() {
        allume = true;
    }
    public void eteindre(){
        allume = false;
    }

    //Méthode getBras
    public Bras getBras(){
        return new Bras();
    }

    //classe interne membre Bras
    class Bras {
        //Champs bras
        private String objet;

        //Methodes saisir, déposer, afficherEtat
        public void saisir (String objet){
            if (allume && energie > 20) {
                System.out.println("Robot allumé et énergie >20");
                energie -= 10;
            }
            else {
                System.out.println("Impossible : robot éteint ou énergie insuffisante.");
        }
        public void deposer (String objet){
            if (allume) {
                System.out.println("Robot allumé");
                energie -= 5;
            }
        }
        public void afficherEtat() {
            System.out.println("Nom : " + nom);
            System.out.println("État : " + (allume ? "allumé" : "éteint"));
            System.out.println("Énergie : " + energie);
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot("R1", 50);
        Bras bras = robot.getBras();

        //Saisir avant allumge
        bras.saisir("objet1");
        robot.allumer();
        //Autres opérations
        bras.saisir("objet2");
        bras.deposer("objet2");
        bras.afficherEtat();
        robot.eteindre();
        //Test de commande qui ne devrait pas marcher
        bras.saisir("objet3");
    }
}
