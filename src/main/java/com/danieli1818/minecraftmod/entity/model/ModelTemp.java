package com.danieli1818.minecraftmod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelHorse - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTemp extends ModelBase {
    public ModelRenderer wingLeft;
    public ModelRenderer wingRight;

    public ModelTemp() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.wingRight = new ModelRenderer(this, 19, 80);
        this.wingRight.setRotationPoint(-6.0F, 10.0F, -2.76F);
        this.wingRight.addBox(-0.5F, -9.0F, -7.5F, 1, 21, 9, 0.0F);
        this.setRotateAngle(wingRight, -0.6981317007977318F, -3.141592653589793F, 0.08726646259971647F);
        this.wingLeft = new ModelRenderer(this, 19, 80);
        this.wingLeft.setRotationPoint(6.0F, 10.0F, -2.76F);
        this.wingLeft.addBox(-0.5F, -9.0F, -7.5F, 1, 21, 9, 0.0F);
        this.setRotateAngle(wingLeft, -0.6981317007977318F, -3.141592653589793F, -0.08726646259971647F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.wingRight.render(f5);
        this.wingLeft.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
