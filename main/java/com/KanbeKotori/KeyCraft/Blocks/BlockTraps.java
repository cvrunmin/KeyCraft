/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.KanbeKotori.KeyCraft.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import com.KanbeKotori.KeyCraft.Helper.RewriteHelper;

import cpw.mods.fml.relauncher.*;

public abstract class BlockTraps extends Block {
	
	protected EntityLivingBase owner;
	protected IIcon icon;

	protected BlockTraps(EntityLivingBase layer) {
		super(Material.rock);
		this.owner = layer;
	}
	
	/** �����鱻����ʱ���ô˷����� */
	@Override
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase entity, ItemStack stack) {}
	
	/** ��ʵ���߹�����ʱ���ô˷����� */
	@Override
    public void onEntityWalking(World world, int posX, int posY, int posZ, Entity entity) {}
	
	/** �����鱻�һ�ʱ���ô˷����� */
    public boolean onBlockActivated(World world, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
    	ItemStack held = player.getHeldItem();
		if (player.equals(this.owner) && held != null) {
			Block block = Block.getBlockFromItem(held.getItem());
			if (block != null) {
				int metadata = held.getItem().getMetadata(held.getItemDamage());
				this.icon = block.getIcon(1, metadata);
			}
		}
    	return false;
    }
    
    /** ��ȡ������ʡ� */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
    	if (this.icon != null) {
    		return this.icon;
    	}
        return this.blockIcon;
    }

}