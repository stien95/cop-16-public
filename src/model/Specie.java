package model;

public class Specie {
    private String name;
    private String photo;
    private SpecieType type;
    private int numberOfSpecies;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public SpecieType getType() {
        return type;
    }
    public void setType(SpecieType type) {
        this.type = type;
    }
    public int getNumberOfSpecies() {
        return numberOfSpecies;
    }
    public void setNumberOfSpecies(int numberOfSpecies) {
        this.numberOfSpecies = numberOfSpecies;
    }
    @Override
    public String toString() {
        return "Especie:" + name + "\nTipo:" + type + "\nNumero de especies:" + numberOfSpecies;
    }
    
}
