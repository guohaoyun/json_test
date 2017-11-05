package json2obj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Test {
	public static void main(String[] args) throws IOException {
		//temp.json文件放到项目下，即与src和pom.xml同一目录
		BufferedReader br = new BufferedReader(new FileReader("temp.json"));
		String line = null;
		StringBuilder json = new StringBuilder();
		while((line=br.readLine()) != null){
			json.append(line);
		}
		
		//因为这个json文件是一个数组，里面每一个{}都是一道题，所以先将json文件转成一个个的Questions实体
		List<Questions> list = JSON.parseArray(json.toString(), Questions.class);
		
		for(Questions q : list){
			//因为题目的材料可能为null，所以需要先判断是否为空，将[p][/p]去除
			String meterial = q.getMaterial() == null ? null : q.getMaterial().getContent().replaceAll("\\[\\/?p\\]", "");//材料
			//将题目中的[u][/u]变为下划线,并将[p][/p]去除
			String content = q.getContent().replaceAll("\\[u\\].*?\\[/u\\]", "___").replaceAll("\\[\\/?p\\]", "");//题目
			Accessories accessorie = q.getAccessories().get(0);//选项
			
			//依次打印材料、题目、选项
			if(meterial != null){
				System.out.println("材料:"+meterial);
			}
			
			System.out.println(content);
			for(int i=0;i<4;i++){
				System.out.println((char)('A'+i)+". "+accessorie.getOptions()[i]);
			}
		}
		
		br.close();
		
	}
}
