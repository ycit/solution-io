package com.ycit.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ycit.bean.Dog;

/**
 * @author chenxiaolei
 * @date 2020/3/6
 */
public class JsonUtil {

    /**
     *  首字母小写的对象 转 首字母大写的json
     * @param object
     * @return
     */
    public static String toFirstUppercaseJson(Object object) {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyyMMddHHmmss";
        return JSON.toJSONString(object, new PascalNameFilter(), SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 首字母大写的json 转 首字母小写的对象 T
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static<T> T toFirstLowercaseJava(String json, Class<T> clazz) {
        JSONObject jsonObject = JSON.parseObject(json);
        return JSONObject.toJavaObject(jsonObject, clazz);
    }

    public static void main(String[]args) {
        Dog dog = new Dog();
        dog.setName("jack");
        dog.setAge("1");
        String json = toFirstUppercaseJson(dog);
        System.out.println(json);
        Dog dog2 = toFirstLowercaseJava(json, Dog.class);
        System.out.println(dog2.toString());
    }

}
