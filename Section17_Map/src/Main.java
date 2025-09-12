import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> votes = new HashMap<>();

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();
            while(line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer count = Integer.parseInt(fields[1]);

                if(votes.containsKey(name)) {
                    votes.put(name, votes.get(name) + count);
                } else {
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for(String key : votes.keySet()){
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        sc.close();
    }
}
