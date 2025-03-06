package com.app;

class MiddleEarthCouncil {
    private static MiddleEarthCouncil instance;
    private CharacterManager characterManager;

    private MiddleEarthCouncil() {
        characterManager = new CharacterManager();
    }
/**
     * returns single instance
     * @return
     */
    public static MiddleEarthCouncil getInstance() {
        if (instance == null) {
            instance = new MiddleEarthCouncil();
        }
        return instance;
    }
