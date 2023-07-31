import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Character {
    private String name;
    private int level;
    private int exp;
    private int strength = 1;
    private int dexterity = 1;
    private int intelligence = 1;
    private int endurance = 1;
    private int charisma = 1;

    private boolean isDead = false;
    private boolean isPoisoned = false;


    private int hp;
    private int mp;

    private boolean overEncumbered = false;
    private Map<String, Item> inventory = new HashMap<>();
    private double totalWeight = 0.0;
    private Map<String, Skill> skills = new HashMap<>();
    private Map<String, Ability> abilities = new HashMap<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Item> inventory) {
        this.inventory = inventory;
    }


    public Item getItem(String item) {
        return inventory.get(item);
    }

    public void addItem(Item item, String name) {
        this.inventory.put(name, item);
    }

    public Map<String, Ability> getAbilities() {
        return abilities;
    }


    public void setAbilities(Map<String, Ability> abilities) {
        this.abilities = abilities;
    }

    public void addAbilities(Ability ability, String name) {
        abilities.put(name, ability);
    }

    public Map<String, Skill> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Skill> skills) {
        this.skills = skills;
    }

    public void addSKill(Skill skill, String name) {
        skills.put(name, skill);
    }

    public Skill getSkill(String item) {
        return skills.get(item);
    }

    public void levelUp() {
        final int expToUp = (int) Math.round(this.level*Math.exp(0.125));

        if(exp >= expToUp) {
            this.level++;
        }
    }

    public void calculateTotalWeight() {
        final double[] a = {0.0};
        inventory.forEach((key, value) -> {
           a[0] += value.getWeight();
        });

        totalWeight = a[0];
    }

    public void checkEncumbered() {
        calculateTotalWeight();

        if(totalWeight > this.strength*20) {
            overEncumbered = true;
        } else {
            overEncumbered = false;
        }
    }

    public void checkDead() {
        if(this.hp <= 0) {
            this.isDead = true;
        } else {
            this.isDead = false;
        }
    }

    public void poisoned() {
        this.hp -= this.hp*.15;
    }

    public void gainExp(int exp) {
        this.exp += exp;
    }
}