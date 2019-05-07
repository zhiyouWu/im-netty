package top.flygrk.ishare.utils;


import io.netty.channel.Channel;
import io.netty.util.Attribute;
import top.flygrk.ishare.attribute.Attributes;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/7 20:50
 * @description： 登陆工具
 */
public class LoginUtil {

    /**
     * 设置登录标志位
     * @param channel
     */
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    /**
     * 判断是否有标志位
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        return loginAttr.get() != null;
    }

}
