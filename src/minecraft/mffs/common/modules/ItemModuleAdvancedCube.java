package mffs.common.modules;

import java.util.Set;

import mffs.api.PointXYZ;
import mffs.common.IModularProjector;
import mffs.common.ModularForceFieldSystem;
import mffs.common.options.ItemOptionBase;
import mffs.common.options.ItemOptionCutter;
import mffs.common.options.ItemOptionCamoflage;
import mffs.common.options.ItemOptionDefenseStation;
import mffs.common.options.ItemOptionFieldFusion;
import mffs.common.options.ItemOptionFieldManipulator;
import mffs.common.options.ItemOptionJammer;
import mffs.common.options.ItemOptionAntibiotic;
import mffs.common.options.ItemOptionSponge;
import mffs.common.tileentity.TileEntityProjector;
import net.minecraft.item.Item;

public class ItemModuleAdvancedCube extends ItemModule3DBase
{
	public ItemModuleAdvancedCube(int i)
	{
		super(i, "moduleAdvancedCube");
		setIconIndex(55);
	}

	public boolean supportsDistance()
	{
		return false;
	}

	public boolean supportsStrength()
	{
		return true;
	}

	public boolean supportsMatrix()
	{
		return true;
	}

	public void calculateField(IModularProjector projector, Set ffLocs, Set ffInterior)
	{
		int tpx = 0;
		int tpy = 0;
		int tpz = 0;

		int xMout = projector.countItemsInSlot(IModularProjector.Slots.FocusLeft);
		int xPout = projector.countItemsInSlot(IModularProjector.Slots.FocusRight);
		int zMout = projector.countItemsInSlot(IModularProjector.Slots.FocusDown);
		int zPout = projector.countItemsInSlot(IModularProjector.Slots.FocusUp);
		int distance = projector.countItemsInSlot(IModularProjector.Slots.Distance);
		int Strength = projector.countItemsInSlot(IModularProjector.Slots.Strength) + 2;

		for (int y1 = 0; y1 <= Strength; y1++)
			for (int x1 = 0 - xMout; x1 < xPout + 1; x1++)
				for (int z1 = 0 - zPout; z1 < zMout + 1; z1++)
				{
					if (((TileEntityProjector) projector).getSide() == 0)
					{
						tpy = y1 - y1 - y1 + 1;
						tpx = x1;
						tpz = z1;
					}

					if (((TileEntityProjector) projector).getSide() == 1)
					{
						tpy = y1 - 1;
						tpx = x1;
						tpz = z1;
					}

					if (((TileEntityProjector) projector).getSide() == 2)
					{
						tpz = y1 - y1 - y1 + 1;
						tpy = z1 - z1 - z1;
						tpx = x1 - x1 - x1;
					}

					if (((TileEntityProjector) projector).getSide() == 3)
					{
						tpz = y1 - 1;
						tpy = z1 - z1 - z1;
						tpx = x1;
					}

					if (((TileEntityProjector) projector).getSide() == 4)
					{
						tpx = y1 - y1 - y1 + 1;
						tpy = z1 - z1 - z1;
						tpz = x1;
					}
					if (((TileEntityProjector) projector).getSide() == 5)
					{
						tpx = y1 - 1;
						tpy = z1 - z1 - z1;
						tpz = x1 - x1 - x1;
					}

					if ((y1 == 0) || (y1 == Strength) || (x1 == 0 - xMout) || (x1 == xPout) || (z1 == 0 - zPout) || (z1 == zMout))
					{
						if (((TileEntityProjector) projector).hasOption(ModularForceFieldSystem.itemOptionFieldManipulator, true))
						{
							switch (((TileEntityProjector) projector).getSide())
							{
								case 0:
									if (((TileEntityProjector) projector).yCoord + tpy <= ((TileEntityProjector) projector).yCoord)
										break;
									break;
								case 1:
									if (((TileEntityProjector) projector).yCoord + tpy >= ((TileEntityProjector) projector).yCoord)
										break;
									break;
								case 2:
									if (((TileEntityProjector) projector).zCoord + tpz <= ((TileEntityProjector) projector).zCoord)
										break;
									break;
								case 3:
									if (((TileEntityProjector) projector).zCoord + tpz >= ((TileEntityProjector) projector).zCoord)
										break;
									break;
								case 4:
								case 5:
									if (((TileEntityProjector) projector).xCoord + tpx > ((TileEntityProjector) projector).xCoord &&

									((TileEntityProjector) projector).xCoord + tpx < ((TileEntityProjector) projector).xCoord)
									{
										continue;
									}
							}
						}
						ffLocs.add(new PointXYZ(tpx, tpy, tpz, 0));
					}
					else
					{
						ffInterior.add(new PointXYZ(tpx, tpy, tpz, 0));
					}
				}
	}

	public static boolean supportsOption(ItemOptionBase item)
	{
		if ((item instanceof ItemOptionCamoflage))
			return true;
		if ((item instanceof ItemOptionDefenseStation))
			return true;
		if ((item instanceof ItemOptionFieldFusion))
			return true;
		if ((item instanceof ItemOptionFieldManipulator))
			return true;
		if ((item instanceof ItemOptionJammer))
			return true;
		if ((item instanceof ItemOptionAntibiotic))
			return true;
		if ((item instanceof ItemOptionSponge))
			return true;
		if ((item instanceof ItemOptionCutter))
			return true;

		return false;
	}

	public boolean supportsOption(Item item)
	{
		if ((item instanceof ItemOptionCamoflage))
			return true;
		if ((item instanceof ItemOptionDefenseStation))
			return true;
		if ((item instanceof ItemOptionFieldFusion))
			return true;
		if ((item instanceof ItemOptionFieldManipulator))
			return true;
		if ((item instanceof ItemOptionJammer))
			return true;
		if ((item instanceof ItemOptionAntibiotic))
			return true;
		if ((item instanceof ItemOptionSponge))
			return true;
		if ((item instanceof ItemOptionCutter))
			return true;

		return false;
	}
}