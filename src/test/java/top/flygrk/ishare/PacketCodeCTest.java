package top.flygrk.ishare;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Assert;
import org.junit.Test;
import top.flygrk.ishare.protocol.Packet;
import top.flygrk.ishare.protocol.PacketCodeC;
import top.flygrk.ishare.protocol.request.LoginRequestPacket;
import top.flygrk.ishare.serialize.Serializer;
import top.flygrk.ishare.serialize.impl.JSONSerializer;

import java.util.UUID;

/**
 * All rights Reserved, Designed by wuzhiyou@utry.cn
 *
 * @author: wuzhiyou
 * @date: 2019/5/7 10:08
 * @description：
 */
public class PacketCodeCTest {

    @Test
    public void encode() {
        Serializer serializer = new JSONSerializer();
        LoginRequestPacket requestPacket = new LoginRequestPacket();

        requestPacket.setVersion((byte) 1);
        requestPacket.setUserId(UUID.randomUUID().toString());
        requestPacket.setUsername("zhangsan");
        requestPacket.setPassword("password");

        PacketCodeC packetCodeC = PacketCodeC.INSTANCE;

        ByteBuf byteBuf = packetCodeC.encode(ByteBufAllocator.DEFAULT, requestPacket);

        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(requestPacket), serializer.serialize(decodedPacket));

    }

}
