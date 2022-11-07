package com.wangrui.test;

import com.wangrui.test.celling.LevelOneCeiling;
import com.wangrui.test.coat.DuluxCoat;
import com.wangrui.test.tile.DongPengTile;
import org.junit.Test;

/**
 * @author wangrui
 * @date 2022/11/6
 * @Description 建造者模式
 */
public class ApiTest {

    @Test
    public void test_Builder(){
        Builder builder = new Builder();

        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());

        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());

        DecorationPackageMenu decorationPackageMenu = new DecorationPackageMenu(86.6D,"自定义");
        String detail = decorationPackageMenu.appendCeiling(new LevelOneCeiling()).appendCoat(new DuluxCoat()).appendTile(new DongPengTile())
                .getDetail();
        System.out.println(detail);
    }
}
