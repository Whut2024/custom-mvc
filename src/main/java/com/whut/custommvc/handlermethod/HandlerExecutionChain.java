package com.whut.custommvc.handlermethod;

import com.whut.custommvc.MockRequest;
import com.whut.custommvc.MockResponse;

/**
 * @author liuqiao
 * @since 2024-10-06
 */
public class HandlerExecutionChain {

    /**
     * invoke all interceptor's preHandler methods by order
     */
    public boolean applyPreHandle(MockRequest request, MockResponse response) {
        return true;
    }

    /**
     * invoke all interceptor's postHandler methods by reverse order
     */
    public void applyPostHandle(MockRequest request, MockResponse response) {}
}
