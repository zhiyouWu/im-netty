package top.flygrk.ishare.protocol.response;

import lombok.Data;
import top.flygrk.ishare.protocol.Packet;

import static top.flygrk.ishare.protocol.command.Command.MESSAGE_RESPONSE;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/7 14:37
 * @description： 服务端发送给客户端的消息对象
 */
@Data
public class MessageResponsePacket extends Packet{
    /**
     * 消息
     */
    private String message;

    /**
     * 指令
     * @return
     */
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
