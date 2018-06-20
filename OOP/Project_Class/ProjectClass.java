
public class ProjectClass {
    private String name;
    private String description;
    private double initialCost;

    public void setProject() {
        name ="default";
        description = "default";
        initialCost = 0.0;
    } //setter 
  
    public void setProject(String name) {
        this.name = name;
        this.description="default";
        this.initialCost = 0.0;
    } //setter

    public void setProject(String name, String description, double cost) {
         this.name = name;
         this.description = description;
         this.initialCost = cost;
    } //setter

    public String getProjectName() {
        return name;
    } //getter

    public String getProjectDescription() {
        return description;
    } //getter

    public String getProjectCost() {
        return Double.toString(initialCost);
    } //getter

    public String elevatorPitch() {
        return name + "(" + initialCost + ") :" + description;
    } // getter

}

