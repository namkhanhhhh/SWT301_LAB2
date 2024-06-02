import java.util.ArrayList;
import java.util.List;
public class CityNode extends TreeNode {
    private String cityCode;
    private String cityName;
    private int[] population;

    public CityNode() {
        this.cityCode = "";
        this.cityName = "";
        this.population = new int[2];
    }

    public CityNode(String cityCode, String cityName, List<TreeNode> childs) {
        super(childs);
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.population = new int[2];
        calcPopulationDFS();
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName.replaceAll("\\r|\\n", "");
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    public boolean addChild(DistrictNode child) {
        if (child == null) return false;
        if (!child.getCityCode().equals(this.getCityCode())) return false;
        if (this.getChilds() == null) this.setChilds(new ArrayList<>());
        if (existDistrict(child.getDistrictCode())) return false;
        this.getChilds().add(child);
        return true;
    }
    
    private boolean existDistrict(String districtCode) {
        if (this.getChilds() == null || this.getChilds().isEmpty()) return false;
        for (int i = 0; i < this.getChilds().size(); i++)
            if (((DistrictNode)this.getChilds().get(i)).getDistrictCode().equals(districtCode))
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
            int[] temp = ((DistrictNode)this.getChilds().get(i)).calcPopulationDFS();
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
        return this.getCityName();
    }
}
