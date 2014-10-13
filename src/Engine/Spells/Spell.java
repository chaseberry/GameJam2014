package Engine.Spells;

import Engine.Entity;
import Mapping.Tile;

import java.awt.image.BufferedImage;


public abstract class Spell extends Entity {

    protected int manaCost;
    protected int coolDown;
    protected double range;
    protected String name;
    protected String description;
    protected SpellType.Type spellType;
    protected Object target;//Tile or Entity
    protected BufferedImage icon;
    protected int level;
    protected int id;

    public Spell(double x, double y) {
        super(x, y);
    }

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

    public abstract void cast();

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SpellType.Type getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType.Type spellType) {
        this.spellType = spellType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public void setIcon(BufferedImage icon) {
        this.icon = icon;
    }

    public int getId(){
        return id;
    }
}
