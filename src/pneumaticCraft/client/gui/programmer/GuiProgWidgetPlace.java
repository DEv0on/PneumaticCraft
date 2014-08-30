package pneumaticCraft.client.gui.programmer;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.util.ForgeDirection;
import pneumaticCraft.client.gui.GuiProgrammer;
import pneumaticCraft.client.gui.widget.GuiRadioButton;
import pneumaticCraft.client.gui.widget.IGuiWidget;
import pneumaticCraft.common.PneumaticCraftUtils;
import pneumaticCraft.common.progwidgets.IProgWidget;
import pneumaticCraft.common.progwidgets.ProgWidgetPlace;

public class GuiProgWidgetPlace extends GuiProgWidgetDigAndPlace{

    public GuiProgWidgetPlace(IProgWidget widget, GuiProgrammer guiProgrammer){
        super(widget, guiProgrammer);
    }

    @Override
    public void initGui(){
        super.initGui();
        List<GuiRadioButton> radioButtons = new ArrayList<GuiRadioButton>();
        for(int i = 0; i < 6; i++) {
            GuiRadioButton radioButton = new GuiRadioButton(i + 10, guiLeft + 4, guiTop + 80 + i * 12, 0xFF000000, PneumaticCraftUtils.getOrientationName(ForgeDirection.getOrientation(i)));
            radioButton.checked = ((ProgWidgetPlace)widget).placeDir.ordinal() == i;
            addWidget(radioButton);
            radioButtons.add(radioButton);
            radioButton.otherChoices = radioButtons;
        }
    }

    @Override
    public void actionPerformed(IGuiWidget guiWidget){
        if(guiWidget.getID() >= 10 && guiWidget.getID() < 16) ((ProgWidgetPlace)widget).placeDir = ForgeDirection.getOrientation(guiWidget.getID() - 10);
        super.actionPerformed(guiWidget);
    }

}
