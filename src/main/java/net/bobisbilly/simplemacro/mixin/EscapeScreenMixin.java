package net.bobisbilly.simplemacro.mixin;

import net.bobisbilly.simplemacro.SimpleMacros;
import net.bobisbilly.simplemacro.screen.MacroScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextIconButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
class EscapeScreenMixin extends Screen {
    protected EscapeScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "initWidgets")
    private void addMacroButton(CallbackInfo ci) {
        this.addDrawableChild(TextIconButtonWidget.builder(Text.literal("Macros"), (button -> {
                    assert this.client != null;
                    this.client.setScreen(new MacroScreen(Text.literal("Macros"), this));
                }), true)
                .width(20)
                .texture(Identifier.of(SimpleMacros.MOD_ID, "icon/macro"), 6, 11)
                .build()).setPosition(this.width / 2 + 106, 68);
    }
}
