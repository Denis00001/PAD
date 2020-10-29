package OtherClasses;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;


public class DataParserManager {
    private Document doc;
    private String stringData;

    public DataParserManager(String stringData) {
        this.stringData=stringData;
    }

    public List<String>getReceivers() {
        List<String>rec=new ArrayList<>();
        for(int i=0;i<doc.getChildNodes().item(0).getChildNodes().getLength();i++)
            rec.add(i,doc.getChildNodes().item(0).getChildNodes().item(i).getTextContent());

        return rec;
    }

    public String getMessage() {

        return doc.getChildNodes().item(0).getAttributes().getNamedItem("text").getTextContent();//get attr
    }

    public boolean CheckIfXml(){
        try
        {
            DocumentBuilderFactory documentBuildFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder doccumentBuilder = documentBuildFactory.newDocumentBuilder();
            doc = doccumentBuilder.parse(new ByteArrayInputStream(stringData.getBytes()));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}

