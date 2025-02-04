public class Client implements IObserver {
    private String nom;

    public Client(String nom) {
        this.nom = nom;
    }

    @Override
    public void update(String statutCommande) {
        System.out.println( nom + " notification de chnagement de statut de la commande  : " + statutCommande);
    }
}
