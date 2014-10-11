package Players;

import java.util.HashMap;

/**
 * Created by chase on 10/11/14.
 */
public class ElementalPouch {

    protected final int maxCount;
    protected HashMap<String, Integer> elementMap;
    protected int elementCount = 0;

    public ElementalPouch(){
        this(5);
    }

    public ElementalPouch(int maxCount){
        this.maxCount = maxCount;
        elementMap = new HashMap<String, Integer>();
    }

    public boolean canHoldElement(){
        if(elementCount == maxCount){
            return false;
        }
        return true;
    }

    public boolean addElement(String element){
        if(elementCount == maxCount){
            return false;
        }
        if(elementMap.get(element) == null){
            elementMap.put(element, 1);
        }else{
            elementMap.put(element, elementMap.get(element) + 1);
        }
        elementCount++;
        return true;
    }


}
