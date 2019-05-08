package top.flygrk.ishare.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import top.flygrk.ishare.protocol.Packet;
import top.flygrk.ishare.protocol.PacketCodeC;
import top.flygrk.ishare.protocol.request.LoginRequestPacket;
import top.flygrk.ishare.protocol.response.LoginResponsePacket;
import top.flygrk.ishare.protocol.response.MessageResponsePacket;
import top.flygrk.ishare.utils.LoginUtil;

import java.util.Date;
import java.util.UUID;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/7 9:58
 * @description： 客户端处理器
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + ": 客户端开始登陆");
        //创建登陆对象
        LoginRequestPacket requestPacket = new LoginRequestPacket();
        requestPacket.setUserId(UUID.randomUUID().toString());
        requestPacket.setUsername("flygrk");
        requestPacket.setPassword("zhiyou");
        //编码
        ByteBuf buf = PacketCodeC.INSTANCE.encode(ctx.alloc(), requestPacket);
        ctx.channel().writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket responsePacket = (LoginResponsePacket) packet;
            if (responsePacket.isSuccess()) {
                System.out.println(new Date() + ": 客户端登陆成功！");
                LoginUtil.markAsLogin(ctx.channel());
            } else {
                System.out.println(new Date() + "客户端登陆失败，原因：" + responsePacket.getReason());
            }
        } else if (packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            System.out.println(new Date() + ": 收到服务端的消息： " + messageResponsePacket.getMessage());
        }
    }
}
