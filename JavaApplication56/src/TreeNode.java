import java.util.List;
public class TreeNode {
    private List<TreeNode> childs;

    public TreeNode() {
        this.childs = null;
    }

    public TreeNode(List<TreeNode> childs) {
        this.childs = childs;
    }

    public List<TreeNode> getChilds() {
        return childs;
    }

    public void setChilds(List<TreeNode> childs) {
        this.childs = childs;
    }
}
