
public class Cryptomonnaie implements IMoyenPaiement {

    public void payer(double montant) {
        System.out.println("Paiement de " + montant + "€ effectué via Cryptomonnaie.");
    }
}
