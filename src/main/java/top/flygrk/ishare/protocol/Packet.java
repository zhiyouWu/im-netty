package top.flygrk.ishare.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/6 17:09
 * @description： 通信协议java对象
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 指令
     * @return
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();

}
