package com.guchen.utils;

import java.util.HashMap;

public class Result extends HashMap<String, Object> {
    public static Result ok(String msg) {
        Result result = new Result();
        result.put("code", 200);
        result.put("msg", msg);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.put("code", 500);
        result.put("msg", msg);
        return result;
    }

    @Override
    public Object put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}