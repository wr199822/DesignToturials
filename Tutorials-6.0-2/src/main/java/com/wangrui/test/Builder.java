package com.wangrui.test;

import com.wangrui.test.celling.LevelOneCeiling;
import com.wangrui.test.celling.LevelTwoCeiling;
import com.wangrui.test.coat.DuluxCoat;
import com.wangrui.test.coat.LiBangCoat;
import com.wangrui.test.floor.ShengXiangFloor;
import com.wangrui.test.tile.DongPengTile;
import com.wangrui.test.tile.MarcoPoloTile;

public class Builder {

    //这也是建造者的关键  调用不同的方法 来选择不同的材料
    public IMenu levelOne(Double area){
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，一级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，一级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

}