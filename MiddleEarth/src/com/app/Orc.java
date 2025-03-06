package com.app;

class Orc extends MiddleEarthCharacter {
    public Orc(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Human) {
            target.health -= this.power * 1.5;
            return true;
        } else if (target instanceof Elf || target instanceof Orc) {
            return false;
        } else {
            target.health -= this.power;
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Orc";
    }
}
