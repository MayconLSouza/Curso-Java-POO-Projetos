import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();

        System.out.print("How many students for course A? ");
        int studentsA = sc.nextInt();

        for(int i = 0; i < studentsA; i++) {
            set.add(sc.nextInt());
            sc.nextLine();
        }

        System.out.print("How many students for course B? ");
        int studentsB = sc.nextInt();

        for(int i = 0; i < studentsB; i++) {
            set.add(sc.nextInt());
            sc.nextLine();
        }

        System.out.print("How many students for course C? ");
        int studentsC = sc.nextInt();

        for(int i = 0; i < studentsC; i++) {
            set.add(sc.nextInt());
            sc.nextLine();
        }

        System.out.println("Total students: " + set.size());

        sc.close();

    }
}
