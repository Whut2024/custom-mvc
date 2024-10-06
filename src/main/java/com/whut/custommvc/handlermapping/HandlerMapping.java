package com.whut.custommvc.handlermapping;

import com.whut.custommvc.MockRequest;
import com.whut.custommvc.handlermethod.HandlerExecutionChain;

/**
 * @author liuqiao
 * @since 2024-10-06
 */
public interface HandlerMapping {

    /**
     * get handler execution chain by request's uri path from map cache
     */
    HandlerExecutionChain getHandler(MockRequest request);
}
