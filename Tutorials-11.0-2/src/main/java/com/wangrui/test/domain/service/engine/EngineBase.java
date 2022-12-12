package com.wangrui.test.domain.service.engine;

import com.wangrui.test.domain.model.aggregates.TreeRich;
import com.wangrui.test.domain.model.vo.EngineResult;
import com.wangrui.test.domain.model.vo.TreeNode;
import com.wangrui.test.domain.model.vo.TreeRoot;
import com.wangrui.test.domain.service.logic.LogicFilter;
import org.slf4j.LoggerFactory;
import org.slf4j.*;

import java.util.Map;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @date 2022/4/5
 * @github https://github.com/fuzhengwei/CodeDesignTutorials
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class EngineBase extends EngineConfig implements IEngine{

    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]；1子叶、2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            //拿到节点的规则
            String ruleKey = treeNodeInfo.getRuleKey();
            //根据在这个节点的规则 来判断使用那个方法
            //  多态  用父类或者父接口  调用子类的方法  就会调用传入的那个子类的方法。
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNodeInfo;
    }

}