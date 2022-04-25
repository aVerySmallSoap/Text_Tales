package com.LirysBoo.Characters;

public class Player extends Character {

    public Player(String name){
        super(
                name,
                100,
                100,
                7,
                10);
    }

    //TODO: Special properties
    public boolean usedHeal = false;

    //TODO: Player exclusive skills
}
