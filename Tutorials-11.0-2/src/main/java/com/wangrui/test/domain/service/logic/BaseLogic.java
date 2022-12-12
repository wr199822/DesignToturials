package com.wangrui.test.domain.service.logic;

import com.wangrui.test.domain.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @author wangrui
 * @date 2022/11/14
 * @Description  这个类型就是来进行决策的  看到底是什么结果
 */
public abstract class BaseLogic  implements LogicFilter {

    //matterValue就是匹配的值
    @Override
    public long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList){
        //根据linkList 一层层的判断
        for (TreeNodeLink nodeLine : treeNodeLinkList){
            if (decisionLogic(matterValue, nodeLine)) return nodeLine.getNodeIdTo();
        }

        return 0L;
    }

    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String,String> decisionMatter);


    private boolean decisionLogic(String matterValue,TreeNodeLink nodeLink){
        //得到当前这个nodeLink的匹配规则
        switch (nodeLink.getRuleLimitType()){
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;

        }
    }
}
