package top.flygrk.ishare.protocol.response;

import static top.flygrk.ishare.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/7 14:37
 * @description： 服务端发送给客户端的消息对象
 */
public class MessageResponsePacket {
    /**
     * 消息
     */
    private String message;

    /**
     * 指令
     * @return
     */
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
