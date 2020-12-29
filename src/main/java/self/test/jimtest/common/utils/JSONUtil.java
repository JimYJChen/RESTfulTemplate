package self.test.jimtest.common.utils;

import com.alibaba.fastjson.JSON;

public class JSONUtil {
    public static String toJsonStr(Object object) {
        return JSON.toJSONString(object);
    }
}
