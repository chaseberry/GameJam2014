package Engine.Spells;

import Engine.Entity;
import Mapping.Tile;

/**
 * Created by chase on 10/11/14.
 */
public class Spell {

    private int manaCost;
    private int coolDown;
    private int range;
    private String name;
    private String description;
    private int damage;
    private SpellType.Type spellType;
    private Object target;//Tile or Entity

    public Tile getTileTarget() {
        if (target instanceof Tile) {
            return (Tile) target;
        }
        return null;
    }

    public Entity getEntityTarget() {
        if (target instanceof Entity) {
            return (Entity) target;
        }
        return null;
    }

}
