package createpalleteports.init;

import createpalleteports.CreatePalletePorts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Custom creative tab holding every ported palette block.
 */
public class CreatePalletePortsTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreatePalletePorts.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PALETTE_PORTS_TAB =
            TABS.register("palette_ports", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.createpalleteports"))
                    .icon(() -> new ItemStack(CreatePalletePortsBlocks.GABBRO.get()))
                    .displayItems((params, output) -> {
                        // Vanilla-based families (granite, diorite, andesite) first, then the rest.
                        List<DeferredHolder<Item, ? extends Item>> vanillaBased = new ArrayList<>();
                        List<DeferredHolder<Item, ? extends Item>> rest = new ArrayList<>();
                        for (DeferredHolder<Item, ? extends Item> item : CreatePalletePortsBlocks.ITEMS.getEntries()) {
                            String path = item.getId().getPath();
                            if (path.contains("granite") || path.contains("diorite") || path.contains("andesite")) {
                                vanillaBased.add(item);
                            } else {
                                rest.add(item);
                            }
                        }
                        for (DeferredHolder<Item, ? extends Item> item : vanillaBased) {
                            output.accept(item.get());
                        }
                        for (DeferredHolder<Item, ? extends Item> item : rest) {
                            output.accept(item.get());
                        }
                    })
                    .build());
}
