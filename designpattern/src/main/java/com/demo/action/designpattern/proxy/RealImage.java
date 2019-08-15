package com.demo.action.designpattern.proxy;

/**
 * Creator weishi8
 * Date&Time 2019-08-14 19:04
 * description
 */
public class RealImage implements Image {
    @Override
    public void display(ImageType imageType) {
        System.out.println("ImageType:"+imageType+",This is RealImage.display()...");
    }
}
