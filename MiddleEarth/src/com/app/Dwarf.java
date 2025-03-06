package com.app;

class Dwarf extends MiddleEarthCharacter {
    public Dwarf(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Elf) {
            target.health -= this.power * 1.5;
            return true;
        } else if (target instanceof Wizard || target instanceof Dwarf) {
            return false;
        } else {
            target.health -= this.power;
            return true;
        }
    }

    @Override
    public String getRace() {
        return "Dwarf";
    }
}
