package com.framework.core.annotation;

import com.framework.core.base.UserSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static com.framework.core.constant.UserHeaderField.USER_ID;


/**
 * {@link LoginUser} 配置
 *
 * @Author: FengJie
 * @Date: 2019/4/29 15:49
 */
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserSession.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

        // TODO: 2019/4/29 这里需要根据实际情况封装User对象

        String userId = request.getHeader(USER_ID);
        return UserSession.builder()
                .id(userId)
                .build();
    }
}
