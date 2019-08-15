package com.demo.action.designpattern.adapter;

/**
 * Creator weishi8
 * Date&Time 2019-08-13 14:13
 * description
 * 适配器类：
 */
public class FishingBoatAdapter implements RowingBoat {

    private FishingBoat fishingBoat;

    public FishingBoatAdapter(FishingBoat fishingBoat){
        this.fishingBoat = fishingBoat;
    }

    public FishingBoatAdapter(){
        this.fishingBoat = new FishingBoat();
    }

    /**
     * 在实现RowingBoat接口的时候，调用了Adaptee角色的类 FishingBoat 对应的方法。
     */
    @Override
    public void row() {
        System.out.println("FishingBoatAdapter is rowing ...");
        fishingBoat.sail();
    }
}
