package xmlparse.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import xmlparse.entity.Item;

public class Test {

	public static void main(String[] args) {
		int num = 0;
		for (Item item : showItem())
			System.out.println((++num) + "\t" + item.getPubDate() + "\t" + item.getTitle());
	}

	public static List<Item> showItem() {
		try {
			// 1、得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2、从DOM工厂获得DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3、解析XML文档，得到一个Document，即DOM树
			Document doc = db.parse("src/网易手机各地行情.xml");
			// 4、读取新闻
			NodeList list = doc.getElementsByTagName("item");

			ArrayList<Item> itemList = new ArrayList<Item>();
			for (int i = 0; i < list.getLength(); i++) {
				Item item = new Item();

				Element itemElement = (Element) list.item(i);
				String title = itemElement.getElementsByTagName("title").item(0).getFirstChild().getNodeValue();
				String description = itemElement.getElementsByTagName("description").item(0).getFirstChild()
						.getNodeValue();
				String link = itemElement.getElementsByTagName("link").item(0).getFirstChild().getNodeValue();
				String pubDate = itemElement.getElementsByTagName("pubDate").item(0).getFirstChild().getNodeValue();

				item.setDescription(description);
				item.setLink(link);
				item.setPubDate(pubDate);
				item.setTitle(title);

				itemList.add(item);

			}
			return itemList;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
