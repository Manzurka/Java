
public class ProjectClassTest {
    public static void main(String[] args){
        ProjectClass project = new ProjectClass();
        project.setProject();
        ProjectClass project2 = new ProjectClass();
        project2.setProject("Superfoods");
        ProjectClass project3 = new ProjectClass();
        project3.setProject("Sustainability", "How to build a sustainable business", 1898.78);
        System.out.println(project3.getProjectName());
        System.out.println(project3.getProjectDescription());
        System.out.println(project3.elevatorPitch());
        System.out.println(project3.getProjectCost());
    }
}