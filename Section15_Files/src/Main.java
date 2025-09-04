import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Item {
        String nome;
        double preco;
        int quantidade;

        public Item(String nome, double preco, int quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        }

        public double getTotal() {
            return preco * quantidade;
        }
    }

    public static void main(String[] args) throws Exception {

        String inputPath = "C:\\temp\\in.csv";
        String outputDir = "C:\\temp\\out";
        String outputPath = outputDir + "\\summary.csv";

        List<Item> itens = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { 
                    String[] parts = line.split(",");
                    String nome = parts[0];
                    double preco = Double.parseDouble(parts[1]);
                    int quantidade = Integer.parseInt(parts[2]); 
                    itens.add(new Item(nome, preco, quantidade));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        try {
            Files.createDirectories(Paths.get(outputDir));
        } catch (IOException e) {
            System.err.println("Error creating folder: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            for (Item item : itens) {
                bw.write(item.nome + "," + String.format("%.2f", item.getTotal()));
                bw.newLine();
            }
            System.out.println("File created in " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
