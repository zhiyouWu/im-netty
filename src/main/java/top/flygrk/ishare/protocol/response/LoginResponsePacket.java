package top.flygrk.ishare.protocol.response;

import lombok.Data;
import top.flygrk.ishare.protocol.Packet;

import static top.flygrk.ishare.protocol.command.Command.LOGIN_RESPONSE;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/6 17:24
 * @description：
 */
@Data
public class LoginResponsePacket  extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}