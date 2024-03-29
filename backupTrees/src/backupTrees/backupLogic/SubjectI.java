package backupTrees.backupLogic;

public interface SubjectI {
    public void registerObserver(FilterI filterI,ObserverI observer);
    public void unregisterObserver(FilterI filterI,ObserverI observer);
    public void notifyAllObservers();
}
