package com.app;

class MiddleEarthCouncil {
    private static MiddleEarthCouncil instance;
    private CharacterManager characterManager;

    private MiddleEarthCouncil() {
        characterManager = new CharacterManager();
    }
