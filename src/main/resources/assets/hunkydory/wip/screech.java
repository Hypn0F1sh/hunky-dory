// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class the_screech<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "the_screech"), "main");
	private final ModelPart Head;
	private final ModelPart Torso;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;

	public the_screech(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -6.0F, -3.0F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -9.0F, 0.0F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(28, 25).addBox(-5.0F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-1.0F, -4.0F, -2.0F, 6.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -4.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 29).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -7.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(8, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 4.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}