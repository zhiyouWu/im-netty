package top.flygrk.ishare.protocol.request;

import lombok.Data;

import static top.flygrk.ishare.protocol.command.Command.MESSAGE_REQUEST;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/7 14:34
 * @description： 客户端发送至服务端的消息对象
 */
@Data
public class MessageRequestPacket {
    /**
     * 消息
     */
    private String message;

    /**
     * 指令
     * @return
     */
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}