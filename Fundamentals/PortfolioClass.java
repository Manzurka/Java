import java.util.ArrayList;
public class PortfolioClass(){
        public void objectMethods(ProjectClass anotherObject) {
        ArrayList<String> projects = new ArrayList<String>();
        projects.add(this.getClass());
        System.out.println(projects);
    }
}
    // public void objectMethods(ProjectClass anotherObject) {
        
    //     String project = this.toString();
      
    //     System.out.println(project);
//  ArrayList<String> projects = new ArrayList<String>();
//         ProjectClass projecta = new ProjectClass("Sustainability", "How to build a sustainable business", 1898.78);
//         ProjectClass.objectMethods
//         // projects.add(ProjectClass project2);
//         // projects.add(ProjectClass project3);
//         System.out.println(projects);

