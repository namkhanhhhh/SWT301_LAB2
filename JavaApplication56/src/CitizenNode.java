import java.util.List;
public class CitizenNode extends TreeNode {
    private String townCode;
    private String citizenCode;
    private String citizenName;
    private String citizenDob;
    private boolean above18;

    public CitizenNode() {
        this.townCode = "";
        this.citizenCode = "";
        this.citizenName = "";
        this.citizenDob = "";
        this.above18 = false;
    }

    public CitizenNode(String townCode, String citizenCode, String citizenName, String citizenDob, List<TreeNode> childs) {
        super(childs);
        this.townCode = townCode;
        this.citizenCode = citizenCode;
        this.citizenName = citizenName;
        this.citizenDob = citizenDob;
        this.above18 = checkAbove18();
    }

    public String getCitizenCode() {
        return citizenCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public String getCitizenDob() {
        return citizenDob.replaceAll("\\r|\\n", "");
    }

    public void setCitizenCode(String citizenCode) {
        this.citizenCode = citizenCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public void setCitizenDob(String citizenDob) {
        this.citizenDob = citizenDob;
        this.above18 = checkAbove18();
    }

    public boolean isAbove18() {
        return above18;
    }
    
    private boolean checkAbove18() {
        return 2023 - Integer.parseInt(this.getCitizenDob().split("/")[2]) >= 18;
    }

    public int getPopulation() {
        return 1;
    }

    public int getAdultPopulation() {
        return this.isAbove18() ? 1 : 0;
    }

    @Override
    public String toString() {
        return this.getCitizenName();
    }
}
