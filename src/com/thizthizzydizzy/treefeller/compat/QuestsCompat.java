package com.thizthizzydizzy.treefeller.compat;
import com.leonardobishop.quests.bukkit.BukkitQuestsPlugin;
import com.leonardobishop.quests.bukkit.tasktype.type.MiningTaskType;
import com.thizthizzydizzy.treefeller.Modifier;
import com.thizthizzydizzy.treefeller.Tool;
import com.thizthizzydizzy.treefeller.Tree;
import com.thizthizzydizzy.treefeller.TreeFeller;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
public class QuestsCompat extends InternalCompatibility{
    private BukkitQuestsPlugin quests;
    @Override
    public String getPluginName(){
        return "Quests";
    }
    @Override
    public void init(TreeFeller treefeller){
        quests = (BukkitQuestsPlugin)getPlugin();
    }
    @Override
    public void breakBlock(Tree tree, Tool tool, Player player, ItemStack axe, Block block, List<Modifier> modifiers){
        // There is a lot of internal logic, but it only uses the block/player from the event, so I can leave Quests to do the heavy lifting
        ((MiningTaskType)quests.getTaskTypeManager().getTaskType("blockbreak")).onBlockBreak(new BlockBreakEvent(block, player));
    }
}
