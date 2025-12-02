package tech.codoverse;

// Immutable class
public final class Player {

    private final String name;
    private final int health;

    public Player(final String name, final int health) {
        checkName(name);
        checkHealth(health);
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    // public void setName(String name) {
    // checkName(name);
    // this.name = name;
    // }

    private void checkName(String name) {
        if (!name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Please give a valid name.");
        }
    }

    // validate health for protecting wrong data
    // setter or mutator
    // public void setHealth(int health) {
    // checkHealth(health);
    // this.health = health;
    // }

    private void checkHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health between 0 and 100.");
        }
    }

    // getter or accessor
    public int getHealth() {
        return health;
    }

}
