package com.asfhen.terracraft;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class TerracraftGroup extends ItemGroup{

    public TerracraftGroup(String label){
        super (label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.APPLE);
    }
}