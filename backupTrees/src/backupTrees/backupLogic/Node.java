package backupTrees.backupLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node implements SubjectI,ObserverI {
    Map<FilterI,List<Node>> map=new HashMap<>();
    private int bNumber;
    private String firstName;
    Node left;
    Node right;

    @Override
    public String toString() {
        return bNumber + ":" + firstName;
    }

    Node(int num,String name){
        bNumber=num;
        firstName=name;
    }

    public int getbNumber() {
        return bNumber;
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void update(int b_Number) {
        bNumber=b_Number;
    }

    @Override
    public void registerObserver(FilterI filterI,ObserverI observer) {
      if(map.containsKey(filterI)){
          map.get(filterI).add((Node) observer);
      }else{
          map.put(filterI,new ArrayList<>());
          map.get(filterI).add((Node) observer);
      }
    }

    @Override
    public void unregisterObserver(FilterI filterI,ObserverI observer) {
        if (map.containsKey(filterI)) {
            List<Node> values = map.get(filterI);

            // Remove the element from the list
            values.remove(observer);

            // If the list is empty, remove the key from the map
            if (values.isEmpty()) {
                map.remove(filterI);
            }
        }

    }

    @Override
    public void notifyAllObservers() {
        for(FilterI filterI: map.keySet()){
           for(Node node:map.get(filterI)){
                if(filterI.check(bNumber)){
                    node.update(bNumber);
                }
           }
        }
    }
}