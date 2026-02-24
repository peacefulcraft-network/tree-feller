package com.thizthizzydizzy.treefeller;
import org.bukkit.inventory.ItemStack;
@Deprecated // see DROP_CONVERSIONS in Option
public class FancyItemStack{
    public ItemStack stack;
    public String nbt;
    public FancyItemStack(ItemStack stack){
        this.stack = stack;
    }
    public FancyItemStack(ItemStack stack, String nbt){
        this.stack = stack;
        this.nbt = nbt;
    }
}
