public class Project {
    private String name;
    private String description;
    private double initialCost;

    public Project() {
    }
    public Project(String name){
        this.name = name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Project(String name, double initialCost, String description){
        this.name = name;
        this.initialCost = initialCost;
        this.description = description;
    }

    public void elevatorPitch(){
        System.out.println(name + " ("+initialCost+"): "+description);
    }
    public void setName(String name){
        this.name = name;

    public void setDescription(String description){
        this.description = description;
    }

    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }
    // returns the name of project
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getInitialCost() {
        return initialCost;
    }
}