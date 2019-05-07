package top.flygrk.ishare.serialize.impl;

import com.alibaba.fastjson.JSON;
import top.flygrk.ishare.serialize.Serializer;
import top.flygrk.ishare.serialize.SerializerAlogrithm;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/6 17:15
 * @description： json序列化
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {

        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {

        return JSON.parseObject(bytes, clazz);
    }
}
