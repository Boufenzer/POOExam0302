public class CarteBancaire implements IMoyenPaiement {

    public void payer(double montant) {
        System.out.println("Paiement de " + montant + "€ effectué par carte bancaire.");
    }
}
