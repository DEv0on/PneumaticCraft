package pneumaticCraft.common.sensor.pollSensors;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.util.Rectangle;

import pneumaticCraft.api.universalSensor.IBlockAndCoordinatePollSensor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPresenceSensor implements IBlockAndCoordinatePollSensor{

    @Override
    public String getSensorPath(){
        return "blockTracker_gpsTool/Block/Presence";
    }

    @Override
    public int getPollFrequency(){
        return 2;
    }

    @Override
    public boolean needsTextBox(){
        return false;
    }

    @Override
    public List<String> getDescription(){
        List<String> text = new ArrayList<String>();
        text.add(EnumChatFormatting.BLACK + "Emits a redstone signal if there's a block (no air) at the location stored in the GPS Tool.");
        return text;
    }

    @Override
    public int getRedstoneValue(World world, int x, int y, int z, int sensorRange, String textBoxText, int toolX, int toolY, int toolZ){
        return world.isAirBlock(toolX, toolY, toolZ) ? 0 : 15;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void drawAdditionalInfo(FontRenderer fontRenderer){}

    @Override
    public Rectangle needsSlot(){
        return null;
    }
}