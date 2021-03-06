package mffs.common.card;

import java.util.List;

import mffs.api.IForceEnergyItems;
import mffs.api.IPowerLinkItem;
import mffs.common.item.ItemMFFS;
import mffs.common.tileentity.TileEntityMFFS;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCardPower extends ItemMFFS implements IPowerLinkItem, IForceEnergyItems
{
	public ItemCardPower(int id)
	{
		super(id, "cardPower");
		setMaxStackSize(1);
		setIconIndex(21);
	}

	public int getPercentageCapacity(ItemStack itemStack, TileEntityMFFS tem, World world)
	{
		return 100;
	}

	public int getAvailablePower(ItemStack itemStack, TileEntityMFFS tem, World world)
	{
		return 10000000;
	}

	public int getMaximumPower(ItemStack itemStack, TileEntityMFFS tem, World world)
	{
		return 10000000;
	}

	public boolean consumePower(ItemStack itemStack, int powerAmount, boolean simulation, TileEntityMFFS tem, World world)
	{
		return true;
	}

	public boolean insertPower(ItemStack itemStack, int powerAmount, boolean simulation, TileEntityMFFS tem, World world)
	{
		return false;
	}

	public int getPowersourceID(ItemStack itemStack, TileEntityMFFS tem, World world)
	{
		return 0;
	}

	public int getfreeStorageAmount(ItemStack itemStack, TileEntityMFFS tem, World world)
	{
		return 0;
	}

	public boolean isPowersourceItem()
	{
		return true;
	}

	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b)
	{
		info.add("Admin Card to Power Maschines");
		info.add("or use to infinit charge Capactior");
	}

	public int getAvailablePower(ItemStack itemStack)
	{
		return getAvailablePower(itemStack, null, null);
	}

	public int getMaximumPower(ItemStack itemStack)
	{
		return getMaximumPower(itemStack, null, null);
	}

	public boolean consumePower(ItemStack itemStack, int powerAmount, boolean simulation)
	{
		return true;
	}

	public void setAvailablePower(ItemStack itemStack, int amount)
	{
	}

	public int getPowerTransferrate()
	{
		return 1000000;
	}

	public int getItemDamage(ItemStack stackInSlot)
	{
		return 0;
	}
}