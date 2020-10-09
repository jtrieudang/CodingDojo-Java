public class ProjectTest{
    public static void main (String[] args){
        Project project = new Project();
        Project project2 = new Project("Project #2");
        
        Portfolio portfolio = new Portfolio();

        project.setName("Project");
        project.setDescription("Description.");
        project.setInitialCost(10);
        portfolio.addProject(project);
        portfolio.addProject(project2);

        portfolio.showPortfolio();
    }
}