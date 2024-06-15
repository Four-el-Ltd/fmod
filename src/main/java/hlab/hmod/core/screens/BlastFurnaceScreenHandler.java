package hlab.hmod.core.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class BlastFurnaceScreenHandler extends AbstractRecipeScreenHandler {
    private Inventory inventory;
    protected BlastFurnaceScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Override
    public void populateRecipeFinder(RecipeMatcher finder) {

    }

    @Override
    public void clearCraftingSlots() {

    }

    @Override
    public int getCraftingResultSlotIndex() {
        return 0;
    }

    @Override
    public int getCraftingWidth() {
        return 0;
    }

    @Override
    public int getCraftingHeight() {
        return 0;
    }

    @Override
    public int getCraftingSlotCount() {
        return 0;
    }

    @Override
    public RecipeBookCategory getCategory() {
        return null;
    }

    @Override
    public boolean canInsertIntoSlot(int index) {
        return false;
    }

    @Override
    public boolean matches(RecipeEntry recipe) {
        return false;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
