package person.yejing.wordtemplate.easypoi;

import cn.afterturn.easypoi.word.WordExportUtil;
import cn.afterturn.easypoi.word.entity.params.ExcelListEntity;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import person.yejing.wordtemplate.model.DataFrame;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordExportTest {

    @Test
    void simpleWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("maplist", DataFrame.funds);
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