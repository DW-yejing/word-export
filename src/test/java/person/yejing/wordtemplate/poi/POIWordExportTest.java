package person.yejing.wordtemplate.poi;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class POIWordExportTest {

    @Test
    void simpleWordExport() throws Exception {

        FileInputStream is = new FileInputStream("F:\\workspace_exercise\\word-template\\src\\test\\resources\\poi.docx");//读入流中
        XWPFDocument xdf = new XWPFDocument(is);//新建一个word文档

        //变量
        Map<String, Object> map1 = new HashMap<>();
        map1.put("item1", "来源预算合计");
        map1.put("item2", "100");
        map1.put("item3", "支出预算合计");
        map1.put("item4", "100");
        map1.put("item5", "0.0");
        map1.put("item6", "100");

        this.replaceText(xdf,map1);
    }

    /**
     * 替换文档中的参数（word）
     * @param doc
     * @param params
     */
    private  void replaceText(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            this.replaceInPara(para, params);
        }
    }

    /**
     * 替换段落中的参数（word）
     * @param para
     * @param params
     */
    private  void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        if (matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();
            for (int i=0; i<runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                matcher = matcher(runText);
                if (matcher.find()) {
                    while ((matcher = matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                    }
                    para.removeRun(i);
                    //重新插入run里内容格式可能与原来模板的格式不一致
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }
    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }
}