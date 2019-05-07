package top.flygrk.ishare.protocol.request;

import lombok.Data;
import top.flygrk.ishare.protocol.Packet;

import static top.flygrk.ishare.protocol.command.Command.LOGIN_REQUEST;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/6 17:23
 * @description： 指令数据: 客户端登陆
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
