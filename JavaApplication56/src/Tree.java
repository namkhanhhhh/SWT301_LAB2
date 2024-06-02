import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public Tree(TreeNode root) {
        this.root = root;
    }
    
    public void add(TreeNode node) {
        if (this.root == null) this.root = new TreeNode(new ArrayList<>());
        if (this.root.getChilds() == null) this.root.setChilds(new ArrayList<>());
        if (node == null) return;
        if (node instanceof CityNode) {
            this.root.getChilds().add(node);
            return;
        }
        if (node instanceof DistrictNode) {
            CityNode city = this.searchCity(((DistrictNode)node).getCityCode());
            if (city == null) return;
            city.addChild((DistrictNode)node);
            return;
        }
        if (node instanceof TownNode) {
            DistrictNode district = this.searchDistrict(((TownNode)node).getDistrictCode());
            if (district == null) return;
            district.addChild((TownNode)node);
            return;
        }
        if (node instanceof CitizenNode) {
            TownNode town = this.searchTown(((CitizenNode)node).getTownCode());
            if (town == null) return;
            town.addChild((CitizenNode)node);
        }
    }
    
    private CityNode searchCity(String cityCode) {
        if (this.root == null) {
            System.out.println("Empty tree");
            return null;
        }
        if (this.root.getChilds() == null || this.root.getChilds().isEmpty()) {
            System.out.println("Empty city list");
            return null;
        }
        for (int i = 0; i < this.root.getChilds().size(); i++) {
            CityNode city = (CityNode)this.root.getChilds().get(i);
            if (city.getCityCode().equals(cityCode))
                return city;
        }
        return null;
    }
    
    private DistrictNode searchDistrict(String districtCode) {
        if (this.root == null) {
            System.out.println("Empty tree");
            return null;
        }
        if (this.root.getChilds() == null || this.root.getChilds().isEmpty()) {
            System.out.println("Empty city list");
            return null;
        }
        for (int i = 0; i < this.root.getChilds().size(); i++) {
            CityNode city = (CityNode)this.root.getChilds().get(i);
            if (city.getChilds() == null || city.getChilds().isEmpty()) continue;
            for (int j = 0; j < city.getChilds().size(); j++) {
                DistrictNode district = (DistrictNode)city.getChilds().get(j);
                if (district.getDistrictCode().equals(districtCode))
                    return district;
            }
        }
        return null;
    }
    
    private TownNode searchTown(String townCode) {
        if (this.root == null) {
            System.out.println("Empty tree");
            return null;
        }
        if (this.root.getChilds() == null || this.root.getChilds().isEmpty()) {
            System.out.println("Empty city list");
            return null;
        }
        for (int i = 0; i < this.root.getChilds().size(); i++) {
            CityNode city = (CityNode)this.root.getChilds().get(i);
            if (city.getChilds() == null || city.getChilds().isEmpty()) continue;
            for (int j = 0; j < city.getChilds().size(); j++) {
                DistrictNode district = (DistrictNode)city.getChilds().get(j);
                if (district.getChilds() == null || district.getChilds().isEmpty()) continue;
                for (int k = 0; k < district.getChilds().size(); k++) {
                    TownNode town = (TownNode)district.getChilds().get(k);
                    if (town.getTownCode().equals(townCode))
                        return town;
                }
            }
        }
        return null;
    }
    
    private Info searchCitizen(String citizenCode) {
        if (this.root == null) return null;
        if (this.root.getChilds() == null) return null;
        String cityName, districtName, townName;
        for (int i = 0; i < this.root.getChilds().size(); i++) {
            CityNode city = (CityNode)this.root.getChilds().get(i);
            if (city.getChilds() == null) continue;
            cityName = city.getCityName();
            for (int j = 0; j < city.getChilds().size(); j++) {
                DistrictNode district = (DistrictNode)city.getChilds().get(j);
                if (district.getChilds() == null) continue;
                districtName = district.getDistrictName();
                for (int k = 0; k < district.getChilds().size(); k++) {
                    TownNode town = (TownNode)district.getChilds().get(k);
                    if (town.getChilds() == null) continue;
                    townName = town.getTownName();
                    for (int l = 0; l < town.getChilds().size(); l++) {
                        CitizenNode citizen = (CitizenNode)town.getChilds().get(l);
                        if (citizen.getCitizenCode().equals(citizenCode))
                            return new Info(cityName, districtName, townName, citizen.getCitizenName());
                    }
                }
            }
        }
        return null;
    }
    
    public void findCitizenInformation(String citizenCode) {
        Info info = this.searchCitizen(citizenCode);
        if (info == null) {
            System.out.println("Not found.");
            return;
        }
        System.out.println("Found:");
        System.out.println(info);
    }
    
    public void report() {
        if (this.root == null) {
            System.out.println("Empty tree");
            return;
        }
        if (this.root.getChilds() == null) {
            System.out.println("Empty city list");
            return;
        }
        String report = "";
        for (int i = 0; i < this.root.getChilds().size(); i++) {
            CityNode city = (CityNode)this.root.getChilds().get(i);
            city.calcPopulationDFS();
            report += city.toString() + ": " + city.getPopulation() + " people, " + city.getAdultPopulation() + " above 18.\n";
            if (city.getChilds() == null || city.getChilds().isEmpty()) continue;
            for (int j = 0; j < city.getChilds().size(); j++) {
                DistrictNode district = (DistrictNode)city.getChilds().get(j);
                report += "\t" + district.toString() + ": " + district.getPopulation() + " people, " + district.getAdultPopulation() + " above 18.\n";
                if (district.getChilds() == null || district.getChilds().isEmpty()) continue;
                for (int k = 0; k < district.getChilds().size(); k++) {
                    TownNode town = (TownNode)district.getChilds().get(k);
                    report += "\t\t" + town.toString() + ": " + town.getPopulation() + " people, " + town.getAdultPopulation() + " above 18.\n";
                }
            }
        }
        saveReport(report);
        System.out.println("Saved report to report.txt");
    }
    
    private void saveReport(String report) {
        try (FileOutputStream file = new FileOutputStream("report.txt")) {
            file.write(report.getBytes());
            System.out.println("Save successfully.");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
