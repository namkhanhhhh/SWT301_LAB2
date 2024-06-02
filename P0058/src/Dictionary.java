import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dict;
    Validation validation = new Validation();

    public Dictionary() throws IOException {
        dict = new HashMap<>();
        loadData();
    }

    public Map<String, String> getMap() {
        return dict;
    }

    private void loadData() throws IOException {
        File f = new File("dictionary.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] words = line.split("[-]");
            String eng = words[0].trim();
            String vi = words[1].trim();
            dict.put(eng, vi);
        }
        br.close();
        fr.close();
    }

    private void updateDatabase() throws IOException {
        File f = new File("dictionary.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<String, String> entry : dict.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue() + "\n");
        }
        bw.close();
        fw.close();
    }

    public boolean addWord(String eng, String vi) throws IOException {
        if (dict.containsKey(eng)) {
            return false;
        }
        dict.put(eng, vi);
        updateDatabase();
        return true;
    }

    public boolean removeWord(String eng) throws IOException {
        if (!dict.containsKey(eng)) {
            return false;
        }
        dict.remove(eng);
        updateDatabase();
        return true;
    }

    public String translate(String eng) {
        return dict.get(eng);
    }
}
