public class Main {
    public static void main(String[] args) {

        Client client1 = new Client("Mehdi");
        Client client2 = new Client("Karim");


        Produit produit1 = new Produit("Ordinateur", 1200.0);
        Produit produit2 = new Produit("Ecran", 119.99);
        Produit produit3 = new Produit("Clavier", 100.0);



        Commande commande = new Commande.CommandeBuilder()
                .setId("1")
                .ajouterObserver(client1)
                .ajouterObserver(client2)
                .ajouterProduit(produit1)
                .ajouterProduit(produit2)
                .ajouterProduit(produit3)
                .build();


        System.out.println(commande.toString());
        System.out.println("Détails de la commande :");
        System.out.println("ID : " + commande.getId());
        System.out.println("Statut : " + commande.getStatut());
        System.out.println("Prix total : " + commande.getPrixTotal() + "€");


        IMoyenPaiement paiement = FMoyenPaiement.creerMoyenPaiement("PayPal");
        paiement.payer(commande.getPrixTotal());
        commande.changerStatut("En cours de livraison");
    }
}
