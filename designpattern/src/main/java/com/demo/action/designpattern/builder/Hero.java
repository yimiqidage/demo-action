package com.demo.action.designpattern.builder;


/**
 * Creator weishi8
 * Date&Time 2019-08-09 19:20
 * description
 */
public final class Hero {

    private final Profession profession;
    private final Armor armor;
    private final Weapon weapon;

    private Hero(HeroBuilder builder){
        this.profession = builder.profession;
        this.armor = builder.armor;
        this.weapon = builder.weapon;
    }

    public Profession getProfession() {
        return profession;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.append("profession:").append(this.profession.name()).append(",")
                .append("armor:").append(this.armor.name()).append(",")
                .append("weapon:").append(this.weapon.name()).append(",")
                .toString();
    }

    public static class  HeroBuilder{
        private final Profession profession;
        private Armor armor;
        private Weapon weapon;
        public HeroBuilder (Profession profession){
            this.profession = profession;
        }

        public HeroBuilder withArmor(Armor armor){
            this.armor = armor;
            return this;
        }

        public HeroBuilder withWeapon(Weapon weapon){
            this.weapon = weapon;
            return this;
        }

        public Hero build(){
            return new Hero(this);
        }
    }

}
