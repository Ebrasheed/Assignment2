package com.app;

class CharacterManager {
    private MiddleEarthCharacter[] characters;
    private int size;

    public CharacterManager() {
        characters = new MiddleEarthCharacter[5];
        size = 0;
    }
/**
     * this method adds a character and doubles the array size if full
     * @param c
     * character to be added
     * @return
     * return true if character was added
     */
    public boolean addCharacter(MiddleEarthCharacter c) {
        if (size >= characters.length) {
            resizeArray();
        }
        characters[size++] = c;
        return true;
    } 
    /**
     * this method updates the information of a given character
     * @param name
     * name of character
     * @param health
     * health of character
     * @param power
     * power level of character
     * @return
     * return true if there is a change and false if there is not
     */
    public boolean updateCharacter(String name, double health, double power) {
        MiddleEarthCharacter character = getCharacter(name);
        if (character != null) {
            character.setHealth(health);
            character.setPower(power);
            return true;
        }
        return false;
    }
    /**
     * this method retrieves a character by name
     * @param name
     * name to be retrieved
     * @return
     */
    public MiddleEarthCharacter getCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].getName().equals(name)) {
                return characters[i];
            }
        }
        return null;
    }
 /**
     * this method doubles the size of the array when full
     */
    private void resizeArray() {
        MiddleEarthCharacter[] newCharacters = new MiddleEarthCharacter[characters.length * 2];
        System.arraycopy(characters, 0, newCharacters, 0, characters.length);
        characters = newCharacters;
    }
