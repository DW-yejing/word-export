package person.yejing.wordtemplate.poitl;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.RowRenderData;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PoitlWordExportTest {
    @Test
    public void SimpleWordExport() throws Exception{
        Map<String, Object> datas = new HashMap<String, Object>();
        RowRenderData row1 = RowRenderData.build("来源预算合计", "100", "支出预算合计", "100", "0.0", "100");
        RowRenderData row2 = RowRenderData.build("一、甲方拨款", "100", "一、直接费", "74.824", "0.0", "74.824");
        MiniTableRenderData miniTableRenderData = new MiniTableRenderData(Arrays.asList(row1, row2), 8.00f);
        datas.put("maplist", miniTableRenderData);
        datas.put("budget", "预算");
        XWPFTemplate template = XWPFTemplate.compile("F:\\workspace_exercise\\word-template\\src\\test\\resources\\poitl.docx").render(datas);

        FileOutputStream out = new FileOutputStream("D:/excel/poitl.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }

}