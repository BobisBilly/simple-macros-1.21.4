package net.bobisbilly.simplemacro.mixin;

import net.bobisbilly.simplemacro.SimpleMacros;
import net.bobisbilly.simplemacro.screen.MacroScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.TextIconButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "addNormalWidgets")
    private void addMacroButton(int y, int spacingY, CallbackInfoReturnable<Integer> cir) {
        this.addDrawableChild(TextIconButtonWidget.builder(Text.literal("Macros"), (button -> {
                    assert this.client != null;
                    this.client.setScreen(new MacroScreen(Text.literal("Macros"), this));
                }), true)
                .width(20)
                .texture(Identifier.of(SimpleMacros.MOD_ID, "icon/macro"), 6, 11)
                .build()).setPosition(this.width / 2 + 104, y);
    }
}