package zmaster587.advancedRocketry.item;

import zmaster587.libVulpes.LibVulpes;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemAsteroidChip  extends ItemMultiData {

	private static final String uuidIdentifier = "UUID";
	private static final String astType = "astype";
	public ItemAsteroidChip() {
	}

	@Override
	public boolean isDamageable() {
		return false;
	}


	/**
	 * Removes any Information and reset the stack to a default state
	 * @param stack stack to erase
	 */
	public void erase(ItemStack stack) {
		stack.setTagCompound(null);
	}

	public Long getUUID(ItemStack stack) {
		if(stack.hasTagCompound())
			return stack.getTagCompound().getLong(uuidIdentifier);
		return null;
	}

	public void setUUID(ItemStack stack, long uuid) {
		NBTTagCompound nbt;
		if(stack.hasTagCompound())
			nbt = stack.getTagCompound();
		else
			nbt = new NBTTagCompound();

		nbt.setLong(uuidIdentifier,uuid);
		stack.setTagCompound(nbt);
	}
	
	public String getType(ItemStack stack) {
		if(stack.hasTagCompound())
			return stack.getTagCompound().getString(astType);
		return null;
	}

	public void setType(ItemStack stack, String type) {
		NBTTagCompound nbt;
		if(stack.hasTagCompound())
			nbt = stack.getTagCompound();
		else
			nbt = new NBTTagCompound();

		nbt.setString(astType,type);
		stack.setTagCompound(nbt);
	}

	@Override
	public void addInformation(ItemStack stack, World player, java.util.List list, ITooltipFlag bool) {

		if(!stack.hasTagCompound()) {
			list.add(LibVulpes.proxy.getLocalizedString("msg.unprogrammed"));
		}
		else {
			if(stack.getItemDamage()  == 0) {

				list.add(LibVulpes.proxy.getLocalizedString("msg.asteroidChip.asteroid") + "-" + ChatFormatting.DARK_GREEN  + getUUID(stack));

				super.addInformation(stack, player, list, bool);

				//list.add("Mass: " + unknown);
				//list.add("Atmosphere Density: " + unknown);
				//list.add("Distance From Star: " + unknown);

			}
		}
	}

}
