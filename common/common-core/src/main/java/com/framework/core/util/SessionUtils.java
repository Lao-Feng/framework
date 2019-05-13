package com.framework.core.util;

import com.framework.core.base.UserSession;
import lombok.experimental.UtilityClass;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:46
 * @Description: session工具类
 */
@UtilityClass
public class SessionUtils {

    private static final ThreadLocal<UserSession> USER_SESSION_THREAD_LOCAL = new ThreadLocal<>();

    public static UserSession get() {
        return USER_SESSION_THREAD_LOCAL.get();
    }

    public static void set(UserSession session) {
        USER_SESSION_THREAD_LOCAL.set(session);
    }

    public static void remove() {
        USER_SESSION_THREAD_LOCAL.remove();
    }
}
