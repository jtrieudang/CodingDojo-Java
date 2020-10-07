import java.util.ArrayList;

public class Portfolio {
    ArrayList<Project> projects = new ArrayList<>();
    public void addProject(Project project) {
        this.projects.add(project);
    }

    public double getPortfolioCost() {
        double cost = 0;
        for(Project project: this.projects){
            cost += project.getInitialCost();
        }
        return cost;
    }

    public void showPortfolio(){
        System.out.println("Portfolio Projects:");
        for (Project project: this.projects){
            project.elevatorPitch();
        }
        System.out.println("Portfolio Cost: $"+getPortfolioCost());
    }
}