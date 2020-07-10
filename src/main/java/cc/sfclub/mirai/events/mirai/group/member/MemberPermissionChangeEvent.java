package cc.sfclub.mirai.events.mirai.group.member;

import cc.sfclub.mirai.packets.received.sender.MiraiSender;
import lombok.Getter;

@Getter
public class MemberPermissionChangeEvent implements MemberEvent {
    private String origin;
    private String current;
    private MiraiSender member;
}