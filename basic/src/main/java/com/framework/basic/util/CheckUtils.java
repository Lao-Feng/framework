package com.framework.basic.util;

import com.framework.basic.base.BaseEntity;
import com.framework.basic.base.BaseResponse;
import com.framework.basic.enumeration.ResultStatus;
import com.framework.basic.exception.BaseException;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 字段校验工具类
 *
 * @Author: FengJie
 * @Date: 2019/4/11 17:39
 */
public final class CheckUtils {

    private CheckUtils() {
    }

    public static <T extends BaseResponse> T checkResponse(T resp) {
        return checkResponse(resp, resp.getResultCode(), resp.getResultMsg());
    }

    public static <T extends BaseResponse> T checkResponse(T resp, ResultStatus status) {
        return checkResponse(resp, status.getResultCode(), status.getResultMsg());
    }

    public static <T extends BaseResponse> T checkResponse(T resp, Integer resultCode, String resultMsg) {
        checkExpression(isSuccess(resp), resultCode, resultMsg);
        return resp;
    }

    public static <T extends BaseEntity> T checkEntity(T entity, ResultStatus status) {
        return checkEntity(entity, status.getResultCode(), status.getResultMsg());
    }

    public static <T extends BaseEntity> T checkEntity(T entity, Integer resultCode, String resultMsg) {
        checkExpression(isEnabled(entity), resultCode, resultMsg);
        return entity;
    }

    public static String checkMatches(String text, String regex, ResultStatus status) {
        return checkMatches(text, regex, status.getResultCode(), status.getResultMsg());
    }

    public static String checkMatches(String text, String regex, Integer resultCode, String resultMsg) {
        checkExpression(Pattern.matches(regex, text), resultCode, resultMsg);
        return text;
    }

    public static <T> T checkValues(T param, Collection<T> values, ResultStatus status) {
        return checkValues(param, values, status.getResultCode(), status.getResultMsg());
    }

    public static <T> T checkValues(T param, Collection<T> values, Integer resultCode, String resultMsg) {
        checkExpression(values.contains(param), resultCode, resultMsg);
        return param;
    }

    public static <T> T checkValue(T param, T value, ResultStatus status) {
        return checkValue(param, value, status.getResultCode(), status.getResultMsg());
    }

    public static <T> T checkValue(T param, T value, Integer resultCode, String resultMsg) {
        checkExpression(Objects.equals(param, value), resultCode, resultMsg);
        return param;
    }

    public static <T> T checkNonEmpty(T param, ResultStatus status) {
        return checkNonEmpty(param, status.getResultCode(), status.getResultMsg());
    }

    public static <T> T checkNonEmpty(T param, Integer resultCode, String resultMsg) {
        checkExpression(!ObjectUtils.isEmpty(param), resultCode, resultMsg);
        return param;
    }

    public static void checkExpression(boolean expression, ResultStatus status) {
        checkExpression(expression, status.getResultCode(), status.getResultMsg());
    }

    public static void checkExpression(boolean expression, Integer resultCode, String resultMsg) {
        if (!expression) {
            BaseException.sneakyThrows(resultCode, resultMsg);
        }
    }

    public static <T extends BaseResponse> boolean isSuccess(T resp) {
        return Objects.nonNull(resp) && Objects.equals(resp.getResultCode(), ResultStatus.SUCCESS.getResultCode());
    }

    public static <T extends BaseEntity> boolean isEnabled(T entity) {
        return Objects.nonNull(entity) && Objects.equals(entity.getEnableFlag(), BaseEntity.ON);
    }
}
