public class FMoyenPaiement {
    public static IMoyenPaiement creerMoyenPaiement(String type) {
        switch (type) {
            case "Carte Bancaire":
                return new CarteBancaire();
            case "PayPal":
                return new PayPal();
            case "Cryptomonnaie":
                return new Cryptomonnaie();
            default:
                return null;
        }

    }


    }

