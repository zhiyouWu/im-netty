package top.flygrk.ishare.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import top.flygrk.ishare.protocol.Packet;
import top.flygrk.ishare.protocol.PacketCodeC;
import top.flygrk.ishare.protocol.request.LoginRequestPacket;
import top.flygrk.ishare.protocol.response.LoginResponsePacket;

import java.util.Date;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/6 17:05
 * @description： 服务端处理客户端的登陆请求
 */
public class ServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(new Date() + "客户端开始登陆。。。。。。");
        ByteBuf requestByteBuf = (ByteBuf) msg;

        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        if (packet instanceof LoginRequestPacket) {
            //登陆流程
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());

            if (valid(loginRequestPacket)) {
                loginResponsePacket.setSuccess(true);
                System.out.println(new Date() + ": 登陆成功！");
            } else {
                loginResponsePacket.setReason("账号密码校验失败！");
                loginResponsePacket.setSuccess(false);
                System.out.println(new Date() + "登陆失败！");
            }

            //登陆相应
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
