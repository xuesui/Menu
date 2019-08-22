package com.mredrock.cyxbs.freshman.litepal;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Star extends DataSupport {
    private int which;

    public int getWhich() {
        return which;
    }

    public void setWhich(int which) {
        this.which=which;
    }
}
