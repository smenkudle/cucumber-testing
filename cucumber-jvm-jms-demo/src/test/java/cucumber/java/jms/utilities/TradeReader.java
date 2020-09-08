package cucumber.java.jms.utilities;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.xml.sax.SAXException;

import cucumber.java.jms.Trade;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

public class TradeReader {
	String dataXLS;
	public TradeReader(String workbookName) {
		dataXLS ="/cucumber/java/jms/data/" + workbookName;
	}

	public List<Trade> getTrades() throws IOException, SAXException, InvalidFormatException {
		String xmlConfig = "/cucumber/java/jms/jxls-reader/trade-data.xml";
		InputStream inputXML = new BufferedInputStream(getClass().getResourceAsStream(xmlConfig));
        XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
		InputStream inputXLS = new BufferedInputStream(getClass().getResourceAsStream(dataXLS));
        List<Trade> trades = new ArrayList<Trade>();
        Map<String, Object> beans = new HashMap<String, Object>();
        beans.put("trades", trades);
        XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
        readStatus.getReadMessages();
        return trades;
	}

}
