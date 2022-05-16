package MP;


public class StudentDBDemo {
    public static void main(String[] args) {

        StudentDB sdb = new StudentDB();
        
        App app = new App();
        app.initialize(args, sdb);
    }
}
