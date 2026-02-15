package com.thizthizzydizzy.treefeller.compat;
import com.thizthizzydizzy.treefeller.Modifier;
import com.thizthizzydizzy.treefeller.Tool;
import com.thizthizzydizzy.treefeller.Tree;
import com.thizthizzydizzy.treefeller.TreeFeller;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public class Prism4Compat extends InternalCompatibility{
    @Override
    public String getPluginName(){
        return "prism";
    }
    @Override
    public String getPluginPackageFilter(){
        return "org.prism_mc.prism";
    }
    @Override
    public String getCompatibilityName(){
        return "Prism 4";
    }
    @Override
    public void init(TreeFeller treeFeller){
        Prism4Compat2.init(getPlugin());
    }
    @Override
    public void addBlock(Player player, Block block, BlockState was){
        Prism4Compat2.addBlock(player, block, was);
    }
    @Override
    public void breakBlock(Tree tree, Tool tool, Player player, ItemStack axe, Block block, List<Modifier> modifiers){
        Prism4Compat2.breakBlock(tree, tool, player, axe, block, modifiers);
    }
    @Override
    public void dropItem(Player player, Item item){
        Prism4Compat2.dropItem(player, item);
    }
}
