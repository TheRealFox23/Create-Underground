public class custom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart Table;

	public custom_model(ModelPart root) {
		this.Table = root.getChild("Table");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Table = partdefinition.addOrReplaceChild("Table", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 32.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -15.0F, -8.0F, 1.0F, 15.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Leg2 = Table.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 0).addBox(23.0F, -15.0F, 6.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(22.0F, -15.0F, 7.0F, 2.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Leg1 = Table.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 0).addBox(22.0F, -15.0F, -8.0F, 2.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(23.0F, -15.0F, -7.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Lamp = Table.addOrReplaceChild("Lamp", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Lamp.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, -25.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.0F, -26.0F, 2.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.1781F, 0.0F));

		PartDefinition cube_r2 = Lamp.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -25.0F, 6.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -17.0F, 4.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Table.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
