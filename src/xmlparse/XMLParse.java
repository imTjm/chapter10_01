package xmlparse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * XML解析 演示案列1
 * @author Administrator
 *
 */
public class XMLParse {
	Document doc = null;
	//获取DOM树
	public void getDocument(){
		//1.获取解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//2.获取解析器
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			//3.加载DOM树
			doc = builder.parse("收藏信息.xml");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 	显示XML中所有信息
	 */
	public void showInfo(){
		//获取<Brand>的所有节点集合
		NodeList nodeList = doc.getElementsByTagName("Brand");
		for(int i=0;i<nodeList.getLength();i++){
			Node brand = nodeList.item(i);
			Element brandEle = (Element)brand;
			String brandStr = brandEle.getAttribute("name");
			NodeList types = brandEle.getChildNodes();
			for(int j=0;j<types.getLength();j++){
				Node type = types.item(j);
				if(type.getNodeType()==Node.ELEMENT_NODE){
					Element typeEle = (Element)type;
					String typeStr = typeEle.getAttribute("name");
					System.out.println("手机："+brandStr+typeStr);
				}
			}
			
		}
	}
	/**
	 * 保存XML信息
	 */
	public void saveInfo(){
		//1.创建转换工厂
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			//2.创建转换器
			Transformer former = factory.newTransformer();			
			DOMSource xmlSource = new DOMSource(doc);
			StreamResult outputTarget = new StreamResult(new FileOutputStream("新的收藏信息.xml"));
			//3.设置编码类型
			former.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			//4.把DOM树转换为XML文件
			former.transform(xmlSource, outputTarget);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除XML信息
	 */
	public void delInfo(){
		NodeList brands = doc.getElementsByTagName("Brand");
		//获取所有brand节点
		for(int i=0;i<brands.getLength();i++){
			Node brand = brands.item(i);
			Element brandEle = (Element)brand;
			//找到name属性值为SAMSUNG的节点，删除
			if(brandEle.getAttribute("name").equals("SAMSUNG")){
				//调用父节点的removeChild（）方法删除
				brandEle.getParentNode().removeChild(brandEle);
			}
		}
	}
	/**
	 * 更新XML信息
	 */
	public void updateInfo(){
		//获取所有brand节点
		NodeList brands = doc.getElementsByTagName("Brand");
		for(int i=0;i<brands.getLength();i++){
			Node brand = brands.item(i);
			Element brandEle = (Element)brand;
			//如果name属性值为三星，则进行修改
			if(brandEle.getAttribute("name").equals("三星")){
				brandEle.setAttribute("name", "SAMSUNG");
			}
		}
	}
	
	/**
	 * 添加节点
	 */
	public void addInfo(){
		//1.创建新节点，并设置name属性
		Element newEle = doc.createElement("Brand");
		newEle.setAttribute("name", "三星");
		//创建Type节点
		Element newType = doc.createElement("Type");
		newType.setAttribute("name", "NoteX");
		newEle.appendChild(newType);
		Element phoneElement = (Element)doc.getElementsByTagName("PhoneInfo").item(0);
		//2.把节点加到其父节点上
		phoneElement.appendChild(newEle);		
	}
	
	public static void main(String[] args) {
		XMLParse parse = new XMLParse();
		parse.getDocument();
		parse.addInfo();
		parse.updateInfo();
		parse.delInfo();
		parse.showInfo();
//		parse.saveInfo();
				
	}
}
