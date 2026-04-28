import java.util.*;

@FunctionalInterface
interface ClickListener {
    void onClick(int x, int y);
}

@FunctionalInterface
interface KeyListener {
    void onKeyPress(char touche);
}

@FunctionalInterface
interface HoverListener {
    void onHover(boolean entre);
}

class Bouton {
    private String label;
    private List<ClickListener> clickListeners = new ArrayList<>();
    private List<KeyListener> keyListeners = new ArrayList<>();
    private List<HoverListener> hoverListeners = new ArrayList<>();

    public Bouton(String label) { this.label = label; }

    public void addClickListener(ClickListener l) { clickListeners.add(l); }
    public void addKeyListener(KeyListener l) { keyListeners.add(l); }
    public void addHoverListener(HoverListener l) { hoverListeners.add(l); }

    public void removeClickListener(ClickListener l) { clickListeners.remove(l); }
    public void removeKeyListener(KeyListener l) { keyListeners.remove(l); }
    public void removeHoverListener(HoverListener l) { hoverListeners.remove(l); }

    public void simulerClic(int x, int y) {
        for (ClickListener l : clickListeners) l.onClick(x, y);
    }
    public void simulerTouche(char c) {
        for (KeyListener l : keyListeners) l.onKeyPress(c);
    }
    public void simulerSurvol(boolean entre) {
        for (HoverListener l : hoverListeners) l.onHover(entre);
    }
}

public class SystemeEvenements {

    public static void main(String[] args) {
        Bouton btn = new Bouton("Valider");
        final int[] compteur = {0};

        // ClickListener 1 : affiche les coordonnées
        btn.addClickListener(new ClickListener() {
            @Override
            public void onClick(int x, int y) {
                System.out.println("Clic détecté en (" + x + ", " + y + ")");
            }
        });

        // ClickListener 2 : incrémente un compteur
        btn.addClickListener(new ClickListener() {
            @Override
            public void onClick(int x, int y) {
                compteur[0]++;
                System.out.println("Nombre de clics" + compteur[0]);
            }
        });

        // KeyListener : distingue voyelles et consonnes
        btn.addKeyListener(new KeyListener() {
            @Override
            public void onKeyPress(char touche) {
                String voyelles = "aeiouAEIOU";
                if (voyelles.indexOf(touche) >= 0) {
                    System.out.println("Touche" + touche + "voyelle");
                } else {
                    System.out.println("Touche" + touche + "consonne");
                }
            }
        });

        // HoverListener : info-bulle fictive
        btn.addHoverListener(new HoverListener() {
            @Override
            public void onHover(boolean entre) {
                if (entre) System.out.println("Cliquez pour valider le formulaire");
                else System.out.println("masquée");
            }
        });

        // Simulation des interactions
        btn.simulerSurvol(true);
        btn.simulerClic(100, 200);
        btn.simulerClic(150, 250);
        btn.simulerTouche('a');
        btn.simulerTouche('k');
        btn.simulerSurvol(false);
    }

    // Version lambda de la méthode main (Partie B)
    public static void mainLambda(String[] args) {
        Bouton btn = new Bouton("Valider");
        final int[] compteur = {0};

        btn.addClickListener((x, y) -> System.out.println("Clic en (" + x + ", " + y + ")"));
        btn.addClickListener((x, y) -> System.out.println("Nombre de clics" + (++compteur[0])));
        btn.addKeyListener(touche -> {
            String voyelles = "aeiouAEIOU";
            System.out.println("Touche '" + touche + "' : " +
                    (voyelles.indexOf(touche) >= 0 ? "voyelle" : "consonne"));
        });
        btn.addHoverListener(entre -> System.out.println(
                entre ? "Cliquez pour valider" : "masquée"));

        btn.simulerSurvol(true);
        btn.simulerClic(100, 200);
        btn.simulerClic(150, 250);
        btn.simulerTouche('a');
        btn.simulerTouche('k');
        btn.simulerSurvol(false);
    }
// Cas 1 : Interface non fonctionnelle (plusieurs méthodes abstraites)
// Un lambda ne peut implémenter qu'une seule méthode. Si l'interface en a plusieurs, une classe anonyme est obligatoire
    Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String a, String b) { return a.compareTo(b); }
        // Si on avait besoin d'override equals() aussi, seule la classe anonyme le permet.
    }
// Cas 2 : Besoin d'un état interne ou de plusieurs champs
// Un lambda est stateless. Si on a besoin de conserver un état entre deux appels, la classe anonyme est nécessaire
    ClickListener compteurListener = new ClickListener() {
        private int count = 0; // état interne impossible dans un lambda
        @Override
        public void onClick(int x, int y) {
            count++;
            System.out.println("Clic n°" + count);
        }
    };
}