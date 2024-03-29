package backupTrees.backupLogic;
import backupTrees.util.PrimeCheck;
public class FilterPrimeImpl implements FilterI{
    @Override
    public boolean check(int bNumber) {
        PrimeCheck pc=new PrimeCheck();
        return pc.checkPrime(bNumber);
    }
}