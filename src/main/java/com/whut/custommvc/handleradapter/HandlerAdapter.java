package com.whut.custommvc.handleradapter;

import com.whut.custommvc.MockRequest;
import com.whut.custommvc.MockResponse;
import com.whut.custommvc.handlermethod.HandlerMethod;

/**
 * <p>InitBinderFactory, ModelFactory, ArgumentResolver,
 * ReturnValueHandler and MessageConverter will be stored in cache List</p>
 *
 * @author liuqiao
 * @since 2024-10-06
 */
public interface HandlerAdapter {


    /**
     * judge whether this adapter is suitable for handler
     */
    boolean supports(HandlerMethod handlerMethod);


    /**
     * enhance handler and invoke handler's method
     */
    void handle(MockRequest request, MockResponse response, HandlerMethod handlerMethod);
}
