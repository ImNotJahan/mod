package imnotjahan.mod.danmachi.network;

import imnotjahan.mod.danmachi.util.ClientThings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>{

    @Override
    public REQ onMessage(REQ message, MessageContext ctx){
        if(ctx.side == Side.SERVER)
        {
            handleServerSide(message, ctx.getServerHandler().player);
        } else
        {
            EntityPlayer player = ClientThings.getPlayer();
            if(player != null)
            {
                handleClientSide(message, player);
            }
        }
        return null;
    }

    public abstract void handleClientSide(REQ message, EntityPlayer player);

    public abstract void handleServerSide(REQ message, EntityPlayer player);
}
