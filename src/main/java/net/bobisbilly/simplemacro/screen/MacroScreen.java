package net.bobisbilly.simplemacro.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;

public class MacroScreen extends Screen {
    public Screen parent;
    private TextFieldWidget searchBox;

    public MacroScreen(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    protected void init() {
        searchBox = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, 22, 200, 20, this.searchBox, Text.literal("Search Macros"));
        this.searchBox.setChangedListener(System.out::println);
        this.searchBox.setPlaceholder(Text.literal("Search Macros"));
        this.addSelectableChild(this.searchBox);

        this.addDrawableChild(
                ButtonWidget.builder(Text.literal("Create Macro"), button -> {
                    System.out.println("This doesn't work yet.");
                }).dimensions(this.width / 2 - 154, this.height - 40, 150, 20).build()
        );

        this.addDrawableChild(
                ButtonWidget.builder(ScreenTexts.BACK, button -> {
                    assert this.client != null;
                    this.client.setScreen(this.parent);
                }).dimensions(this.width / 2 + 4, this.height - 40, 150, 20).build()
        );
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.searchBox.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 8, 16777215);
    }
}
