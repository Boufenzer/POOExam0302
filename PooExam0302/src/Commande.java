import java.util.ArrayList;
import java.util.List;

public class Commande implements ISubject {
    private String id;
    private String statut;
    private List<IObserver> clients;
    private List<Produit> produits;
    private double prixTotal;


    private Commande(CommandeBuilder builder) {
        this.id = builder.id;
        this.statut = builder.statut;
        this.clients = builder.clients;
        this.produits = builder.produits;
        this.calculerPrixTotal();
    }

    @Override
    public void ajouterObserver(IObserver o) {
        clients.add(o);
    }

    @Override
    public void retirerObserver(IObserver o) {
        clients.remove(o);
    }

    @Override
    public void notifierObservers() {
        for (IObserver o : clients) {
            o.update(statut);
        }
    }

    public void changerStatut(String nouveauStatut) {
        this.statut = nouveauStatut;
        System.out.println("Changement de statut pour la commande " + id + ": " + statut);
        notifierObservers();
    }

    public String getId() {
        return id;
    }

    public String getStatut() {
        return statut;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id='" + id + '\'' +
                ", statut='" + statut + '\'' +
                ", clients=" + clients +
                ", produits=" + produits +
                ", prixTotal=" + prixTotal +
                '}';
    }


    private void calculerPrixTotal() {
        prixTotal = 0;
        for (Produit produit : produits) {
            prixTotal += produit.getPrix();
        }

    }


    public static class CommandeBuilder {
        private String id;
        private String statut = "En attente";
        private List<IObserver> clients = new ArrayList<>();
        private List<Produit> produits = new ArrayList<>();

        public CommandeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public CommandeBuilder changerStatut(String statut) {
            this.statut = statut;
            return this;
        }

        public CommandeBuilder ajouterObserver(IObserver o) {
            this.clients.add(o);
            return this;
        }

        public CommandeBuilder ajouterProduit(Produit produit) {
            this.produits.add(produit);
            return this;
        }

        public Commande build() {
            return new Commande(this);
        }


        }
    }

