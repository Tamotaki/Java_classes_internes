import java.util.*;
import java.util.stream.Collectors;

class Produit {
    private String nom;
    private String categorie;
    private double prix;
    private int quantite;

    public Produit(String nom, String categorie, double prix, int quantite) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() { return nom; }
    public String getCategorie() { return categorie; }
    public double getPrix() { return prix; }
    public int getQuantite() { return quantite; }

    @Override
    public String toString() {
        return nom + categorie + prix + "€ qté: " + quantite;
    }
}

public class GestionnaireStock {

    private List<Produit> stock = new ArrayList<>();

    public void ajouterProduit(Produit p) { stock.add(p); }
    //Methode pour ajouter un produit
    public List<Produit> filtrerEtTrier(String categorie, double prixMax, int quantiteMin) {

        //Définir l'interface locale Filtre
        interface Filtre {
            boolean accepter(Produit p);
        }

        //Definir la classe locale FiltreCompose
        class FiltreCompose implements Filtre {
            @Override
            public boolean accepter(Produit p) {
                return p.getCategorie().equalsIgnoreCase(categorie)
                        && p.getPrix() <= prixMax
                        && p.getQuantite() >= quantiteMin;
            }
        }
        //Filtrer et trier
        Filtre filtre = new FiltreCompose();
        List<Produit> resultat = new ArrayList<>();
        for (Produit p : stock) {
            if (filtre.accepter(p)) {
                resultat.add(p);
            }
        }
        resultat.sort(Comparator.comparingDouble(Produit::getPrix));
        return resultat;
    }

    public static void main(String[] args) {
        GestionnaireStock gs = new GestionnaireStock();
        gs.ajouterProduit(new Produit("Objet10", "Cat1", 49.99, 10));
        gs.ajouterProduit(new Produit("Objet11", "Cat1", 29.99, 5));
        gs.ajouterProduit(new Produit("Objet12", "Cat2", 299.99, 3));
        gs.ajouterProduit(new Produit("Objet13", "Cat2", 199.99, 2));
        gs.ajouterProduit(new Produit("Objet14", "Cat2", 89.99, 8));
        gs.ajouterProduit(new Produit("Objet15", "Cat1", 59.99, 7));
        gs.ajouterProduit(new Produit("Objet16", "Cat1", 79.99, 4));
        gs.ajouterProduit(new Produit("Objet17", "Cat2", 39.99, 12));

        System.out.println("Cat1, max 100€, min 4 en stock");
        gs.filtrerEtTrier("Cat1", 100.0, 4)
                .forEach(System.out::println);

        System.out.println("Cat2, max 200€, min 2 en stock");
        gs.filtrerEtTrier("Cat2", 200.0, 2)
                .forEach(System.out::println);
    }
}