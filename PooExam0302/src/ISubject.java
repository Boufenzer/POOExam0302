public interface ISubject {
    void ajouterObserver(IObserver o);
    void retirerObserver(IObserver o);
    void notifierObservers();


}
