package json2obj;

import java.util.List;

public class Questions {

	private String content;
	private Material material;
	private List<Accessories> accessories;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public List<Accessories> getAccessories() {
		return accessories;
	}
	public void setAccessories(List<Accessories> accessories) {
		this.accessories = accessories;
	}
	
}
