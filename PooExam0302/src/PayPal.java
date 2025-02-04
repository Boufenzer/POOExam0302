
public class PayPal implements IMoyenPaiement {

    public void payer(double montant) {
        System.out.println("Paiement de " + montant + "€ effectué via PayPal.");
    }
}
