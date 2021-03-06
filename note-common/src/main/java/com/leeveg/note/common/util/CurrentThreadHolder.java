package com.leeveg.note.common.util;

import com.leeveg.note.api.dto.UserInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CurrentThreadHolder {
    private static final ThreadLocal<Map<Object, Object>> currentThread = new ThreadLocal<>();

    public static <K, V> void set(K key, V value) {
        Map data = currentThread.get();
        if (data == null) {
            Map<Object, Object> map = new HashMap<>();
            map.put(key, value);
            currentThread.set(map);
        } else {
            data.put(key, value);
        }
    }

    public static <K, V> V get(K key) {
        Map data = currentThread.get();
        if (data != null) {
            return (V) data.get(key);
        }
        return null;
    }

    /**
     * 获取流水号
     *
     * @return
     */
    public static String getReqNo() {
        String reqno = get("reqno");
        if (reqno == null || reqno.length() <= 0) {
            reqno = UUID.randomUUID().toString().toLowerCase().replace("-", "");
            set("reqno", reqno);
        }
        return reqno;
    }

    /**
     * 获取 user 信息
     *
     * @return
     */
    public static UserInfo getUser() {
        return get("user");
    }

    /**
     * 保存 user 信息
     *
     * @return
     */
    public static void setUser(UserInfo user) {
        set("user", user);
    }

    public static void remove() {
        currentThread.remove();
    }

}

