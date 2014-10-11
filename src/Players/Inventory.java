package Players;

/**
 * Created by chase on 10/11/14.
 */
public class Inventory {

    private ElementalPouch pouch;

    public Inventory(){
        pouch = new SmallPouch();
    }

    public ElementalPouch getPouch(){
        return pouch;
    }
}
