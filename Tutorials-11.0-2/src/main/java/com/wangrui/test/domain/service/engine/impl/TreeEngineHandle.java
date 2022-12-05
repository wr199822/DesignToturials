package com.wangrui.test.domain.service.engine.impl;

import com.wangrui.test.domain.model.aggregates.TreeRich;
import com.wangrui.test.domain.model.vo.EngineResult;
import com.wangrui.test.domain.model.vo.TreeNode;
import com.wangrui.test.domain.service.engine.EngineBase;

import java.util.Map;

/**
 * @author wangrui
 * @date 2022/11/14
 * @Description
 */
public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}
