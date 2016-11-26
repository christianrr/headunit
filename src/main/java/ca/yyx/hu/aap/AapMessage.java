package ca.yyx.hu.aap;


import ca.yyx.hu.aap.protocol.Channel;
import ca.yyx.hu.utils.ByteArray;

/**
 * @author algavris
 * @date 04/10/2016.
 */
class AapMessage {

    final byte[] data;
    final int length;
    final int channel;
    final byte flags;
    final int type;
    final int dataOffset;

    AapMessage(int channel, byte flags, int msg_type, int dataOffset, ByteArray ba) {
        this.data = ba.data;
        this.length = ba.length;
        this.channel = channel;
        this.flags = flags;
        this.type = msg_type;
        this.dataOffset = dataOffset;
    }

    public boolean isAudio() {
        return Channel.isAudio(this.channel);
    }

    public boolean isVideo() {
        return this.channel == Channel.AA_CH_VID;
    }
}