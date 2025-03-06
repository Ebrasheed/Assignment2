package com.app;

class Wizard extends MiddleEarthCharacter {
    public Wizard(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Dwarf) {
            target.health -= this.power * 1.5;
            return true;
        } else if (target instanceof Human || target instanceof Wizard) {
            return false;
        } else {
            target.health -= this.power;
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Wizard";
    }
}

