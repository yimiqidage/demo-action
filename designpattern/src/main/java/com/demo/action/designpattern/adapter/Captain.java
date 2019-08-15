package com.demo.action.designpattern.adapter;

/**
 * Creator weishi8
 * Date&Time 2019-08-12 20:58
 * description
 * 船长
 */
public class Captain   {
    private  RowingBoat rowingBoat;

    public Captain(){}

    public Captain (RowingBoat rowingBoat){
        this.rowingBoat = rowingBoat;
    }

    public void row(){
        System.out.println("Captain is row...");
        rowingBoat.row();
    }
}
