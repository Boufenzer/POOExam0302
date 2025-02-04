public interface ICommandeHandler {

    void setNextHandler(ICommandeHandler nextHandler);
    void traiterCommande(Commande commande, EValidation etape);
}
