package person.yejing.wordtemplate.easypoi;

import cn.afterturn.easypoi.word.WordExportUtil;
import cn.afterturn.easypoi.word.entity.params.ExcelListEntity;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import person.yejing.wordtemplate.model.DataFrame;
import person.yejing.wordtemplate.model.Male;
import person.yejing.wordtemplate.model.Person;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordExportTest {

    @Test
    void simpleWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        Person person = new Person();
        Male male= new Male();
        male.age="18";
        male.name = "yejing";
        person.male = male;
        person.other = "武汉加油";
        map.put("maplist", DataFrame.funds);
        map.put("wrappedObj", person);
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "easy_poi.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/easypoi_simple.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}