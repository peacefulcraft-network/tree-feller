package com.thizthizzydizzy.treefeller.compat;

import com.thizthizzydizzy.treefeller.*;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BlockRegenCompat2 extends InternalCompatibility{
    @Override
    public String getPluginName(){
        return "BlockRegen";
    }
    @Override
    public String getCompatibilityName(){
        return "blockregen-v3.25+";
    }

    @Override
    public void breakBlock(Tree tree, Tool tool, Player player, ItemStack axe, Block block, List<Modifier> modifiers){
        nl.aurorion.blockregen.BlockRegenPlugin brPlugin = nl.aurorion.blockregen.BlockRegenPlugin.getInstance();

        boolean useRegions = brPlugin.getConfig().getBoolean("Use-Regions", false);
        nl.aurorion.blockregen.region.struct.RegenerationArea area = useRegions?brPlugin.getRegionManager().getArea(block):null;
        
        if(area==null)return;

        nl.aurorion.blockregen.preset.BlockPreset preset = brPlugin.getPresetManager().getPreset(block, area);
        
        if(preset==null)return;
        
        nl.aurorion.blockregen.regeneration.struct.RegenerationProcess proc = brPlugin.getRegenerationManager().createProcess(block, preset, area);
        
        proc.start();
    }

    @Override
    public boolean defaultEnabled(){
        return false;
    }
}
