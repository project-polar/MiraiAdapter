package cc.sfclub.mirai.packets;

import cc.sfclub.core.Core;
import cc.sfclub.mirai.Packet;
import cc.sfclub.mirai.packets.received.message.MiraiTypeMessage;
import lombok.Builder;

import java.util.List;

@Builder
public class GroupMessage extends Packet {
    private String sessionKey;
    private long target;
    private List<MiraiTypeMessage> messageChain;

    @Override
    public String getTargetedPath() {
        return "sendGroupMessage";
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Packet send() {
        super.send();
        return this;
    }

    public Resp asResponse() {
        return Core.getGson().fromJson(getRawResponse(), Resp.class);
    }

    @Override
    public boolean debugPacketContent() {
        return false;
    }

    public class Resp {
        public String message;
        public int messageId;
    }
}
