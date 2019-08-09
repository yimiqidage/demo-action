package com.demo.action.designpattern.builder;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 19:32
 * description
 */
public class BuilderTest {

    public static void main(String[] args) {
        Hero hero1 = new Hero.HeroBuilder(Profession.MAGE)
                .withArmor(Armor.CHAIN_MAIL)
                .withWeapon(Weapon.BOW)
                .build();
        System.out.println(hero1.toString());
    }

}
