package com.danieli1818.minecraftmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityWingedHorse extends AbstractHorse implements EntityFlying {

    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    
    private boolean isFlying;
	
	public EntityWingedHorse(World worldIn) {
		super(worldIn);
		this.moveHelper = new EntityFlyHelper(this);
		this.isFlying = false;
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.4000000059604645D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }
	
	private void calculateFlapping()
    {
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed = (float)((double)this.flapSpeed + (double)(this.onGround ? -1 : 4) * 0.3D);
        this.flapSpeed = MathHelper.clamp(this.flapSpeed, 0.0F, 1.0F);

        if (!this.onGround && this.flapping < 1.0F)
        {
            this.flapping = 1.0F;
        }

        this.flapping = (float)((double)this.flapping * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.flap += this.flapping * 2.0F;
    }
	
	/**
     * Returns new PathNavigateGround instance
     */
    protected PathNavigate createNavigator(World worldIn)
    {
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }
    
    public boolean isFlying()
    {
//        return !this.onGround;
    	return this.isFlying;
    }
    
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = !itemstack.isEmpty();

        if (flag && itemstack.getItem() == Items.SPAWN_EGG)
        {
            return super.processInteract(player, hand);
        }
        else
        {
            if (!this.isChild())
            {
                if (this.isTame() && player.isSneaking())
                {
                    this.openGUI(player);
                    return true;
                }

                if (this.isBeingRidden())
                {
                    return super.processInteract(player, hand);
                }
            }

            if (flag)
            {
                if (this.handleEating(player, itemstack))
                {
                    if (!player.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
                    }

                    return true;
                }

                if (itemstack.interactWithEntity(player, this, hand))
                {
                    return true;
                }

                if (!this.isTame())
                {
                    this.makeMad();
                    return true;
                }

                boolean flag1 = HorseArmorType.getByItemStack(itemstack) != HorseArmorType.NONE;
                boolean flag2 = !this.isChild() && !this.isHorseSaddled() && itemstack.getItem() == Items.SADDLE;

                if (flag1 || flag2)
                {
                    this.openGUI(player);
                    return true;
                }
            }

            if (this.isChild())
            {
                return super.processInteract(player, hand);
            }
            else
            {
                this.mountTo(player);
                return true;
            }
        }
    }
    
    /*
    public void travel(float strafe, float vertical, float forward)
    {
        if (this.isBeingRidden() && this.canBeSteered() && this.isHorseSaddled())
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
            this.rotationYaw = entitylivingbase.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.renderYawOffset;
            strafe = entitylivingbase.moveStrafing * 0.5F;
            forward = entitylivingbase.moveForward;
            super.travel(strafe, vertical, forward);
        }
        else
        {
            this.jumpMovementFactor = 0.02F;
            super.travel(strafe, vertical, forward);
        }
    }
    */
    
    @Override
    public void onUpdate() {
    	// TODO Auto-generated method stub
//    	if (this.onGround) {
//    		this.isFlying = false;
//    	}
    	super.onUpdate();
    }
    
    @Override
    public void travel(float strafe, float vertical, float forward) {
    	// TODO Auto-generated method stub
    	if (this.isBeingRidden() && this.canBeSteered() && this.isHorseSaddled()) {
    		if (this.jumpPower >= 1.0F && !this.isHorseJumping() && this.onGround) {
    			
    			super.travel(strafe, vertical, forward);
    			setFlying(true);
    			
//                this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;
//
//                if (this.isPotionActive(MobEffects.JUMP_BOOST))
//                {
//                    this.motionY += (double)((float)(this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
//                }
//
//                this.setHorseJumping(true);
//                this.isAirBorne = true;
//                this.isFlying = true;
//
//                if (forward > 0.0F)
//                {
//                    float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
//                    float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
//                    float f2 = MathHelper.sin(this.rotationPitch * 0.017453292F);
//                    this.motionX += (double)(-0.4F * f * this.jumpPower);
//                    this.motionZ += (double)(0.4F * f1 * this.jumpPower);
//                    this.motionY += (double)(0.4F * f2 * this.jumpPower);
////                    this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
//                }
//
//                this.jumpPower = 0.0F;
    		} else if (this.isFlying()) {
//    			if (forward > 0.0F)
//                {
//                    float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
//                    float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
//                    float f2 = MathHelper.sin(this.rotationPitch * 0.017453292F);
//                    this.motionX += (double)(-0.4F * f * forward);
//                    this.motionZ += (double)(0.4F * f1 * forward);
//                    this.motionY += (double)(0.4F * f2 * forward);
//                    
////                    this.moveRelative(strafe, up, forward, friction);
////                    this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
//                }
    			
    			flyingTravel(strafe, vertical, forward);
    			
//    			Entity controlPassenger = this.getControllingPassenger();
//    			if (controlPassenger instanceof EntityPlayer) {
//    				EntityPlayer player = (EntityPlayer)controlPassenger;
//    				float f = MathHelper.sin(player.cameraYaw * 0.017453292F);
//    				float f1 = MathHelper.cos(player.cameraYaw * 0.017453292F);
//    				float f2 = MathHelper.sin(player.cameraPitch * 0.017453292F);
//    				this.motionX += (double)(-0.4F * f * this.jumpPower);
//                    this.motionZ += (double)(0.4F * f1 * this.jumpPower);
//                    this.motionY += (double)(0.4F * f2 * this.jumpPower);
//                    this.setVelocity(this.motionX, this.motionY, this.motionZ);
////    				this.move(MoverType.SELF, this.posX + f, this.posY + f2, this.posZ + f1);
////    				this.moveRelative(f, f2, f1, 10);
////    				super.travel(f, f2, f1);
////    				super.travel(strafe, player.cameraPitch, forward);
//    			}
    			
//    			float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
//                float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
//                float f2 = MathHelper.sin(this.rotationPitch * 0.017453292F);
//                this.motionX += (double)(-0.4F * f * this.jumpPower);
//                this.motionZ += (double)(0.4F * f1 * this.jumpPower);
//                this.motionY += (double)(0.4F * f2 * this.jumpPower);
//    			super.travel(strafe, 1.0F, forward);
    		} else {
    			super.travel(strafe, vertical, forward);
    		}
    	} else {
    		super.travel(strafe, vertical, forward);
    	}
    }
    
    private void setFlying(boolean isFlying) {
    	if (isFlying) {
    		this.isFlying = true;
    		this.fallDistance = 0.0F;
    	} else {
    		this.isFlying = false;
    	}
    }
    
    private void flyingTravel(float strafe, float vertical, float forward) {
    	EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
        this.rotationYaw = entitylivingbase.rotationYaw;
        this.prevRotationYaw = this.rotationYaw;
        this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
        this.setRotation(this.rotationYaw, this.rotationPitch);
        this.renderYawOffset = this.rotationYaw;
        this.rotationYawHead = this.renderYawOffset;
        strafe = entitylivingbase.moveStrafing * 0.5F;
        forward = entitylivingbase.moveForward;
        vertical = entitylivingbase.moveVertical * 0.5F;

        if (forward <= 0.0F)
        {
            forward *= 0.25F;
            this.gallopTime = 0;
        }

        if (this.onGround && this.jumpPower == 0.0F && this.isRearing()) //  && !this.allowStandSliding
        {
            strafe = 0.0F;
            forward = 0.0F;
        }

        if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround)
        {
            this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;

            if (this.isPotionActive(MobEffects.JUMP_BOOST))
            {
                this.motionY += (double)((float)(this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
            }

            this.setHorseJumping(true);
            this.isAirBorne = true;

            if (forward > 0.0F)
            {
                float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
                float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
                this.motionX += (double)(-0.4F * f * this.jumpPower);
                this.motionZ += (double)(0.4F * f1 * this.jumpPower);
                this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4F, 1.0F);
            }

            this.jumpPower = 0.0F;
        }

        this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

        if (this.canPassengerSteer())
        {
            this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
            super.travel(strafe, vertical, forward);
        }
        else if (entitylivingbase instanceof EntityPlayer)
        {
            this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
        }

        if (this.onGround)
        {
            this.jumpPower = 0.0F;
            this.setHorseJumping(false);
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

}
