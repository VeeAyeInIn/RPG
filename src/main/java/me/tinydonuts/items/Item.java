package me.tinydonuts.items;

public abstract class Item {

    private Material primaryMaterial;
    private Material secondaryMaterial;
    private Material tertiaryMaterial;

    public Item(Material primaryMaterial) {
        this.primaryMaterial = primaryMaterial;
    }

    public Item(Material primaryMaterial, Material secondaryMaterial) {
        this.primaryMaterial = primaryMaterial;
        this.secondaryMaterial = secondaryMaterial;
    }

    public Item(Material primaryMaterial, Material secondaryMaterial, Material tertiaryMaterial) {
        this.primaryMaterial = primaryMaterial;
        this.secondaryMaterial = secondaryMaterial;
        this.tertiaryMaterial = tertiaryMaterial;
    }

    public boolean hasSecondaryMaterial() {
        return secondaryMaterial != null;
    }

    public boolean hasTertiaryMaterials() {
        return tertiaryMaterial != null;
    }

    public void setPrimaryMaterial(Material primaryMaterial) {
        this.primaryMaterial = primaryMaterial;
    }

    public void setSecondaryMaterial(Material secondaryMaterial) {
        this.secondaryMaterial = secondaryMaterial;
    }

    public void setTertiaryMaterial(Material tertiaryMaterial) {
        this.tertiaryMaterial = tertiaryMaterial;
    }

    public Material getPrimaryMaterial() {
        return primaryMaterial;
    }

    public Material getSecondaryMaterial() {
        return secondaryMaterial;
    }

    public Material getTertiaryMaterial() {
        return tertiaryMaterial;
    }
}
