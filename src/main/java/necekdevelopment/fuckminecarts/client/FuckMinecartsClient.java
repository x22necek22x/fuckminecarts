package necekdevelopment.fuckminecarts.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ActionResult;

import java.util.Set;

public class FuckMinecartsClient implements ClientModInitializer {

    private static Set<EntityType> minecarts = Set.of(EntityType.CHEST_MINECART, EntityType.HOPPER_MINECART, EntityType.FURNACE_MINECART);

    @Override
    public void onInitializeClient() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if(minecarts.contains(entity.getType())) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
