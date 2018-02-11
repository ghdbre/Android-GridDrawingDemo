package de.dbremes.griddrawingdemo;

public class DemoItem {
    private int mId;

    public DemoItem(int id) {
        mId = id;
    }

    public String getText() {
        return Integer.toString(mId);
    }
}