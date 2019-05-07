package top.flygrk.ishare.attribute;

import io.netty.util.AttributeKey;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/7 20:44
 * @description： 记录相应的标志位
 */
public interface Attributes {
    /**
     * 定义是否登陆成功的标志位
     */
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
