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
