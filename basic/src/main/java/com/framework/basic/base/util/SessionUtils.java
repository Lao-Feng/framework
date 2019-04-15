package com.framework.basic.base.util;

import com.framework.basic.session.UserSession;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:46
 * @Description: session工具类
 */
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
