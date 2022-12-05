package com.wangrui.test.domain.service.engine;

import com.wangrui.test.domain.model.aggregates.TreeRich;
import com.wangrui.test.domain.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}