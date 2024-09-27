package model;

import java.util.Arrays;

class Community {
    private String name;
    private CommunityType type;
    private CommunityRepresentative representative;
    private CommunityProblem[] problems;
    private int population;
    
    public Community(String name, CommunityType type, CommunityRepresentative representative,
            CommunityProblem[] problems, int population) {
        this.name = name;
        this.type = type;
        this.representative = representative;
        this.problems = problems;
        this.population = population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CommunityType getType() {
        return type;
    }
    public void setType(CommunityType type) {
        this.type = type;
    }
    public CommunityRepresentative getRepresentative() {
        return representative;
    }
    public void setRepresentative(CommunityRepresentative representative) {
        this.representative = representative;
    }
    public CommunityProblem[] getProblems() {
        return problems;
    }
    public void setProblems(CommunityProblem[] problems) {
        this.problems = problems;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    @Override
    public String toString() {
        return "Comunidad:" + name + "\nTipo:" + type + "\nRepresentante:" + representative + "\nProblemas:"
                + Arrays.toString(problems) + "\nPoblacion:" + population;
    }
     
    
}