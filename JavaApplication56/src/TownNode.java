import java.util.ArrayList;
import java.util.List;
public class TownNode extends TreeNode {
    private String townCode;
    private String districtCode;
    private String townName;
    private int[] population;

    public TownNode() {
        this.townCode = "";
        this.districtCode = "";
        this.townName = "";
        this.population = new int[2];
    }

    public TownNode(String townCode, String districtCode, String townName, List<TreeNode> childs) {
        super(childs);
        this.townCode = townCode;
        this.districtCode = districtCode;
        this.townName = townName;
        this.population = new int[2];
        calcPopulationDFS();
    }

    public String getTownCode() {
        return townCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public String getTownName() {
        return townName.replaceAll("\\r|\\n", "");
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
    
    public boolean addChild(CitizenNode child) {
        if (child == null) return false;
        if (!child.getTownCode().equals(this.getTownCode())) return false;
        if (this.getChilds() == null) this.setChilds(new ArrayList<>());
        if (existCitizen(child.getCitizenCode())) return false;
        this.getChilds().add(child);
        return true;
    }
    
    private boolean existCitizen(String citizenCode) {
        if (this.getChilds() == null || this.getChilds().isEmpty()) return false;
        for (int i = 0; i < this.getChilds().size(); i++)
            if (((CitizenNode)this.getChilds().get(i)).getCitizenCode().equals(citizenCode))
                return true;
        return false;
    }
    
    public final int[] calcPopulationDFS() {
        if (this.getChilds() == null || this.getChilds().isEmpty()) {
            this.population[0] = 0;
            this.population[1] = 0;
            return this.population;
        }
        for (int i = 0; i < this.getChilds().size(); i++) {
            this.population[0] += ((CitizenNode)this.getChilds().get(i)).getPopulation();
            this.population[1] += ((CitizenNode)this.getChilds().get(i)).getAdultPopulation();
        }
        return this.population;
    }

    public int getPopulation() {
        return this.population[0];
    }

    public int getAdultPopulation() {
        return this.population[1];
    }
    
    @Override
    public String toString() {
        return this.getTownName();
    }
}
