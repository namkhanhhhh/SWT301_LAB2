import java.util.ArrayList;
import java.util.List;
public class DistrictNode extends TreeNode {
    private String districtCode;
    private String cityCode;
    private String districtName;
    private int[] population;

    public DistrictNode() {
        this.districtCode = "";
        this.cityCode = "";
        this.districtName = "";
        this.population = new int[2];
    }

    public DistrictNode(String districtCode, String cityCode, String districtName, List<TreeNode> childs) {
        super(childs);
        this.districtCode = districtCode;
        this.cityCode = cityCode;
        this.districtName = districtName;
        this.population = new int[2];
        calcPopulationDFS();
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getDistrictName() {
        return districtName.replaceAll("\\r|\\n", "");
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    
    public boolean addChild(TownNode child) {
        if (child == null) return false;
        if (!child.getDistrictCode().equals(this.getDistrictCode())) return false;
        if (this.getChilds() == null) this.setChilds(new ArrayList<>());
        if (existTown(child.getTownCode())) return false;
        this.getChilds().add(child);
        return true;
    }
    
    private boolean existTown(String townCode) {
        if (this.getChilds() == null || this.getChilds().isEmpty()) return false;
        for (int i = 0; i < this.getChilds().size(); i++)
            if (((TownNode)this.getChilds().get(i)).getTownCode().equals(townCode))
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
            int[] temp = ((TownNode)this.getChilds().get(i)).calcPopulationDFS();
            this.population[0] += temp[0];
            this.population[1] += temp[1];
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
        return this.getDistrictName();
    }
}
