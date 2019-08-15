package com.demo.action.designpattern.builder;


/**
 * Creator weishi8
 * Date&Time 2019-08-09 19:20
 * description 建造者模式：
 * 主要方式：通过 Builder 类会一步一步构造最终的对象，而不是把所有的属性，全部放到构造函数里，一次初始化。
 * 如：public Hero(Profession profession, String name, HairType hairType, HairColor hairColor, Armor armor, Weapon weapon) {
 * }
 * 1、创建一个Builder（如HeroBuilder、StringBuilder等）；
 * 2、通过Builder，将对象所需要的各个元素，逐个添加；
 * 3、最后调用build方法，生成需要创建的对象 Hero。
 *
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
