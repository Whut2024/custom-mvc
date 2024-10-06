package com.whut.custommvc.handlermethod;

import com.whut.custommvc.MockRequest;
import com.whut.custommvc.MockResponse;

/**
 * @author liuqiao
 * @since 2024-10-06
 */
public interface HandlerInterceptor {


    boolean preHandle(MockRequest request, MockResponse response);


    void postHandle(MockRequest request, MockResponse response);
}
