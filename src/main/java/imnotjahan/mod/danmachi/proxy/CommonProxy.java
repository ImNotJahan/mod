package imnotjahan.mod.danmachi.proxy;

import imnotjahan.mod.danmachi.Main;
import imnotjahan.mod.danmachi.capabilities.IStatus;
import imnotjahan.mod.danmachi.capabilities.Status;
import imnotjahan.mod.danmachi.capabilities.StatusStorage;
import imnotjahan.mod.danmachi.util.handlers.GuiHandler;
import imnotjahan.mod.danmachi.util.handlers.CapabilityHandler;
import imnotjahan.mod.danmachi.util.handlers.EventHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy
{
    public void registerItemRenderer(Item item, int meta) {}

    public void preInit()
    {

    }

    public void init()
    {
        CapabilityManager.INSTANCE.register(IStatus.class, new StatusStorage(), Status::new);

        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());

        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }
}
