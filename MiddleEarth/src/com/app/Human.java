package com.app;

class Human extends MiddleEarthCharacter {
    public Human(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Wizard) {
            target.health -= this.power * 1.5;
            return true;
        } else if (target instanceof Orc || target instanceof Human) {
            return false;
        } else {
            target.health -= this.power;
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Human";
    }
}
