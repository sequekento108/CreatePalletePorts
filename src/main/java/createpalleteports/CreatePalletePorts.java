package createpalleteports;

import createpalleteports.init.CreatePalletePortsBlocks;
import createpalleteports.init.CreatePalletePortsTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreatePalletePorts.MODID)
public class CreatePalletePorts {

    public static final String MODID = "createpalleteports";

    public CreatePalletePorts(IEventBus modEventBus) {
        CreatePalletePortsBlocks.BLOCKS.register(modEventBus);
        CreatePalletePortsBlocks.ITEMS.register(modEventBus);
        CreatePalletePortsTabs.TABS.register(modEventBus);

        modEventBus.addListener(CreatePalletePortsBlocks::setupClient);
        modEventBus.addListener(CreatePalletePortsBlocks::registerBlockColors);
        modEventBus.addListener(CreatePalletePortsBlocks::registerItemColors);
    }
}
